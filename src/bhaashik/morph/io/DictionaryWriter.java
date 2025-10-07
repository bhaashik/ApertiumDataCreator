package bhaashik.morph.io;

import bhaashik.morph.model.LexiconEntry;
import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.ParadigmCategoryToFSSetMap;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Interface for writing morphological dictionary data to various formats.
 * Implementations should be format-specific (Apertium, JSON, custom, etc.)
 */
public interface DictionaryWriter {

    /**
     * Writes complete morphological dictionary data to a file.
     *
     * @param outputFile Target output file
     * @param categories List of paradigm categories with word forms
     * @param fsMap Feature structure mappings for paradigm categories
     * @param lexicon Lexicon entries (lemma to paradigm mappings)
     * @throws IOException if writing fails
     */
    void writeDictionary(File outputFile,
                        List<ParadigmCategory> categories,
                        ParadigmCategoryToFSSetMap fsMap,
                        List<LexiconEntry> lexicon) throws IOException;

    /**
     * Returns the format name this writer produces.
     */
    String getFormatName();

    /**
     * Returns the typical file extension for this format.
     */
    String getFileExtension();
}
