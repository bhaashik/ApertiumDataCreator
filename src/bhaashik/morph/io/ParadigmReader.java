package bhaashik.morph.io;

import bhaashik.morph.model.ParadigmCategory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Interface for reading paradigm data from various sources and formats.
 * Implementations are format-specific but the API is uniform.
 */
public interface ParadigmReader {

    /**
     * Reads a single paradigm category from a file.
     *
     * @param file The paradigm file
     * @param numForms Expected number of word forms per paradigm
     * @return ParadigmCategory object
     * @throws IOException if reading fails
     */
    ParadigmCategory readParadigmCategory(File file, int numForms) throws IOException;

    /**
     * Reads all paradigm categories from a directory.
     *
     * @param directory Directory containing paradigm files
     * @param formCountProvider Provider that gives the expected number of forms per category
     * @return List of paradigm categories
     * @throws IOException if reading fails
     */
    List<ParadigmCategory> readAllParadigms(File directory, FormCountProvider formCountProvider) throws IOException;

    /**
     * Returns the format name this reader supports.
     */
    String getFormatName();

    /**
     * Functional interface for providing word form counts per paradigm category.
     */
    @FunctionalInterface
    interface FormCountProvider {
        int getFormCount(String paradigmCategoryName);
    }
}
