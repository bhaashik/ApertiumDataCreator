package bhaashik.morph.model.parser;

import bhaashik.morph.model.LexiconEntry;

import java.io.*;
import java.util.*;

/**
 * Parses a lexicon file and extracts lemma-paradigm associations.
 */
public class LexiconParser {

    /**
     * Parses a lexicon file to extract lemma and its paradigm information.
     *
     * @param file the lexicon file
     * @return list of LexiconEntry objects
     * @throws IOException if file cannot be read
     */
    public List<LexiconEntry> parseLexiconFile(File file) throws IOException {
        List<LexiconEntry> entries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove quotes and split
                String[] parts = line.replace("\"", "").split(",");

                if (parts.length < 4) continue; // Skip malformed lines

                String lemma = parts[0].trim();
                String specificParadigm = parts[2].trim();
                String paradigmCategory = parts[3].trim();

                LexiconEntry entry = new LexiconEntry(lemma, specificParadigm, paradigmCategory);
                entries.add(entry);
            }
        }

        return entries;
    }

    public static void main(String[] args) {
        File lexiconFile = new File("path/to/lexicon.txt");

        LexiconParser parser = new LexiconParser();
        try {
            List<LexiconEntry> entries = parser.parseLexiconFile(lexiconFile);
            for (LexiconEntry entry : entries) {
                System.out.println(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
