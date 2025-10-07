package bhaashik.morph.api;

import bhaashik.morph.model.LexiconEntry;
import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.ParadigmCategoryToFSSetMap;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Interface for exporting morphological data to various formats.
 * Examples: Apertium .dix, FST source, JSON, custom formats.
 */
public interface MorphologyExporter {

    /**
     * Exports morphological data to a file.
     *
     * @param outputFile Output file
     * @param categories Paradigm categories
     * @param fsMap Feature structure mappings
     * @param lexicon Lexicon entries
     * @throws IOException if export fails
     */
    void export(File outputFile,
                List<ParadigmCategory> categories,
                ParadigmCategoryToFSSetMap fsMap,
                List<LexiconEntry> lexicon) throws IOException;

    /**
     * Gets the format name this exporter produces.
     */
    String getFormatName();

    /**
     * Gets the typical file extension for this format.
     */
    String getFileExtension();
}
