package bhaashik.morph.model.parser;

import bhaashik.morph.model.Lemma;
import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.SpecificParadigm;
import bhaashik.morph.model.WordForm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Parser for .p files representing paradigm categories and their specific paradigms.
 */
public class ParadigmFileParser {

    /**
     * Parses a .p file and returns a populated ParadigmCategory object.
     *
     * @param file the .p file to parse
     * @return ParadigmCategory instance with populated data
     * @throws IOException if file cannot be read
     */
    public ParadigmCategory parseParadigmFile(File file, int numWrdForms) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String categoryName = reader.readLine(); // First line is the paradigm category
            if (categoryName == null || categoryName.isBlank()) {
                throw new IllegalArgumentException("Empty or malformed paradigm file: " + file.getName());
            }

            ParadigmCategory category = new ParadigmCategory(categoryName);
            List<String> allLines = reader.lines()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .toList();

            int i = 0;

            // Discover number of forms per lemma by reading the first paradigm
            if (allLines.size() < 2) {
                throw new IllegalArgumentException("Insufficient data for parsing in: " + file.getName());
            }

//            String firstLemma = allLines.get(0);
//            int count = 0;
//            for (int j = 1; j < allLines.size(); j++) {
//                if (allLines.get(j).equals(firstLemma)) break;
//                count++;
//            }

            int numForms = numWrdForms;

            while (i < allLines.size()) {
                String lemma = allLines.get(i++);
                SpecificParadigm specificParadigm = new SpecificParadigm(new Lemma(lemma));

                for (int j = 0; j < numForms && i < allLines.size(); j++) {
                    specificParadigm.addWordForm(new WordForm(allLines.get(i++)));
                }

                category.addSpecificParadigm(specificParadigm);
            }

            return category;
        }
    }

    public static void main(String[] args) {
        File file = new File("path/to/Noun_f.p");

        ParadigmFileParser parser = new ParadigmFileParser();
        try {
            ParadigmCategory category = parser.parseParadigmFile(file, 4);
            System.out.println("Parsed category: " + category.getCategoryName());
            for (SpecificParadigm p : category.getParadigms()) {
                System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

