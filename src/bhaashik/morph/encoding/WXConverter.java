package bhaashik.morph.encoding;

import bhaashik.morph.api.EncodingConverter;
import com.wellebee.sanskrit.Sanscript;

/**
 * Converter for WX notation (Roman transliteration for Indic scripts).
 * WX is a widely-used ASCII-based encoding for Devanagari and other Indic scripts.
 *
 * This implementation uses the Sanscript library for accurate transliteration.
 * Reference: https://github.com/indic-transliteration/sanscript.java
 */
public class WXConverter implements EncodingConverter {

    private final Sanscript sanscript;

    public WXConverter() {
        this.sanscript = new Sanscript();
    }

    @Override
    public String convert(String text, String sourceEncoding, String targetEncoding) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        if (sourceEncoding.equalsIgnoreCase(targetEncoding)) {
            return text;
        }

        // Normalize encoding names to Sanscript's scheme names
        String from = normalizeEncodingName(sourceEncoding);
        String to = normalizeEncodingName(targetEncoding);

        if (from == null || to == null) {
            throw new UnsupportedOperationException(
                "Conversion from " + sourceEncoding + " to " + targetEncoding + " not supported"
            );
        }

        try {
            return sanscript.t(text, from, to);
        } catch (Exception e) {
            throw new RuntimeException("Error converting from " + sourceEncoding + " to " + targetEncoding, e);
        }
    }

    /**
     * Normalize encoding names to Sanscript's scheme names.
     * @param encoding User-provided encoding name
     * @return Sanscript scheme name, or null if not supported
     */
    private String normalizeEncodingName(String encoding) {
        if (encoding == null) {
            return null;
        }

        String normalized = encoding.toLowerCase();
        switch (normalized) {
            case "wx":
                return "wx";
            case "devanagari":
            case "devanāgarī":
                return "devanagari";
            case "bengali":
            case "bangla":
                return "bengali";
            case "gujarati":
                return "gujarati";
            case "gurmukhi":
            case "punjabi":
                return "gurmukhi";
            case "kannada":
                return "kannada";
            case "malayalam":
                return "malayalam";
            case "oriya":
            case "odia":
                return "oriya";
            case "tamil":
                return "tamil";
            case "telugu":
                return "telugu";
            case "iast":
                return "iast";
            case "itrans":
                return "itrans";
            case "hk":
            case "harvard-kyoto":
                return "hk";
            case "slp1":
                return "slp1";
            case "velthuis":
                return "velthuis";
            default:
                return null;
        }
    }

    public String wxToDevanagari(String wxText) {
        return convert(wxText, "WX", "Devanagari");
    }

    public String devanagariToWX(String devanagariText) {
        return convert(devanagariText, "Devanagari", "WX");
    }

    @Override
    public boolean supportsEncoding(String encoding) {
        return normalizeEncodingName(encoding) != null;
    }

    @Override
    public String[] getSupportedEncodings() {
        return new String[]{
            "WX", "Devanagari", "Bengali", "Gujarati", "Gurmukhi",
            "Kannada", "Malayalam", "Oriya", "Tamil", "Telugu",
            "IAST", "ITRANS", "HK", "SLP1", "Velthuis"
        };
    }

    public static void main(String[] args) {
        WXConverter converter = new WXConverter();

        // Test WX to Devanagari
        String wx = "namaskAra";
        String dev = converter.wxToDevanagari(wx);
        System.out.println("WX: " + wx + " -> Devanagari: " + dev);

        // Test Devanagari to WX
        String dev2 = "नमस्कार";
        String wx2 = converter.devanagariToWX(dev2);
        System.out.println("Devanagari: " + dev2 + " -> WX: " + wx2);
    }
}
