package bhaashik.morph.model.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bhaashik.morph.model.FeatureStructure;
import bhaashik.morph.model.FeatureStructureEntry;
import bhaashik.morph.model.Lemma;
import bhaashik.morph.model.ParadigmFSEntries;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FeatureStructureParser {

    private static final Pattern FS_PATTERN = Pattern.compile("<fs af='([^']*)'\s*(.*?)>");

    public static ParadigmFSEntries parseFeatureStructureFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String categoryName = null;
            ParadigmFSEntries featureSet = null;
            FeatureStructure currentFS = null;
            Lemma currentLemma = null;
//            String lemmaString = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#") || line.isEmpty()) continue; // skip comments and empty lines

                if (line.startsWith("[[") && line.endsWith("]]")) {
                    categoryName = line.substring(2, line.length() - 2);
                    featureSet = new ParadigmFSEntries(categoryName);
                } else if (line.startsWith("<fs")) {
                    Matcher matcher = FS_PATTERN.matcher(line);
                    if (matcher.find()) {
                        String afValue = matcher.group(1);
                        String rest = matcher.group(2);
                        String[] parts = afValue.split(",");
                        if (parts.length < 8) continue; // skip invalid entries

                        Map<String, String> additional = new HashMap<>();
                        if (!rest.isEmpty()) {
                            String[] attrs = rest.split("\s+");
                            for (String attr : attrs) {
                                String[] kv = attr.split("=");
                                if (kv.length == 2) {
                                    additional.put(kv[0], kv[1].replace("'", ""));
                                }
                            }
                        }

                        currentLemma = new Lemma(parts[0]);

                        currentFS = new FeatureStructure(
                                currentLemma, parts[1], parts[2], parts[3],
                                parts[4], parts[5], parts[6], parts[7], additional
                        );
                    }
                } else if (line.startsWith(">>") && currentFS != null) {
                    String surface = line.substring(2).trim();
                    if (isValidWord(surface)) {
                        featureSet.addEntry(new FeatureStructureEntry(currentFS, currentLemma, surface));
                    }
                } else if (line.startsWith(">")) {
                    currentLemma = new Lemma(line.substring(1).trim());
                }
            }

            return featureSet;
        }
    }

    private static boolean isValidWord(String word) {
        return word != null && !word.isEmpty() && word.matches("[\u0900-\u097F\\w]") ; // Example: allow Devanagari + word characters
    }

    public static void writeToJson(ParadigmFSEntries featureSet, File outputFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, featureSet);
    }

    public static void writeToXml(ParadigmFSEntries featureSet, File outputFile) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(outputFile, featureSet);
    }

    public static void main(String[] args) throws IOException {
        File input = new File("data/Noun_m_features.txt");
        ParadigmFSEntries featureSet = parseFeatureStructureFile(input);

        // Export to JSON and XML
        writeToJson(featureSet, new File("output/Noun_m_features.json"));
        writeToXml(featureSet, new File("output/Noun_m_features.xml"));

        // Optional: filter by POS or paradigm size
        if (featureSet.getParadigmCategoryName().startsWith("Noun") && featureSet.getEntries().size() > 3) {
            System.out.println("Valid noun paradigm: " + featureSet);
        }
    }
}
