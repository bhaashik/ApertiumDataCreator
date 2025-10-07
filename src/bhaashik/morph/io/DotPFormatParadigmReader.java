package bhaashik.morph.io;

import bhaashik.morph.model.Lemma;
import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.SpecificParadigm;
import bhaashik.morph.model.WordForm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reader for .p (dot-p) format paradigm files.
 * This is the format used in the Bhojpuri/Maithili/Magahi linguistic resources.
 *
 * Format:
 * - Line 1: Paradigm category name
 * - Subsequent lines: Lemma followed by N word forms (where N is category-specific)
 */
public class DotPFormatParadigmReader implements ParadigmReader {

    @Override
    public ParadigmCategory readParadigmCategory(File file, int numForms) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String categoryName = reader.readLine();
            if (categoryName == null || categoryName.isBlank()) {
                throw new IllegalArgumentException("Empty or malformed paradigm file: " + file.getName());
            }

            categoryName = categoryName.trim();
            ParadigmCategory category = new ParadigmCategory(categoryName);

            List<String> allLines = reader.lines()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .toList();

            int i = 0;
            while (i < allLines.size()) {
                if (i >= allLines.size()) break;

                String lemmaStr = allLines.get(i++);
                SpecificParadigm paradigm = new SpecificParadigm(new Lemma(lemmaStr));

                // Read N word forms for this paradigm
                for (int j = 0; j < numForms && i < allLines.size(); j++) {
                    paradigm.addWordForm(new WordForm(allLines.get(i++)));
                }

                category.addSpecificParadigm(paradigm);
            }

            return category;
        }
    }

    @Override
    public List<ParadigmCategory> readAllParadigms(File directory, FormCountProvider formCountProvider) throws IOException {
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + directory);
        }

        List<ParadigmCategory> categories = new ArrayList<>();
        File[] pFiles = directory.listFiles((d, name) -> name.endsWith(".p"));

        if (pFiles == null) {
            throw new IOException("No .p files found in: " + directory);
        }

        for (File pFile : pFiles) {
            String paradigmCatName = pFile.getName().replace(".p", "");
            int numForms = formCountProvider.getFormCount(paradigmCatName);

            if (numForms > 0) {
                ParadigmCategory category = readParadigmCategory(pFile, numForms);
                categories.add(category);
                System.out.println("✓ Read paradigm: " + paradigmCatName + " (" + numForms + " forms, " +
                                 category.getParadigms().size() + " lemmas)");
            } else {
                System.out.println("⚠ Skipping " + paradigmCatName + ": no form count available");
            }
        }

        return categories;
    }

    @Override
    public String getFormatName() {
        return ".p format (Paradigm files)";
    }
}
