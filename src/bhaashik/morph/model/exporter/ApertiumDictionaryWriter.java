package bhaashik.morph.model.exporter;

import bhaashik.morph.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ApertiumDictionaryWriter {

    public static void writeDixFile(
            File outputFile,
            List<ParadigmCategory> categories,
            Map<String, List<FeatureStructureEntry>> featureStructureMap,
            List<LexiconEntry> lexiconEntries,
            Set<Character> alphabet
    ) throws IOException {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<dictionary>\n");

            // Alphabet
            writer.write("  <alphabet>\n");
            for (char c : alphabet) {
                writer.write("    " + c + "\n");
            }
            writer.write("  </alphabet>\n\n");

            // sdefs: inferred from feature structures
            writer.write("  <sdefs>\n");
            Set<String> sdefSet = extractSdefs(featureStructureMap);
            for (String sdef : sdefSet) {
                writer.write("    <sdef n=\"" + sdef + "\"/>\n");
            }
            writer.write("  </sdefs>\n\n");

            // Main section
            writer.write("  <section id=\"main\">\n");

            // Paradigm definitions
            for (ParadigmCategory category : categories) {
                for (SpecificParadigm paradigm : category.getParadigms()) {
                    List<FeatureStructureEntry> fsEntries = featureStructureMap.getOrDefault(paradigm.getLemma(), new ArrayList<>());
                    writer.write(PardefExporter.exportPardef(category, paradigm, fsEntries));
                }
            }

            // Lexicon entries
            for (LexiconEntry entry : lexiconEntries) {
                writer.write("    <e lm=\"" + entry.getLemma() + "\">\n");
                writer.write("      <i>" + entry.getLemma() + "</i>\n");
                writer.write("      <par n=\"" + entry.getParadigmCategoryName() + "\"/>\n");
                writer.write("    </e>\n");
            }

            writer.write("  </section>\n");
            writer.write("</dictionary>\n");
        }
    }

    private static Set<String> extractSdefs(Map<String, List<FeatureStructureEntry>> featureStructureMap) {
        Set<String> sdefs = new HashSet<>();
        for (List<FeatureStructureEntry> entries : featureStructureMap.values()) {
            for (FeatureStructureEntry entry : entries) {
                sdefs.addAll(entry.getFeatureStructure().getFeatures().values());
            }
        }
        return sdefs;
    }

    public static void main(String[] args) throws IOException {

        File output = new File("path/to/output.dix");
        List<ParadigmCategory> paradigmCategories = List.of();
        List<LexiconEntry> lexiconEntries = List.of();
        Map<String, List<FeatureStructureEntry>> featureStructureMap = Map.of();
        Set<Character> inferredAlphabet = Set.of();
        ApertiumDictionaryWriter.writeDixFile(
                output,
                paradigmCategories,         // list of ParadigmCategory
                featureStructureMap,        // lemma → list of FeatureStructureEntry
                lexiconEntries,             // parsed from your lexicon file
                inferredAlphabet            // Set<Character> from .p files + lexicon
        );

    }
}
