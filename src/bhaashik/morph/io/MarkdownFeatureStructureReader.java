package bhaashik.morph.io;

import bhaashik.morph.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reader for markdown-formatted feature structure files (ApertiumDataCreator-part-*.md).
 */
public class MarkdownFeatureStructureReader implements FeatureStructureReader {

    private static final Pattern FS_PATTERN = Pattern.compile("<fs\\s+af='([^']*)'([^>]*)>");
    private static final Pattern ATTR_PATTERN = Pattern.compile("(\\w+)='([^']*)'");

    @Override
    public ParadigmCategoryToFSSetMap readFeatureStructures(File source) throws IOException {
        ParadigmCategoryToFSSetMap map = new ParadigmCategoryToFSSetMap();

        if (source.isDirectory()) {
            // First try the structured markdown file
            File structuredFile = new File(source, "input/B_M_M_Word-generation-ver-1.9.0.formatted-structured-for-csv-for-dix-generation.md");
            if (structuredFile.exists()) {
                System.out.println("Reading feature structures from: " + structuredFile.getName());
                readStructuredMarkdownFile(structuredFile, map);
            } else {
                // Fallback to formatted text file
                File formattedFile = new File(source, "B_M_M_Word-generation-ver-1.9.0.formatted.txt");
                if (formattedFile.exists()) {
                    System.out.println("Reading feature structures from: " + formattedFile.getName());
                    readSingleFile(formattedFile, map);
                } else {
                    // Fallback to reading from multiple parts (1-13)
                    for (int i = 1; i <= 13; i++) {
                        File partFile = new File(source, "ApertiumDataCreator-part-" + i + ".md");
                        if (partFile.exists()) {
                            System.out.println("Reading feature structures from: " + partFile.getName());
                            readSingleFile(partFile, map);
                        }
                    }
                }
            }
        } else if (source.isFile()) {
            if (source.getName().contains("structured")) {
                readStructuredMarkdownFile(source, map);
            } else {
                readSingleFile(source, map);
            }
        } else {
            throw new IOException("Source not found: " + source);
        }

        System.out.println("✓ Loaded " + map.getNumParadigmCategories() + " paradigm categories with feature structures");
        return map;
    }

    /**
     * Read the structured markdown file with escaped markup
     */
    private void readStructuredMarkdownFile(File file, ParadigmCategoryToFSSetMap map) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String currentCategoryName = null;
            ParCatFeatureStructures currentParCatFS = null;
            FeatureStructure pendingFS = null;

            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();

                // Skip empty lines, format description, and TAM dictionary section
                if (trimmed.isEmpty() || trimmed.startsWith("#") || trimmed.contains("[[[TAM Dict")) {
                    continue;
                }

                // Detect paradigm category name: \[\[CategoryName\]\]
                if (trimmed.startsWith("\\[\\[") && trimmed.endsWith("\\]\\]")) {
                    // Save previous category
                    if (currentCategoryName != null && currentParCatFS != null && currentParCatFS.getEntries().size() > 0) {
                        map.addParadigmCatogory(currentCategoryName, currentParCatFS);
                    }

                    // Extract category name
                    currentCategoryName = trimmed.substring(4, trimmed.length() - 4).replace("\\_", "_");
                    currentParCatFS = new ParCatFeatureStructures();
                    pendingFS = null;
                    continue;
                }

                // Parse feature structure: \<fs af='...'\>
                if (trimmed.startsWith("\\<fs") && currentParCatFS != null) {
                    // Unescape the XML: \<fs af='...'\> -> <fs af='...'>
                    String unescaped = trimmed.replace("\\<", "<").replace("\\>", ">").replace("\\_", "_");
                    pendingFS = parseFeatureStructure(unescaped);
                    continue;
                }

                // Generated Hindi surface form: \>\>form
                if (trimmed.startsWith("\\>\\>") && pendingFS != null && currentParCatFS != null) {
                    String surfaceForm = trimmed.substring(4).replace("\\_", "_");
                    FeatureStructureEntry entry = new FeatureStructureEntry(pendingFS, pendingFS.getLemma(), surfaceForm);
                    currentParCatFS.addEntry(entry);
                    pendingFS = null;
                }
            }

            // Save last category
            if (currentCategoryName != null && currentParCatFS != null && currentParCatFS.getEntries().size() > 0) {
                map.addParadigmCatogory(currentCategoryName, currentParCatFS);
            }
        }
    }

    private void readSingleFile(File file, ParadigmCategoryToFSSetMap map) throws IOException {
        // Read entire file content (handles continuous line format)
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }
        String content = contentBuilder.toString();

        // Pattern to match paradigm category names (either [[Name]] or standalone Name)
        // Matches: [[Name]] or a word boundary followed by capitalized paradigm name
        Pattern categoryPattern = Pattern.compile("(?:\\[\\[([A-Za-z][A-Za-z0-9_]*)\\]\\]|(?:^|[>\\s])([A-Z][A-Za-z0-9_]+)(?=<fs|[\\n\\s]))");
        Matcher categoryMatcher = categoryPattern.matcher(content);

        int lastEnd = 0;
        String currentCategoryName = null;
        int currentStart = 0;

        while (categoryMatcher.find()) {
            // Extract category name from either group 1 ([[Name]]) or group 2 (Name)
            String categoryName = categoryMatcher.group(1) != null ? categoryMatcher.group(1) : categoryMatcher.group(2);

            // Skip if it looks like explanation text
            if (categoryName != null && !isExplanationText(categoryName)) {
                // Process previous category section if exists
                if (currentCategoryName != null) {
                    String categoryContent = content.substring(currentStart, categoryMatcher.start());
                    processCategory(currentCategoryName, categoryContent, map);
                }

                // Start new category
                currentCategoryName = categoryName;
                currentStart = categoryMatcher.end();
                lastEnd = categoryMatcher.end();
            }
        }

        // Process last category
        if (currentCategoryName != null && lastEnd < content.length()) {
            String categoryContent = content.substring(currentStart);
            processCategory(currentCategoryName, categoryContent, map);
        }
    }

    private boolean isExplanationText(String text) {
        // Filter out common explanation phrases that might match the pattern
        return text.matches(".*(Root|Step|Direct|Word|Generation|Through|Inverted|Morph|Add|Seperate|Feature|Analyser|No).*");
    }

    private void processCategory(String categoryName, String content, ParadigmCategoryToFSSetMap map) {
        ParCatFeatureStructures parCatFS = new ParCatFeatureStructures();

        // Find all feature structures in this category section
        Matcher fsMatcher = FS_PATTERN.matcher(content);
        int fsCount = 0;

        while (fsMatcher.find()) {
            FeatureStructure fs = parseFeatureStructure(fsMatcher.group(0));
            if (fs != null) {
                // Create entry with surface form (we don't extract actual surface forms from this format)
                FeatureStructureEntry entry = new FeatureStructureEntry(fs, fs.getLemma(), "");
                parCatFS.addEntry(entry);
                fsCount++;
            }
        }

        if (fsCount > 0) {
            map.addParadigmCatogory(categoryName, parCatFS);
        }
    }

    private boolean isParadigmCategoryLine(String line) {
        // Skip instruction/comment lines
        if (line.contains("Root will") || line.contains("No need") ||
            line.contains("Direct Word") || line.contains("Step") ||
            line.contains("Add emphatic") || line.contains("Seperate") ||
            line.contains("Morph feature") || line.contains("Inverted") ||
            line.contains("Generation Through")) {
            return false;
        }

        // Paradigm category names: ASCII identifiers, possibly with underscores
        return line.matches("[A-Za-z][A-Za-z0-9_]*");
    }

    private FeatureStructure parseFeatureStructure(String line) {
        Matcher fsMatcher = FS_PATTERN.matcher(line);
        if (!fsMatcher.find()) {
            return null;
        }

        String afValue = fsMatcher.group(1);
        String restAttributes = fsMatcher.group(2);

        // Parse af field (8 comma-separated values)
        String[] parts = afValue.split(",", -1);
        if (parts.length < 8) {
            parts = Arrays.copyOf(parts, 8);
            for (int i = afValue.split(",", -1).length; i < 8; i++) {
                parts[i] = "";
            }
        }

        String lemmaStr = parts[0];
        String category = parts[1];
        String gender = parts[2];
        String number = parts[3];
        String person = parts[4];
        String grammaticalCase = parts[5];
        String vibhakti = parts[6];
        String tam = parts[7];

        // Parse additional attributes (emph, emph1, agr_gen, etc.)
        Map<String, String> additionalFeatures = new HashMap<>();
        if (restAttributes != null && !restAttributes.trim().isEmpty()) {
            Matcher attrMatcher = ATTR_PATTERN.matcher(restAttributes);
            while (attrMatcher.find()) {
                String attrName = attrMatcher.group(1);
                String attrValue = attrMatcher.group(2);
                additionalFeatures.put(attrName, attrValue);
            }
        }

        Lemma lemma = new Lemma(lemmaStr);
        return new FeatureStructure(
            lemma, category, gender, number, person,
            grammaticalCase, vibhakti, tam, additionalFeatures
        );
    }

    private boolean isDevanagariText(String text) {
        // Check for Devanagari Unicode range (U+0900 to U+097F)
        return text.matches(".*[\u0900-\u097F].*");
    }

    @Override
    public String getFormatName() {
        return "Markdown Feature Structure Format";
    }
}
