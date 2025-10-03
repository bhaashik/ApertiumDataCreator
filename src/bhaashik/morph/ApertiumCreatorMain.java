package bhaashik.morph;

import bhaashik.morph.model.ParCatFeatureStructures;
import bhaashik.morph.model.FeatureStructureEntry;
import bhaashik.morph.model.LexiconEntry;
import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.ParCatFeatureStructures;
import bhaashik.morph.model.ParadigmCategoryToFSSetMap;
import bhaashik.morph.model.exporter.ApertiumDictionaryWriter;
import bhaashik.morph.model.parser.FeatureStructureParser;
import bhaashik.morph.model.parser.LexiconParser;
import bhaashik.morph.model.parser.ParadigmFileParser;

import java.io.File;
import java.util.*;

public class ApertiumCreatorMain {
    public static void main(String[] args) {
//        if (args.length != 4) {
//            System.out.println("Usage: java -jar MonodixGenerator.jar <paradigm-dir> <lexicon-file> <feature-file> <output.dix>");
//            System.exit(1);
//        }

//        File paradigmDir = new File(args[0]);
//        File lexiconFile = new File(args[1]);
//        File featureFile = new File(args[2]);
//        File outputDix = new File(args[3]);

        File paradigmDir = new File("D:\\projects\\Bhaashik\\data-and-resources\\Bhaashik-Linguistic-Resources\\selected-pv-resources\\pre-public\\morph\\bhojpuri\\bhojpuri-paradigms\\morphological-paradigms-and-lexicon\\paradigms");
        File lexiconFile = new File("D:\\projects\\Bhaashik\\data-and-resources\\Bhaashik-Linguistic-Resources\\selected-pv-resources\\pre-public\\morph\\bhojpuri\\bhojpuri-paradigms\\morphological-paradigms-and-lexicon\\lexicon\\dict.final.txt");
        File featureFile = new File("D:\\projects\\Bhaashik\\data-and-resources\\Bhaashik-Linguistic-Resources\\selected-pv-resources\\pre-public\\morph\\bhojpuri\\bhojpuri-paradigms\\morphological-paradigms-and-lexicon\\paradigm-features\\paradigm-features.txt");
        File outputDix = new File("D:\\projects\\Bhaashik\\data-and-resources\\Bhaashik-Linguistic-Resources\\selected-pv-resources\\pre-public\\morph\\bhojpuri\\bhojpuri-paradigms\\morphological-paradigms-and-lexicon\\apertium-modix\\apertium-modix.dix");
        Set<Character> alphabet = new LinkedHashSet<>();

        try {
            // 3. Parse feature structure file (parsing first to know the number of forms for a paradigm category)
//            FeatureStructureParser fsParser = new FeatureStructureParser();
            ParadigmCategoryToFSSetMap paradigmCategoryToFSSetMap = FeatureStructureParser.parseFeatureStructureFile(featureFile);
//            Map<String, List<FeatureStructureEntry>> featureStructureEntrySet = fsParser.featureFile);
//            Set<FeatureStructureEntry> featureStructureEntrySet = paradigmCategoryToFSSetMap.getEntries();

            // 1. Parse paradigms
            ParadigmFileParser paradigmParser = new ParadigmFileParser();
            List<ParadigmCategory> categories = new ArrayList<>();
            int numCategories = 0;
            for (File file : Objects.requireNonNull(paradigmDir.listFiles((d, name) -> name.endsWith(".p")))) {
                String paradigmCategoryName = file.getName().substring(0, file.getName().length() - 4);
                int numForms = paradigmCategoryToFSSetMap.getWordFormCount(paradigmCategoryName);
                numCategories++;
                categories.add(paradigmParser.parseParadigmFile(file, numForms));
            }

            // 2. Parse lexicon
            LexiconParser lexiconParser = new LexiconParser();
//        List<LexiconEntry> lexicon = lexiconParser.parse(lexiconFile);
            List<LexiconEntry> lexicon = lexiconParser.parseLexiconFile(lexiconFile);

//            // 3. Parse feature structure file
////            FeatureStructureParser fsParser = new FeatureStructureParser();
//            ParadigmFSEntries paradigmCategoryToFSSetMap = FeatureStructureParser.parseFeatureStructureFile(featureFile);
////            Map<String, List<FeatureStructureEntry>> featureStructureEntrySet = fsParser.featureFile);
//            Set<FeatureStructureEntry> featureStructureEntrySet = paradigmCategoryToFSSetMap.getEntries();

            // 4. Generate and write .dix
            ApertiumDictionaryWriter writer = new ApertiumDictionaryWriter();
            ApertiumDictionaryWriter.writeDixFile(outputDix, categories, paradigmCategoryToFSSetMap, lexicon, alphabet);

            System.out.println("✅ Successfully generated: " + outputDix.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
