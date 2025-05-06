package bhaashik.morph;

import bhaashik.morph.model.FeatureStructureEntry;
import bhaashik.morph.model.LexiconEntry;
import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.exporter.ApertiumDictionaryWriter;
import bhaashik.morph.model.parser.FeatureStructureParser;
import bhaashik.morph.model.parser.LexiconParser;
import bhaashik.morph.model.parser.ParadigmFileParser;

import java.io.File;
import java.util.*;

public class ApertiumCreatorMain {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java -jar MonodixGenerator.jar <paradigm-dir> <lexicon-file> <feature-file> <output.dix>");
            System.exit(1);
        }

        File paradigmDir = new File(args[0]);
        File lexiconFile = new File(args[1]);
        File featureFile = new File(args[2]);
        File outputDix = new File(args[3]);
        Set<Character> alphabet = new LinkedHashSet<>();

        try {
            // 1. Parse paradigms
            ParadigmFileParser paradigmParser = new ParadigmFileParser();
            List<ParadigmCategory> categories = new ArrayList<>();
            for (File file : Objects.requireNonNull(paradigmDir.listFiles((d, name) -> name.endsWith(".p")))) {
                categories.add(paradigmParser.parse(file));
            }

            // 2. Parse lexicon
            LexiconParser lexiconParser = new LexiconParser();
//        List<LexiconEntry> lexicon = lexiconParser.parse(lexiconFile);
            List<LexiconEntry> lexicon = lexiconParser.parse(lexiconFile);

            // 3. Parse feature structure file
            FeatureStructureParser fsParser = new FeatureStructureParser();
            Map<String, List<FeatureStructureEntry>> fsMap = fsParser.parse(featureFile);

            // 4. Generate and write .dix
//        ApertiumDictionaryWriter writer = new ApertiumDictionaryWriter();
            ApertiumDictionaryWriter.writeDixFile(outputDix, categories, fsMap, lexicon, alphabet);

            System.out.println("✅ Successfully generated: " + outputDix.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
