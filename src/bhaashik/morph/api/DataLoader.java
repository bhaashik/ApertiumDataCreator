package bhaashik.morph.api;

import bhaashik.morph.model.LexiconEntry;
import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.ParadigmCategoryToFSSetMap;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Interface for loading morphological data from various sources and formats.
 * Implementations can support different file formats, databases, or remote sources.
 */
public interface DataLoader {

    /**
     * Loads paradigm categories from a directory of .p files.
     *
     * @param directory Directory containing paradigm files
     * @param fsMap Feature structure map to determine word form counts
     * @return List of parsed paradigm categories
     * @throws IOException if loading fails
     */
    List<ParadigmCategory> loadParadigms(File directory, ParadigmCategoryToFSSetMap fsMap) throws IOException;

    /**
     * Loads feature structure mappings from files.
     *
     * @param source Source file or directory
     * @return Paradigm category to feature structure map
     * @throws IOException if loading fails
     */
    ParadigmCategoryToFSSetMap loadFeatureStructures(File source) throws IOException;

    /**
     * Loads lexicon entries.
     *
     * @param lexiconFile Lexicon file
     * @return List of lexicon entries
     * @throws IOException if loading fails
     */
    List<LexiconEntry> loadLexicon(File lexiconFile) throws IOException;

    /**
     * Gets the format name this loader supports.
     */
    String getFormatName();
}
