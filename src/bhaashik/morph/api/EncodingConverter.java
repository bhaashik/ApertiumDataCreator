package bhaashik.morph.api;

/**
 * Interface for converting between different text encodings.
 * Supports WX notation, Devanagari Unicode, and other Indic scripts.
 */
public interface EncodingConverter {

    /**
     * Converts text from one encoding to another.
     *
     * @param text Input text
     * @param sourceEncoding Source encoding (e.g., "WX", "Devanagari", "UTF8")
     * @param targetEncoding Target encoding
     * @return Converted text
     */
    String convert(String text, String sourceEncoding, String targetEncoding);

    /**
     * Checks if the converter supports a given encoding.
     */
    boolean supportsEncoding(String encoding);

    /**
     * Gets list of supported encodings.
     */
    String[] getSupportedEncodings();
}
