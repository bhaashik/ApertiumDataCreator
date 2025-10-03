package bhaashik.morph.model.parser;

import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.SpecificParadigm;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Batch processor for reading and parsing multiple .p files representing paradigm categories.
 */
public class ParadigmBatchProcessor {

    private final ParadigmFileParser parser;
    LinkedHashMap<String, Integer> perCategoryNumForms;

    public ParadigmBatchProcessor(LinkedHashMap<String, Integer> perCategoryNumForms) {
        this.perCategoryNumForms = perCategoryNumForms;
        this.parser = new ParadigmFileParser();
    }

    /**
     * Parses all .p files in the given directory and returns a map of category name to ParadigmCategory object.
     *
     * @param directory the directory containing .p files
     * @return map from category name to parsed ParadigmCategory
     * @throws IOException if any file cannot be read
     */
    public Map<String, ParadigmCategory> processDirectory(File directory) throws IOException {
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory: " + directory);
        }

        Map<String, ParadigmCategory> categories = new HashMap<>();

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".p"));
        if (files == null || files.length == 0) {
            System.out.println("No .p files found in directory: " + directory);
            return categories;
        }

        for (File file : files) {
            try {
                String paradigmCategoryName = file.getName().substring(0, file.getName().length() - 3);
                int numForms = perCategoryNumForms.get(paradigmCategoryName);
                ParadigmCategory category = parser.parseParadigmFile(file, numForms);
                categories.put(category.getCategoryName(), category);
                System.out.println("Parsed category: " + category.getCategoryName() + " (" + category.getParadigms().size() + " paradigms)");
            } catch (IOException | IllegalArgumentException e) {
                System.err.println("Failed to parse file: " + file.getName());
                e.printStackTrace();
            }
        }

        return categories;
    }

    public static void main(String[] args) {
        File inputDirectory = new File("path/to/your/paradigm/files");

//        ParadigmBatchProcessor batchProcessor = new ParadigmBatchProcessor();
//        try {
//            Map<String, ParadigmCategory> allCategories = batchProcessor.processDirectory(inputDirectory);
//
//            for (Map.Entry<String, ParadigmCategory> entry : allCategories.entrySet()) {
//                System.out.println("Category: " + entry.getKey());
//                for (SpecificParadigm paradigm : entry.getValue().getParadigms()) {
//                    System.out.println("  " + paradigm);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
