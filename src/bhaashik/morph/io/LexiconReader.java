package bhaashik.morph.io;

import bhaashik.morph.model.LexiconEntry;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Interface for reading lexicon data from various formats.
 */
public interface LexiconReader {

    /**
     * Reads lexicon entries from a file.
     *
     * @param file Lexicon file
     * @return List of lexicon entries
     * @throws IOException if reading fails
     */
    List<LexiconEntry> readLexicon(File file) throws IOException;

    /**
     * Returns the format name this reader supports.
     */
    String getFormatName();
}
