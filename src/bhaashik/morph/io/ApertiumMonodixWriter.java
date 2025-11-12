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

            // NEW: Generate pardef info for each lexicon entry
            Map<String, PardefInfo> pardefs = generatePardefInfoForLexicon(categories, fsMap, lexicon);
            writeParadigmDefinitionsNew(writer, pardefs);
            writeMainSectionNew(writer, lexicon, pardefs);

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
     * Generates PardefInfo for each unique stem/suffix combination in the lexicon.
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

        // Additional features
        for (String value : fs.getAdditionalFeatures().values()) {
            if (!value.isEmpty()) symbols.add(value);
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
                // Extract suffix from this variant
                StemExtractionStrategy.StemAffixResult extraction =
                    stemExtractor.extract(paradigmLemma, variant);

                writer.write("      <e>\n");
                writer.write("        <p>\n");

                // <l> = surface form suffix (for ANALYSIS)
                writer.write("          <l>" + escapeXml(extraction.getInflectedSuffix()) + "</l>\n");

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

            // Use stem extraction strategy to get the suffix
            StemExtractionStrategy.StemAffixResult extraction =
                stemExtractor.extract(lemma, wf.getForm());

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
            String categoryName = entry.getParadigmCategory();

            // Look up the pardef info to get the correct stem and suffix
            // Try both with and without suffix separator
            PardefInfo pardefInfo = pardefs.get(lemma + "__" + categoryName);
            if (pardefInfo == null) {
                // Try to find by category and stem prefix
                pardefInfo = pardefs.values().stream()
                    .filter(p -> p.categoryName.equals(categoryName) &&
                                 lemma.startsWith(p.stem))
                    .findFirst()
                    .orElse(null);
            }

            if (pardefInfo == null) {
                System.out.println("⚠ Warning: No pardef found for entry " + lemma + " in category " + categoryName);
                continue;
            }

            // Write lexicon entry using the pardef's stem information
            writer.write("    <e lm=\"" + escapeXml(lemma) + "\">\n");
            writer.write("      <i>" + escapeXml(pardefInfo.stem) + "</i>\n");
            writer.write("      <par n=\"" + escapeXml(pardefInfo.pardefName) + "\"/>\n");
            writer.write("    </e>\n");
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
