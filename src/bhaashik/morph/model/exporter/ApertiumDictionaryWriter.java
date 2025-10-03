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
//            Map<String, List<FeatureStructureEntry>> featureStructureEntrySet,
            ParadigmCategoryToFSSetMap paradigmCategoryToFSSetMap,
//            Set<FeatureStructureEntry> featureStructureEntries,
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
            Set<String> sdefSet = extractSdefs(paradigmCategoryToFSSetMap);
            for (String sdef : sdefSet) {
                writer.write("    <sdef n=\"" + sdef + "\"/>\n");
            }
            writer.write("  </sdefs>\n\n");

            // Main section
            writer.write("  <section id=\"main\">\n");

            // Paradigm definitions
            for (ParadigmCategory category : categories) {

                String paradigmCategoryName = category.getCategoryName();
                ParCatFeatureStructures parCatFeatureStructures = paradigmCategoryToFSSetMap.getParadigmCategoryFSSet(paradigmCategoryName);

                for (SpecificParadigm paradigm : category.getParadigms()) {
//                    List<FeatureStructureEntry> fsEntries = featureStructureEntrySet.pgetOrDefault(paradigm.getLemma().getLemmaString(), new ArrayList<>());
                    List<FeatureStructureEntry> fsEntries = new ArrayList<>();

//                    featureStructureEntrySet.addAll(paradigm.getLemma().getLemmaString(), new ArrayList<>());
                    fsEntries.addAll(parCatFeatureStructures.getEntries());

                    writer.write(PardefExporter.exportPardef(category, paradigm, parCatFeatureStructures));
                }
            }

            // Lexicon entries
            for (LexiconEntry entry : lexiconEntries) {
                writer.write("    <e lm=\"" + entry.getLemma() + "\">\n");
                writer.write("      <i>" + entry.getLemma() + "</i>\n");
                writer.write("      <par n=\"" + entry.getParadigmCategory() + "\"/>\n");
                writer.write("    </e>\n");
            }

            writer.write("  </section>\n");
            writer.write("</dictionary>\n");
        }
    }

//    private static Set<String> extractSdefs(Map<String, List<FeatureStructureEntry>> featureStructureSet) {
    private static Set<String> extractSdefs(ParadigmCategoryToFSSetMap paradigmCategoryToFSSetMap) {
        Set<String> sdefs = new LinkedHashSet<>();

        ArrayList<String> paradigmCategoryNames = paradigmCategoryToFSSetMap.getParadigmCategoryNames();
        for (int i = 0; i < paradigmCategoryNames.size(); i++) {
//            for (FeatureStructureEntry entry : paradigmCategoryNames) {
            for (String parCatName : paradigmCategoryNames) {
//                sdefs.addAll(entry.getFeatureStructure().getFeatures().values());
                ParCatFeatureStructures parCatFeatureStructures = paradigmCategoryToFSSetMap.getParadigmCategoryFSSet(parCatName);
                Set<FeatureStructureEntry> featureStructureEntrySet = parCatFeatureStructures.getEntries();

                for(FeatureStructureEntry entry : featureStructureEntrySet) {
                    sdefs.addAll(entry.getFeatureStructure().getAllFeatures().values());
                }
            }
//                sdefs.addAll(entry.getFeatureStructure().getAllFeatures().values());
//                sdefs.addAll(featureStructureEntrySet.getFeatureStructure().getAllFeatures().values());

        }
//
//        paradigmCategoryToFSSetMap.entrySet().stream().forEach(entry ->
//                String parCatName = entry.getKey();
//                entry.getValue())
//        );
//
//         for (List<FeatureStructureEntry> entries : paradigmCategoryToFSSetMap) {
//            for (FeatureStructureEntry entry : entries) {
////                sdefs.addAll(entry.getFeatureStructure().getFeatures().values());
//                sdefs.addAll(entry.getFeatureStructure().getAllFeatures().values());
//            }
//        }
//
//        for (FeatureStructureEntry entry : featureStructureSet) {
//            sdefs.addAll(entry.getFeatureStructure().getAllFeatures().values());
//        }
        return sdefs;
    }

    public static void main(String[] args) throws IOException {

        File output = new File("path/to/output.dix");
        List<ParadigmCategory> paradigmCategories = List.of();
        List<LexiconEntry> lexiconEntries = List.of();
//        Map<String, List<FeatureStructureEntry>> featureStructureSet = Map.of();
        Set<FeatureStructureEntry> featureStructureSet = Set.of();
        Set<Character> inferredAlphabet = Set.of();
//        ApertiumDictionaryWriter.writeDixFile(
//                output,
//                paradigmCategories,         // list of ParadigmCategory
//                featureStructureSet,        // lemma → list of FeatureStructureEntry
//                lexiconEntries,             // parsed from your lexicon file
//                inferredAlphabet            // Set<Character> from .p files + lexicon
//        );

    }
}
