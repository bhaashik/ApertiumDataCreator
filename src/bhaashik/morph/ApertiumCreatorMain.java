package bhaashik.morph;

import bhaashik.morph.algorithm.LongestCommonPrefixStrategy;
import bhaashik.morph.io.*;
import bhaashik.morph.model.LexiconEntry;
import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.ParadigmCategoryToFSSetMap;
import bhaashik.morph.util.TAMMapper;

import java.io.File;
import java.util.List;

/**
 * Main class for generating Apertium monodix files from Bhaashik linguistic resources.
 * Uses the new modular architecture with readers and writers.
 */
public class ApertiumCreatorMain {

    public static void main(String[] args) {
        // Parse command line arguments or use defaults
        String language = "Bhojpuri";
        File projectRoot;
        File paradigmDir;
        File lexiconFile;
        File featureStructureSource;
        File outputDix;

        if (args.length >= 4) {
            paradigmDir = new File(args[0]);
            lexiconFile = new File(args[1]);
            featureStructureSource = new File(args[2]);
            outputDix = new File(args[3]);
            if (args.length >= 5) {
                language = args[4];
            }
        } else {
            // Default paths relative to project root
            projectRoot = new File(".");
            paradigmDir = new File(projectRoot, "input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri/paradigms");
            lexiconFile = new File(projectRoot, "input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri/lexicon.txt");
            // paradigmDir = new File(projectRoot, "input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri/morphological-paradigms-and-lexicon/paradigms");
            // lexiconFile = new File(projectRoot, "input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri/morphological-paradigms-and-lexicon/lexicon/dict.final.txt");
            featureStructureSource = projectRoot; // Will look for ApertiumDataCreator-part-*.md files
            outputDix = new File(projectRoot, "output/bhojpuri-monodix.dix");

            System.out.println("Usage: java -jar MonodixGenerator.jar <paradigm-dir> <lexicon-file> <feature-structure-source> <output.dix> [language]");
            System.out.println("Using default paths for " + language + "...\n");
        }

        try {
            System.out.println("=== Bhaashik Morphological Dictionary Generator ===");
            System.out.println("Language: " + language);
            System.out.println("Paradigm directory: " + paradigmDir.getAbsolutePath());
            System.out.println("Lexicon file: " + lexiconFile.getAbsolutePath());
            System.out.println("Feature structure source: " + featureStructureSource.getAbsolutePath());
            System.out.println("Output file: " + outputDix.getAbsolutePath());
            System.out.println();

            // Create output directory if needed
            if (!outputDix.getParentFile().exists()) {
                outputDix.getParentFile().mkdirs();
            }

            // Step 1: Read feature structures (to know word form counts)
            System.out.println("Step 1: Reading feature structures...");
            FeatureStructureReader fsReader = new MarkdownFeatureStructureReader();
            ParadigmCategoryToFSSetMap fsMap = fsReader.readFeatureStructures(featureStructureSource);
            System.out.println();

            // Step 2: Read paradigms
            System.out.println("Step 2: Reading paradigm files...");
            ParadigmReader paradigmReader = new DotPFormatParadigmReader();
            List<ParadigmCategory> categories = paradigmReader.readAllParadigms(
                paradigmDir,
                paradigmCatName -> fsMap.getWordFormCount(paradigmCatName)
            );
            System.out.println();

            // Step 3: Read lexicon
            System.out.println("Step 3: Reading lexicon...");
            LexiconReader lexiconReader = new CSVLexiconReader();
            List<LexiconEntry> lexicon = lexiconReader.readLexicon(lexiconFile);
            System.out.println();

            // Step 4: Optional - Load TAM mapper for Hindi generation
            System.out.println("Step 4: Loading TAM mapper...");
            TAMMapper tamMapper = null;
            File tamMappingFile = new File("TAM-Mapping.md");
            if (tamMappingFile.exists()) {
                tamMapper = new TAMMapper("BMM", "Hindi");
                tamMapper.loadMappingsFromFile(tamMappingFile);
            } else {
                System.out.println("TAM-Mapping.md not found, using default mapper");
                tamMapper = TAMMapper.createDefaultBMMToHindiMapper();
            }
            System.out.println();

            // Step 5: Write Apertium monodix file
            System.out.println("Step 5: Generating Apertium monodix file...");
            ApertiumMonodixWriter writer = new ApertiumMonodixWriter();

            // Configure writer
            writer.setStemExtractionStrategy(new LongestCommonPrefixStrategy());
            writer.setTAMMapper(tamMapper);
            writer.setScriptName("WX");
            writer.setVibhaktiHandling(ApertiumMonodixWriter.VibhaktiHandling.ATTACHED);
            writer.setIncludeAlphabet(true);

            // Write the dictionary
            writer.writeDictionary(outputDix, categories, fsMap, lexicon);
            System.out.println();

            // Summary
            System.out.println("=== Generation Summary ===");
            System.out.println("Paradigm categories: " + categories.size());
            System.out.println("Lexicon entries: " + lexicon.size());
            System.out.println("Output: " + outputDix.getAbsolutePath());
            System.out.println();
            System.out.println("✅ Successfully generated Apertium monodix file!");
            System.out.println();
            System.out.println("To compile the FST:");
            System.out.println("  lt-comp lr " + outputDix.getName() + " " + language.toLowerCase() + ".bin");

        } catch (Exception e) {
            System.err.println();
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
