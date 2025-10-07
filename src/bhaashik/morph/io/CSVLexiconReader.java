package bhaashik.morph.io;

import bhaashik.morph.model.LexiconEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reader for CSV-format lexicon files.
 * Expected format: "lemma","field2","specific_paradigm","paradigm_category",...
 */
public class CSVLexiconReader implements LexiconReader {

    @Override
    public List<LexiconEntry> readLexicon(File file) throws IOException {
        List<LexiconEntry> entries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove quotes and split by comma
                String[] parts = line.replace("\"", "").split(",");

                if (parts.length < 4) {
                    continue; // Skip malformed lines
                }

                String lemma = parts[0].trim();
                String specificParadigm = parts[2].trim();
                String paradigmCategory = parts[3].trim();

                LexiconEntry entry = new LexiconEntry(lemma, specificParadigm, paradigmCategory);
                entries.add(entry);
            }
        }

        System.out.println("✓ Read " + entries.size() + " lexicon entries from " + file.getName());
        return entries;
    }

    @Override
    public String getFormatName() {
        return "CSV Lexicon Format";
    }
}
