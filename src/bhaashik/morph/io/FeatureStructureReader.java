package bhaashik.morph.io;

import bhaashik.morph.model.ParadigmCategoryToFSSetMap;

import java.io.File;
import java.io.IOException;

/**
 * Interface for reading feature structure data from various formats.
 */
public interface FeatureStructureReader {

    /**
     * Reads feature structure mappings from a source.
     *
     * @param source File or directory containing feature structure data
     * @return Map of paradigm categories to feature structures
     * @throws IOException if reading fails
     */
    ParadigmCategoryToFSSetMap readFeatureStructures(File source) throws IOException;

    /**
     * Returns the format name this reader supports.
     */
    String getFormatName();
}
