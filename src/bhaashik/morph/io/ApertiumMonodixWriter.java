package bhaashik.morph.io;

import bhaashik.morph.algorithm.LongestCommonPrefixStrategy;
import bhaashik.morph.algorithm.StemExtractionStrategy;
import bhaashik.morph.model.*;
import bhaashik.morph.util.TAMMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Writer for Apertium monodix (.dix) XML format.
 * Uses proper stem extraction algorithms and supports paradigm definitions.
 *
 * Correctly implements Apertium's <l> and <r> semantics:
 * - <l> (left): surface form suffix - used for ANALYSIS (surface → lemma+tags)
 * - <r> (right): morphological tags - used for GENERATION (lemma+tags → surface)
 */
public class ApertiumMonodixWriter implements DictionaryWriter {

    private StemExtractionStrategy stemExtractor;
    private TAMMapper tamMapper;
    private boolean includeAlphabet = true;
    private String scriptName = "Devanagari"; // Default for Indic languages
    private VibhaktiHandling vibhaktiHandling = VibhaktiHandling.ATTACHED; // Default

    /**
     * Enum for vibhakti (case marker) handling modes.
     */
    public enum VibhaktiHandling {
        /** Vibhakti is attached to the word (e.g., घरमें, लड़कावा) - common in Bhojpuri/Magahi/Maithili */
        ATTACHED,

        /** Vibhakti is a separate word (e.g., घर में) - common in Hindi */
        SEPARATE,

        /** Auto-detect based on feature structure or data */
        AUTO
    }

    // Unicode ranges for common Indic scripts
    private static final Map<String, int[]> SCRIPT_RANGES = new HashMap<>();
    static {
        SCRIPT_RANGES.put("Devanagari", new int[]{0x0900, 0x097F});
        SCRIPT_RANGES.put("Bengali", new int[]{0x0980, 0x09FF});
        SCRIPT_RANGES.put("Gurmukhi", new int[]{0x0A00, 0x0A7F});
        SCRIPT_RANGES.put("Gujarati", new int[]{0x0A80, 0x0AFF});
        SCRIPT_RANGES.put("Oriya", new int[]{0x0B00, 0x0B7F});
        SCRIPT_RANGES.put("Tamil", new int[]{0x0B80, 0x0BFF});
        SCRIPT_RANGES.put("Telugu", new int[]{0x0C00, 0x0C7F});
        SCRIPT_RANGES.put("Kannada", new int[]{0x0C80, 0x0CFF});
        SCRIPT_RANGES.put("Malayalam", new int[]{0x0D00, 0x0D7F});
    }

    public ApertiumMonodixWriter() {
        // Default to LCP strategy (most common for Indic languages)
        this.stemExtractor = new LongestCommonPrefixStrategy();
        this.tamMapper = null;
    }

    public void setStemExtractionStrategy(StemExtractionStrategy strategy) {
        this.stemExtractor = strategy;
    }

    public void setTAMMapper(TAMMapper mapper) {
        this.tamMapper = mapper;
    }

    public void setIncludeAlphabet(boolean include) {
        this.includeAlphabet = include;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public void setVibhaktiHandling(VibhaktiHandling handling) {
        this.vibhaktiHandling = handling;
    }

    /**
     * Helper class to represent a unique pardef with stem/suffix split.
     */
    private static class PardefInfo {
        final String pardefName;      // Format: stem/lemma_suffix__category
        final String stem;
        final String lemmaSuffix;
        final String categoryName;
        final SpecificParadigm paradigm;
        final ParCatFeatureStructures featureStructures;

        PardefInfo(String stem, String lemmaSuffix, String categoryName,
                   SpecificParadigm paradigm, ParCatFeatureStructures featureStructures) {
            this.stem = stem;
            this.lemmaSuffix = lemmaSuffix;
            this.categoryName = categoryName;
            // Format: stem/suffix__category (or just stem__category if suffix is empty)
            if (lemmaSuffix.isEmpty()) {
                this.pardefName = stem + "__" + categoryName;
            } else {
                this.pardefName = stem + "/" + lemmaSuffix + "__" + categoryName;
            }
            this.paradigm = paradigm;
            this.featureStructures = featureStructures;
        }
    }

    @Override
    public void writeDictionary(File outputFile, List<ParadigmCategory> categories,
                               ParadigmCategoryToFSSetMap fsMap, List<LexiconEntry> lexicon) throws IOException {

        try (FileWriter writer = new FileWriter(outputFile)) {
            writeHeader(writer);

            if (includeAlphabet) {
                Set<Character> alphabet = collectAlphabetFromUnicodeBlockAndData(categories, lexicon);
                writeAlphabet(writer, alphabet);
            }

            writeSymbolDefinitions(writer, fsMap);

            // CORRECT APPROACH: One pardef per paradigm category with stem/suffix naming
            writeParadigmDefinitionsWithStemSuffix(writer, categories, fsMap);

            // Extract stems for lexicon entries and write with stem-only format
            writeMainSectionWithStems(writer, categories, lexicon);

            writeFooter(writer);
        }

        System.out.println("✓ Exported Apertium monodix to: " + outputFile.getAbsolutePath());
    }

    /**
     * Helper method to find longest common prefix between two strings.
     */
    private int findLCP(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLen && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return i;
    }

    /**
     * Extracts stem from a paradigm by finding the longest common prefix of ALL its word forms.
     * This is the correct approach according to Apertium best practices.
     *
     * @param paradigm the paradigm to extract stem from
     * @return the stem (common prefix of all word forms)
     */
    private String extractStemFromParadigm(SpecificParadigm paradigm) {
        if (paradigm == null || paradigm.getWordForms().isEmpty()) {
            return "";
        }

        // Start with the lemma as the initial stem candidate
        String stem = paradigm.getLemma().getLemmaString();

        // Find longest common prefix with all word forms
        for (WordForm wf : paradigm.getWordForms()) {
            for (String variant : wf.getVariants()) {
                if (variant != null && !variant.isEmpty()) {
                    int lcp = findLCP(stem, variant);
                    stem = stem.substring(0, lcp);
                }
            }
        }

        return stem;
    }

    /**
     * NEW CORRECT APPROACH: Extracts stems for all lexicon entries and groups them by
     * unique stem/suffix/category combinations.
     *
     * This implements the Apertium standard format where:
     * - Each pardef represents a unique stem/suffix split pattern
     * - Multiple lexicon entries can share the same pardef if they have the same stem/suffix/category
     *
     * @param categories list of paradigm categories
     * @param fsMap feature structure map
     * @param lexicon list of lexicon entries
     * @return map of pardef name → PardefInfo with grouped entries
     */
    private Map<String, PardefInfo> extractStemsAndGroupPardefs(
            List<ParadigmCategory> categories, ParadigmCategoryToFSSetMap fsMap,
            List<LexiconEntry> lexicon) {

        // Map: pardef name → PardefInfo (using inner class)
        Map<String, PardefInfo> pardefs = new LinkedHashMap<>();

        // Create lookup maps for efficiency
        Map<String, ParadigmCategory> categoryMap = new HashMap<>();
        for (ParadigmCategory cat : categories) {
            categoryMap.put(cat.getCategoryName(), cat);
        }

        // Extract stem for each paradigm category (cache for reuse)
        Map<String, String> categoryStemMap = new HashMap<>();
        for (ParadigmCategory category : categories) {
            if (!category.getParadigms().isEmpty()) {
                SpecificParadigm paradigm = category.getParadigms().get(0);
                String stem = extractStemFromParadigm(paradigm);
                categoryStemMap.put(category.getCategoryName(), stem);
            }
        }

        // Process each lexicon entry
        for (LexiconEntry entry : lexicon) {
            String lemma = entry.getLemma();
            String categoryName = entry.getParadigmCategory();

            ParadigmCategory category = categoryMap.get(categoryName);
            if (category == null || category.getParadigms().isEmpty()) {
                System.out.println("⚠ Warning: No paradigm found for category: " + categoryName);
                continue;
            }

            ParCatFeatureStructures parCatFS = fsMap.getParadigmCategoryFSSet(categoryName);
            if (parCatFS == null) {
                System.out.println("⚠ Warning: No feature structures for category: " + categoryName);
                continue;
            }

            // Get the paradigm's stem pattern
            String paradigmStem = categoryStemMap.get(categoryName);
            if (paradigmStem == null) {
                paradigmStem = "";
            }

            // Calculate stem for this lexicon entry
            // Strategy: use the same stem length ratio as the paradigm
            SpecificParadigm paradigm = category.getParadigms().get(0);
            String paradigmLemma = paradigm.getLemma().getLemmaString();

            String entryStem;
            String entryLemmaSuffix;

            if (paradigmStem.isEmpty()) {
                // Paradigm has no stem (all suffix) - use full lemma as suffix
                entryStem = "";
                entryLemmaSuffix = lemma;
            } else if (paradigmStem.equals(paradigmLemma)) {
                // Paradigm has no suffix (all stem) - use full lemma as stem
                entryStem = lemma;
                entryLemmaSuffix = "";
            } else {
                // Calculate stem length based on paradigm's ratio
                int paradigmStemLen = paradigmStem.length();
                int paradigmLemmaLen = paradigmLemma.length();

                // Apply same split ratio to lexicon entry
                // But ensure the split point makes sense for this entry
                if (lemma.length() >= paradigmStemLen) {
                    entryStem = lemma.substring(0, paradigmStemLen);
                    entryLemmaSuffix = lemma.substring(paradigmStemLen);
                } else {
                    // Entry is shorter than paradigm stem - use full lemma as stem
                    entryStem = lemma;
                    entryLemmaSuffix = "";
                }
            }

            // Store stem and suffix in the entry for later use
            entry.setStem(entryStem);
            entry.setLemmaSuffix(entryLemmaSuffix);

            // Generate pardef name: stem/lemmaSuffix__category
            String pardefName = entry.getPardefName();
            if (pardefName == null) {
                System.out.println("⚠ Warning: Could not generate pardef name for entry: " + lemma);
                continue;
            }

            // Group entries by pardef name
            if (!pardefs.containsKey(pardefName)) {
                PardefInfo pardefInfo = new PardefInfo(
                        entryStem, entryLemmaSuffix, categoryName, paradigm, parCatFS);
                pardefs.put(pardefName, pardefInfo);
            }
        }

        System.out.println("✓ Grouped " + lexicon.size() + " entries into " + pardefs.size() + " unique pardefs");

        return pardefs;
    }

    /**
     * OLD APPROACH - Generates PardefInfo for each unique stem/suffix combination in the lexicon.
     * This creates too many pardefs (one per lexicon entry) - NOT RECOMMENDED.
     */
    private Map<String, PardefInfo> generatePardefInfoForLexicon(
            List<ParadigmCategory> categories, ParadigmCategoryToFSSetMap fsMap,
            List<LexiconEntry> lexicon) {

        Map<String, PardefInfo> pardefs = new LinkedHashMap<>();

        // Create a lookup map for categories
        Map<String, ParadigmCategory> categoryMap = new HashMap<>();
        for (ParadigmCategory cat : categories) {
            categoryMap.put(cat.getCategoryName(), cat);
        }

        for (LexiconEntry entry : lexicon) {
            String lemma = entry.getLemma();
            String categoryName = entry.getParadigmCategory();

            ParadigmCategory category = categoryMap.get(categoryName);
            if (category == null || category.getParadigms().isEmpty()) {
                System.out.println("⚠ Warning: No paradigm found for category: " + categoryName);
                continue;
            }

            ParCatFeatureStructures parCatFS = fsMap.getParadigmCategoryFSSet(categoryName);
            if (parCatFS == null) {
                System.out.println("⚠ Warning: No feature structures for category: " + categoryName);
                continue;
            }

            // Use first paradigm as template (could match by specific paradigm name if needed)
            SpecificParadigm paradigm = category.getParadigms().get(0);
            String paradigmLemma = paradigm.getLemma().getLemmaString();

            // Extract stem by finding longest common prefix of lexicon lemma and paradigm lemma
            // This handles cases where the lexicon lemma should follow the same morphological
            // pattern as the paradigm template
            int lemmaLCP = findLCP(lemma, paradigmLemma);

            String entryStem;
            String entryLemmaSuffix;

            // If there's meaningful overlap (at least 2 characters) between lexicon and paradigm lemmas,
            // use paradigm's stem-suffix ratio. Otherwise, treat lexicon lemma as non-decomposable.
            if (lemmaLCP >= 2 && lemmaLCP < Math.min(lemma.length(), paradigmLemma.length())) {
                // Calculate paradigm's stem from its own lemma and inflected forms
                String paradStem = paradigmLemma;
                for (WordForm wf : paradigm.getWordForms()) {
                    for (String variant : wf.getVariants()) {
                        int lcp = findLCP(paradStem, variant);
                        paradStem = paradStem.substring(0, lcp);
                    }
                }

                // Apply similar stem-suffix split to lexicon lemma
                int paradStemLen = paradStem.length();
                if (paradStemLen > 0 && paradStemLen < lemma.length()) {
                    entryStem = lemma.substring(0, paradStemLen);
                    entryLemmaSuffix = lemma.substring(paradStemLen);
                } else {
                    // Paradigm stem extraction failed, use full lemma
                    entryStem = lemma;
                    entryLemmaSuffix = "";
                }
            } else {
                // No morphological relationship - use full lemma as stem
                entryStem = lemma;
                entryLemmaSuffix = "";
            }

            // Generate unique pardef name for this entry
            String pardefName;
            if (entryLemmaSuffix.isEmpty()) {
                pardefName = entryStem + "__" + categoryName;
            } else {
                pardefName = entryStem + "/" + entryLemmaSuffix + "__" + categoryName;
            }

            if (!pardefs.containsKey(pardefName)) {
                PardefInfo pardefInfo = new PardefInfo(
                    entryStem, entryLemmaSuffix, categoryName, paradigm, parCatFS);
                pardefs.put(pardefName, pardefInfo);
            }
        }

        System.out.println("✓ Generated " + pardefs.size() + " unique pardefs for " + lexicon.size() + " lexicon entries");
        return pardefs;
    }

    private void writeHeader(FileWriter writer) throws IOException {
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        writer.write("<!-- Morphological dictionary generated by Bhaashik Morph API -->\n");
        writer.write("<!-- Script: " + scriptName + " -->\n");
        writer.write("<!-- Vibhakti handling: " + vibhaktiHandling + " -->\n");
        writer.write("<!-- Using stem extraction: " + stemExtractor.getStrategyName() + " -->\n");
        writer.write("<dictionary>\n");
    }

    private void writeAlphabet(FileWriter writer, Set<Character> alphabet) throws IOException {
        writer.write("  <alphabet>");
        for (Character c : alphabet) {
            writer.write(c.toString());
        }
        writer.write("</alphabet>\n\n");
    }

    /**
     * Collects alphabet from Unicode block range first, then adds any additional characters
     * found in the data that aren't in the default range.
     */
    private Set<Character> collectAlphabetFromUnicodeBlockAndData(List<ParadigmCategory> categories,
                                                                  List<LexiconEntry> lexicon) {
        Set<Character> alphabet = new LinkedHashSet<>();

        // First, add all characters from the Unicode block for the script
        if (SCRIPT_RANGES.containsKey(scriptName)) {
            int[] range = SCRIPT_RANGES.get(scriptName);
            int start = range[0];
            int end = range[1];

            for (int codePoint = start; codePoint <= end; codePoint++) {
                alphabet.add((char) codePoint);
            }

            System.out.println("✓ Added " + (end - start + 1) + " characters from " + scriptName +
                             " Unicode block (U+" + Integer.toHexString(start).toUpperCase() +
                             " to U+" + Integer.toHexString(end).toUpperCase() + ")");
        }

        // Then add any additional characters from the actual data
        Set<Character> additionalChars = new LinkedHashSet<>();

        for (ParadigmCategory category : categories) {
            for (SpecificParadigm paradigm : category.getParadigms()) {
                collectAdditionalChars(alphabet, additionalChars, paradigm.getLemma().getLemmaString());
                for (WordForm wf : paradigm.getWordForms()) {
                    collectAdditionalChars(alphabet, additionalChars, wf.getForm());
                }
            }
        }

        for (LexiconEntry entry : lexicon) {
            collectAdditionalChars(alphabet, additionalChars, entry.getLemma());
        }

        if (!additionalChars.isEmpty()) {
            alphabet.addAll(additionalChars);
            System.out.println("✓ Added " + additionalChars.size() + " additional characters from data");
        }

        return alphabet;
    }

    private void collectAdditionalChars(Set<Character> alphabet, Set<Character> additionalChars, String str) {
        if (str != null) {
            for (char c : str.toCharArray()) {
                if (!Character.isWhitespace(c) && !alphabet.contains(c)) {
                    additionalChars.add(c);
                }
            }
        }
    }

    private void writeSymbolDefinitions(FileWriter writer, ParadigmCategoryToFSSetMap fsMap) throws IOException {
        writer.write("  <sdefs>\n");

        Set<String> symbols = new LinkedHashSet<>();

        // Collect all unique symbols from feature structures
        for (String catName : fsMap.getParadigmCategoryNames()) {
            ParCatFeatureStructures parCatFS = fsMap.getParadigmCategoryFSSet(catName);
            if (parCatFS != null) {
                for (FeatureStructureEntry entry : parCatFS.getEntries()) {
                    collectSymbolsFromFeatureStructure(entry.getFeatureStructure(), symbols);
                }
            }
        }

        // Write symbol definitions
        for (String symbol : symbols) {
            if (!symbol.equals("0") && !symbol.equals("any") && !symbol.isEmpty()) {
                writer.write("    <sdef n=\"" + escapeXml(symbol) + "\"/>\n");
            }
        }

        writer.write("  </sdefs>\n\n");
    }

    private void collectSymbolsFromFeatureStructure(FeatureStructure fs, Set<String> symbols) {
        if (!fs.getCategory().isEmpty()) symbols.add(fs.getCategory());
        if (!fs.getGender().isEmpty()) symbols.add(fs.getGender());
        if (!fs.getNumber().isEmpty()) symbols.add(fs.getNumber());
        if (!fs.getPerson().isEmpty()) symbols.add(fs.getPerson());
        if (!fs.getGrammaticalCase().isEmpty()) symbols.add(fs.getGrammaticalCase());

        // Vibhakti (case marker) - always included as a tag
        if (!fs.getVibhakti().isEmpty()) {
            symbols.add(fs.getVibhakti());
        }

        // TAM with mapping if available
        String tam = fs.getTam();
        if (!tam.isEmpty()) {
            symbols.add(tamMapper != null && tamMapper.hasMapping(tam) ? tamMapper.map(tam) : tam);
        }

        // Additional features - add both keys and values as symbols
        for (Map.Entry<String, String> entry : fs.getAdditionalFeatures().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            // Add the feature name itself as a symbol (e.g., "emph", "mood", "rdp")
            if (!key.isEmpty() && !key.equals("af")) {
                symbols.add(key);
            }
            // Also add the value if it's not just a flag like 'y'
            if (!value.isEmpty() && !value.equals("y") && !value.equals("n")) {
                symbols.add(value);
            }
        }
    }

    /**
     * NEW: Writes paradigm definitions with proper stem/suffix split format.
     */
    private void writeParadigmDefinitionsNew(FileWriter writer, Map<String, PardefInfo> pardefs) throws IOException {
        writer.write("  <pardefs>\n");

        for (PardefInfo pardefInfo : pardefs.values()) {
            writeParadigmDefinitionNew(writer, pardefInfo);
        }

        writer.write("  </pardefs>\n\n");
    }

    /**
     * NEW: Writes a single pardef with stem/suffix split and variant support.
     */
    private void writeParadigmDefinitionNew(FileWriter writer, PardefInfo pardefInfo) throws IOException {
        writer.write("    <pardef n=\"" + escapeXml(pardefInfo.pardefName) + "\">\n");

        SpecificParadigm paradigm = pardefInfo.paradigm;
        String paradigmLemma = paradigm.getLemma().getLemmaString();
        List<WordForm> wordForms = paradigm.getWordForms();
        List<FeatureStructureEntry> fsEntries = new ArrayList<>(pardefInfo.featureStructures.getEntries());

        int formCount = Math.min(wordForms.size(), fsEntries.size());

        for (int i = 0; i < formCount; i++) {
            WordForm wf = wordForms.get(i);
            FeatureStructureEntry fsEntry = fsEntries.get(i);
            FeatureStructure fs = fsEntry.getFeatureStructure();

            // Handle variants - generate multiple <e> entries for each variant
            for (String variant : wf.getVariants()) {
                // Extract suffix from this variant relative to the STEM
                // This ensures <l> is never empty for valid word forms
                String inflectedSuffix;
                if (variant.startsWith(pardefInfo.stem)) {
                    inflectedSuffix = variant.substring(pardefInfo.stem.length());
                } else {
                    // Fallback: variant doesn't start with stem, use full variant
                    // This handles irregular forms
                    inflectedSuffix = variant;
                }

                writer.write("      <e>\n");
                writer.write("        <p>\n");

                // <l> = surface form suffix (for ANALYSIS)
                writer.write("          <l>" + escapeXml(inflectedSuffix) + "</l>\n");

                // <r> = lemma_suffix + morphological tags (for GENERATION)
                writer.write("          <r>" + escapeXml(pardefInfo.lemmaSuffix));
                writer.write(generateTagsFromFeatureStructure(fs));
                writer.write("</r>\n");

                writer.write("        </p>\n");
                writer.write("      </e>\n");
            }
        }

        writer.write("    </pardef>\n");
    }

    /**
     * OLD method - kept for reference, can be removed after testing.
     */
    private void writeParadigmDefinitions(FileWriter writer, List<ParadigmCategory> categories,
                                         ParadigmCategoryToFSSetMap fsMap) throws IOException {
        writer.write("  <pardefs>\n");

        for (ParadigmCategory category : categories) {
            String catName = category.getCategoryName();
            ParCatFeatureStructures parCatFS = fsMap.getParadigmCategoryFSSet(catName);

            if (parCatFS == null || category.getParadigms().isEmpty()) {
                continue;
            }

            writeParadigmDefinition(writer, category, parCatFS);
        }

        writer.write("  </pardefs>\n\n");
    }

    private void writeParadigmDefinition(FileWriter writer, ParadigmCategory category,
                                        ParCatFeatureStructures parCatFS) throws IOException {

        String pardefName = category.getCategoryName();
        writer.write("    <pardef n=\"" + escapeXml(pardefName) + "\">\n");

        // Use first paradigm as template for the category
        if (category.getParadigms().isEmpty()) {
            writer.write("    </pardef>\n");
            return;
        }

        SpecificParadigm templateParadigm = category.getParadigms().get(0);
        String lemma = templateParadigm.getLemma().getLemmaString();
        List<WordForm> wordForms = templateParadigm.getWordForms();
        List<FeatureStructureEntry> fsEntries = new ArrayList<>(parCatFS.getEntries());

        int formCount = Math.min(wordForms.size(), fsEntries.size());

        for (int i = 0; i < formCount; i++) {
            WordForm wf = wordForms.get(i);
            FeatureStructureEntry fsEntry = fsEntries.get(i);
            FeatureStructure fs = fsEntry.getFeatureStructure();

            // Handle all variants for this word form
            for (String variant : wf.getVariants()) {
                // Use stem extraction strategy to get the suffix
                StemExtractionStrategy.StemAffixResult extraction =
                    stemExtractor.extract(lemma, variant);

                writer.write("      <e>\n");
                writer.write("        <p>\n");

                // <l> = surface form suffix (for ANALYSIS: surface → lemma)
                // If vibhakti is ATTACHED, it's already in the inflected suffix
                writer.write("          <l>" + escapeXml(extraction.getInflectedSuffix()) + "</l>\n");

                // <r> = morphological tags (for GENERATION: lemma+tags → surface)
                writer.write("          <r>");
                writer.write(generateTagsFromFeatureStructure(fs));
                writer.write("</r>\n");

                writer.write("        </p>\n");
                writer.write("      </e>\n");
            }
        }

        writer.write("    </pardef>\n");
    }

    private String generateTagsFromFeatureStructure(FeatureStructure fs) {
        StringBuilder tags = new StringBuilder();

        // Add core morphological features
        addTag(tags, fs.getCategory());
        addTag(tags, fs.getGender());
        addTag(tags, fs.getNumber());
        addTag(tags, fs.getPerson());
        addTag(tags, fs.getGrammaticalCase());

        // Vibhakti (case marker/postposition)
        // Check if we should include it based on handling mode
        String vibhakti = fs.getVibhakti();
        if (shouldIncludeVibhaktiTag(vibhakti, fs)) {
            addTag(tags, vibhakti);
        }

        // TAM with mapping if available
        String tam = fs.getTam();
        if (!tam.isEmpty() && !tam.equals("0")) {
            String mappedTam = (tamMapper != null && tamMapper.hasMapping(tam)) ? tamMapper.map(tam) : tam;
            addTag(tags, mappedTam);
        }

        // Additional features
        for (Map.Entry<String, String> entry : fs.getAdditionalFeatures().entrySet()) {
            if (!entry.getValue().isEmpty() && entry.getValue().equals("y")) {
                addTag(tags, entry.getKey());
            }
        }

        return tags.toString();
    }

    /**
     * Determines whether vibhakti should be included as a tag based on handling mode.
     */
    private boolean shouldIncludeVibhaktiTag(String vibhakti, FeatureStructure fs) {
        if (vibhakti == null || vibhakti.isEmpty() || vibhakti.equals("0")) {
            return false;
        }

        switch (vibhaktiHandling) {
            case ATTACHED:
                // Always include vibhakti as a tag (it's in the surface form)
                return true;

            case SEPARATE:
                // Always include vibhakti as a tag (it's a separate word)
                return true;

            case AUTO:
                // Check if feature structure has an explicit marker
                String vibhaktiType = fs.getAdditionalFeatures().get("vibhakti_type");
                if ("separate".equals(vibhaktiType)) {
                    return true; // Separate word
                } else if ("attached".equals(vibhaktiType)) {
                    return true; // Attached
                }
                // Default: assume attached for Indic languages
                return true;

            default:
                return true;
        }
    }

    private void addTag(StringBuilder sb, String value) {
        if (value != null && !value.isEmpty() && !value.equals("0") && !value.equals("any")) {
            sb.append("<s n=\"").append(escapeXml(value)).append("\"/>");
        }
    }

    /**
     * NEW: Writes main section with only stems in <i> tags and proper pardef references.
     */
    private void writeMainSectionNew(FileWriter writer, List<LexiconEntry> lexicon,
                                     Map<String, PardefInfo> pardefs) throws IOException {
        writer.write("  <section id=\"main\" type=\"standard\">\n");

        for (LexiconEntry entry : lexicon) {
            String lemma = entry.getLemma();
            String stem = entry.getStem();
            String pardefName = entry.getPardefName();

            // Skip entries that don't have stem/suffix computed
            if (stem == null || pardefName == null) {
                System.out.println("⚠ Warning: Skipping entry without stem/suffix: " + lemma);
                continue;
            }

            // Write lexicon entry using only the stem in <i> tag
            // Format: <e lm="full_lemma"><i>stem</i><par n="stem/suffix__category"/></e>
            writer.write("    <e lm=\"" + escapeXml(lemma) + "\">");
            writer.write("<i>" + escapeXml(stem) + "</i>");
            writer.write("<par n=\"" + escapeXml(pardefName) + "\"/>");
            writer.write("</e>\n");
        }

        writer.write("  </section>\n");
    }

    /**
     * OLD method - kept for reference, can be removed after testing.
     */
    private void writeMainSection(FileWriter writer, List<LexiconEntry> lexicon) throws IOException {
        writer.write("  <section id=\"main\" type=\"standard\">\n");

        for (LexiconEntry entry : lexicon) {
            writer.write("    <e lm=\"" + escapeXml(entry.getLemma()) + "\">\n");
            writer.write("      <i>" + escapeXml(entry.getLemma()) + "</i>\n");
            writer.write("      <par n=\"" + escapeXml(entry.getParadigmCategory()) + "\"/>\n");
            writer.write("    </e>\n");
        }

        writer.write("  </section>\n");
    }

    /**
     * CORRECT APPROACH: Writes paradigm definitions with stem/suffix naming convention.
     * Based on Bhojpuri Apertium example - one pardef per paradigm category.
     */
    private void writeParadigmDefinitionsWithStemSuffix(FileWriter writer, List<ParadigmCategory> categories,
                                                        ParadigmCategoryToFSSetMap fsMap) throws IOException {
        writer.write("  <pardefs>\n");

        for (ParadigmCategory category : categories) {
            String catName = category.getCategoryName();
            ParCatFeatureStructures parCatFS = fsMap.getParadigmCategoryFSSet(catName);

            if (parCatFS == null || category.getParadigms().isEmpty()) {
                continue;
            }

            // Use first paradigm as the prototypical example
            SpecificParadigm paradigm = category.getParadigms().get(0);
            String paradigmLemma = paradigm.getLemma().getLemmaString();

            // Extract stem from paradigm's lemma using its word forms
            String paradigmStem = extractStemFromParadigm(paradigm);
            String paradigmSuffix = paradigmLemma.substring(paradigmStem.length());

            // Generate pardef name: stem/suffix__category (e.g., "ध/ी__Noun_f")
            String pardefName;
            if (paradigmSuffix.isEmpty()) {
                pardefName = paradigmStem + "/__" + catName;
            } else if (paradigmStem.isEmpty()) {
                pardefName = "/" + paradigmSuffix + "__" + catName;
            } else {
                pardefName = paradigmStem + "/" + paradigmSuffix + "__" + catName;
            }

            writeParadigmDefinitionWithName(writer, pardefName, paradigm, parCatFS, paradigmStem, paradigmSuffix);
        }

        writer.write("  </pardefs>\n\n");
    }

    /**
     * Writes a single pardef with the correct stem/suffix format.
     */
    private void writeParadigmDefinitionWithName(FileWriter writer, String pardefName,
                                                  SpecificParadigm paradigm,
                                                  ParCatFeatureStructures parCatFS,
                                                  String paradigmStem,
                                                  String paradigmSuffix) throws IOException {
        writer.write("    <pardef n=\"" + escapeXml(pardefName) + "\">\n");

        List<WordForm> wordForms = paradigm.getWordForms();
        List<FeatureStructureEntry> fsEntries = new ArrayList<>(parCatFS.getEntries());

        int formCount = Math.min(wordForms.size(), fsEntries.size());

        for (int i = 0; i < formCount; i++) {
            WordForm wf = wordForms.get(i);
            FeatureStructureEntry fsEntry = fsEntries.get(i);
            FeatureStructure fs = fsEntry.getFeatureStructure();

            // Handle variants
            for (String variant : wf.getVariants()) {
                // Extract inflected suffix from variant relative to paradigm stem
                String inflectedSuffix;
                if (variant.startsWith(paradigmStem)) {
                    inflectedSuffix = variant.substring(paradigmStem.length());
                } else {
                    inflectedSuffix = variant;
                }

                writer.write("      <e>\n");
                writer.write("        <p>\n");
                writer.write("          <l>" + escapeXml(inflectedSuffix) + "</l>\n");
                writer.write("          <r>" + escapeXml(paradigmSuffix));
                writer.write(generateTagsFromFeatureStructure(fs));
                writer.write("</r>\n");
                writer.write("        </p>\n");
                writer.write("      </e>\n");
            }
        }

        writer.write("    </pardef>\n");
    }

    /**
     * CORRECT APPROACH: Writes lexicon entries with individual stem extraction.
     * Each entry extracts its own stem and writes it in <i> tag.
     */
    private void writeMainSectionWithStems(FileWriter writer, List<ParadigmCategory> categories,
                                           List<LexiconEntry> lexicon) throws IOException {
        writer.write("  <section id=\"main\" type=\"standard\">\n");

        // Create category lookup map
        Map<String, ParadigmCategory> categoryMap = new HashMap<>();
        for (ParadigmCategory cat : categories) {
            categoryMap.put(cat.getCategoryName(), cat);
        }

        // Build pardef name map (category → pardef name)
        Map<String, String> pardefNameMap = new HashMap<>();
        for (ParadigmCategory category : categories) {
            if (category.getParadigms().isEmpty()) continue;

            SpecificParadigm paradigm = category.getParadigms().get(0);
            String paradigmLemma = paradigm.getLemma().getLemmaString();
            String paradigmStem = extractStemFromParadigm(paradigm);
            String paradigmSuffix = paradigmLemma.substring(paradigmStem.length());

            String pardefName;
            if (paradigmSuffix.isEmpty()) {
                pardefName = paradigmStem + "/__" + category.getCategoryName();
            } else if (paradigmStem.isEmpty()) {
                pardefName = "/" + paradigmSuffix + "__" + category.getCategoryName();
            } else {
                pardefName = paradigmStem + "/" + paradigmSuffix + "__" + category.getCategoryName();
            }

            pardefNameMap.put(category.getCategoryName(), pardefName);
        }

        // Write lexicon entries
        for (LexiconEntry entry : lexicon) {
            String lemma = entry.getLemma();
            String categoryName = entry.getParadigmCategory();

            ParadigmCategory category = categoryMap.get(categoryName);
            if (category == null || category.getParadigms().isEmpty()) {
                continue;
            }

            // Extract stem for this individual entry
            String entryStem = extractStemForLexiconEntry(lemma, category);
            String pardefName = pardefNameMap.get(categoryName);

            if (pardefName == null) {
                continue;
            }

            // Write entry with stem-only format
            writer.write("    <e lm=\"" + escapeXml(lemma) + "\">");
            writer.write("<i>" + escapeXml(entryStem) + "</i>");
            writer.write("<par n=\"" + escapeXml(pardefName) + "\"/>");
            writer.write("</e>\n");
        }

        writer.write("  </section>\n");
    }

    /**
     * Extracts stem for a specific lexicon entry based on its paradigm pattern.
     */
    private String extractStemForLexiconEntry(String lemma, ParadigmCategory category) {
        SpecificParadigm paradigm = category.getParadigms().get(0);
        String paradigmLemma = paradigm.getLemma().getLemmaString();
        String paradigmStem = extractStemFromParadigm(paradigm);

        // Calculate suffix length from paradigm
        int suffixLength = paradigmLemma.length() - paradigmStem.length();

        // Apply same suffix length to the lexicon entry
        if (suffixLength >= lemma.length()) {
            return "";  // Entire lemma is suffix
        } else {
            return lemma.substring(0, lemma.length() - suffixLength);
        }
    }

    private void writeFooter(FileWriter writer) throws IOException {
        writer.write("</dictionary>\n");
    }

    private String escapeXml(String text) {
        if (text == null) return "";
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&apos;");
    }

    @Override
    public String getFormatName() {
        return "Apertium Monodix (XML)";
    }

    @Override
    public String getFileExtension() {
        return "dix";
    }
}
