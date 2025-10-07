package bhaashik.morph.loader;

import bhaashik.morph.api.DataLoader;
import bhaashik.morph.model.*;
import bhaashik.morph.model.parser.LexiconParser;
import bhaashik.morph.model.parser.ParadigmFileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DataLoader implementation for markdown-formatted feature structure files.
 * Handles the split ApertiumDataCreator-part-*.md format.
 */
public class MarkdownDataLoader implements DataLoader {

    private static final Pattern FS_PATTERN = Pattern.compile("<fs\\s+af='([^']*)'([^>]*)>");
    private static final Pattern ATTR_PATTERN = Pattern.compile("(\\w+)='([^']*)'");

    @Override
    public List<ParadigmCategory> loadParadigms(File directory, ParadigmCategoryToFSSetMap fsMap) throws IOException {
        List<ParadigmCategory> categories = new ArrayList<>();
        ParadigmFileParser parser = new ParadigmFileParser();

        File[] pFiles = directory.listFiles((d, name) -> name.endsWith(".p"));
        if (pFiles == null) {
            throw new IOException("No .p files found in: " + directory);
        }

        for (File pFile : pFiles) {
            String paradigmCatName = pFile.getName().replace(".p", "");
            int numForms = fsMap.getWordFormCount(paradigmCatName);

            if (numForms > 0) {
                ParadigmCategory category = parser.parseParadigmFile(pFile, numForms);
                categories.add(category);
                System.out.println("Loaded: " + paradigmCatName + " with " + numForms + " forms");
            } else {
                System.out.println("Warning: No feature structures found for " + paradigmCatName + ", skipping");
            }
        }

        return categories;
    }

    @Override
    public ParadigmCategoryToFSSetMap loadFeatureStructures(File source) throws IOException {
        ParadigmCategoryToFSSetMap map = new ParadigmCategoryToFSSetMap();

        if (source.isDirectory()) {
            // Load from multiple markdown files (parts 1-13)
            for (int i = 1; i <= 13; i++) {
                File partFile = new File(source, "ApertiumDataCreator-part-" + i + ".md");
                if (partFile.exists()) {
                    System.out.println("Loading: " + partFile.getName());
                    parseFeatureStructureFile(partFile, map);
                }
            }
        } else if (source.isFile()) {
            // Single file
            parseFeatureStructureFile(source, map);
        }

        System.out.println("Loaded " + map.getNumParadigmCategories() + " paradigm categories");
        return map;
    }

    private void parseFeatureStructureFile(File file, ParadigmCategoryToFSSetMap map) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String currentParCatName = null;
            ParCatFeatureStructures currentParCatFS = null;
            List<FeatureStructure> pendingFSList = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();

                if (trimmed.isEmpty()) {
                    continue;
                }

                // Detect paradigm category name
                if (isParadigmCategoryLine(trimmed)) {
                    // Save previous category
                    if (currentParCatName != null && currentParCatFS != null) {
                        map.addParadigmCatogory(currentParCatName, currentParCatFS);
                    }

                    currentParCatName = trimmed;
                    currentParCatFS = new ParCatFeatureStructures();
                    pendingFSList.clear();
                    continue;
                }

                // Parse feature structure
                if (trimmed.startsWith("<fs")) {
                    FeatureStructure fs = parseFeatureStructure(trimmed);
                    if (fs != null) {
                        pendingFSList.add(fs);
                    }
                    continue;
                }

                // Hindi surface form (Devanagari)
                if (isDevanagariText(trimmed) && !pendingFSList.isEmpty() && currentParCatFS != null) {
                    for (FeatureStructure fs : pendingFSList) {
                        FeatureStructureEntry entry = new FeatureStructureEntry(fs, fs.getLemma(), trimmed);
                        currentParCatFS.addEntry(entry);
                    }
                    pendingFSList.clear();
                }
            }

            // Save last category
            if (currentParCatName != null && currentParCatFS != null) {
                map.addParadigmCatogory(currentParCatName, currentParCatFS);
            }
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
    public List<LexiconEntry> loadLexicon(File lexiconFile) throws IOException {
        LexiconParser parser = new LexiconParser();
        return parser.parseLexiconFile(lexiconFile);
    }

    @Override
    public String getFormatName() {
        return "Markdown Feature Structure Format";
    }
}
