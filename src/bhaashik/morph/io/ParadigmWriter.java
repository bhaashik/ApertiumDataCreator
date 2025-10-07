package bhaashik.morph.io;

import bhaashik.morph.model.ParadigmCategory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Interface for writing paradigm data to various formats.
 */
public interface ParadigmWriter {

    /**
     * Writes paradigm categories to a file or directory.
     *
     * @param output Target file or directory
     * @param categories List of paradigm categories to write
     * @throws IOException if writing fails
     */
    void writeParadigms(File output, List<ParadigmCategory> categories) throws IOException;

    /**
     * Returns the format name this writer produces.
     */
    String getFormatName();
}
