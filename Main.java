import morphology.model.*;
import morphology.parser.*;
import morphology.util.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java -jar MonodixGenerator.jar <paradigm-dir> <lexicon-file> <feature-file> <output.dix>");
            System.exit(1);
        }

        File paradigmDir = new File(args[0]);
        File lexiconFile = new File(args[1]);
        File featureFile = new File(args[2]);
        File outputDix = new File(args[3]);

        try {
            ParadigmFileParser paradigmParser = new ParadigmFileParser();
            List<ParadigmCategory> categories = new ArrayList<>();
            for (File file : Objects.requireNonNull(paradigmDir.listFiles((d, name) -> name.endsWith(".p")))) {
                categories.add(paradigmParser.parse(file));
            }

            LexiconParser lexiconParser = new LexiconParser();
            List<LexiconEntry> lexicon = lexiconParser.parse(lexiconFile);

            FeatureStructureParser fsParser = new FeatureStructureParser();
            Map<String, List<FeatureStructureEntry>> fsMap = fsParser.parse(featureFile);

            DixWriter writer = new DixWriter();
            writer.write(outputDix, categories, fsMap, lexicon);

            System.out.println("✅ Successfully generated: " + outputDix.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}