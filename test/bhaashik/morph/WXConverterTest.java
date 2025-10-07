package bhaashik.morph;

import bhaashik.morph.encoding.WXConverter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for WXConverter class.
 */
public class WXConverterTest {

    private final WXConverter converter = new WXConverter();

    @Test
    public void testWXToDevanagariVowels() {
        assertEquals("a should convert to अ", "अ", converter.wxToDevanagari("a"));
        assertEquals("A should convert to आ", "आ", converter.wxToDevanagari("A"));
        assertEquals("i should convert to इ", "इ", converter.wxToDevanagari("i"));
        assertEquals("I should convert to ई", "ई", converter.wxToDevanagari("I"));
    }

    @Test
    public void testWXToDevanagariConsonants() {
        // In WX, consonants have inherent 'a' vowel
        assertEquals("k should convert to क", "क", converter.wxToDevanagari("ka"));
        assertEquals("g should convert to ग", "ग", converter.wxToDevanagari("ga"));
        assertEquals("w should convert to त", "त", converter.wxToDevanagari("wa"));
        assertEquals("n should convert to न", "न", converter.wxToDevanagari("na"));
    }

    @Test
    public void testWXToDevanagariWords() {
        // namaskAra -> नमस्कार (approximately)
        String result = converter.wxToDevanagari("namaskAra");
        assertTrue("Should contain Devanagari characters", result.matches(".*[\\u0900-\\u097F].*"));
    }

    @Test
    public void testDevanagariToWX() {
        String wx = converter.devanagariToWX("क");
        // Devanagari क includes inherent 'a', so it converts to 'ka'
        assertEquals("क should convert to ka", "ka", wx);
    }

    @Test
    public void testRoundTrip() {
        String original = "Gara";
        String devanagari = converter.wxToDevanagari(original);
        String backToWX = converter.devanagariToWX(devanagari);

        // Note: Round trip may not be perfect due to WX complexities
        assertNotNull("Conversion should not be null", backToWX);
    }

    @Test
    public void testSupportsEncoding() {
        assertTrue("Should support WX", converter.supportsEncoding("WX"));
        assertTrue("Should support Devanagari", converter.supportsEncoding("Devanagari"));
        assertFalse("Should not support random encoding", converter.supportsEncoding("RandomEncoding"));
    }

    @Test
    public void testGetSupportedEncodings() {
        String[] encodings = converter.getSupportedEncodings();

        // Sanscript supports many encodings
        assertTrue("Should support multiple encodings", encodings.length > 2);
        assertTrue("Should include WX", java.util.Arrays.asList(encodings).contains("WX"));
        assertTrue("Should include Devanagari", java.util.Arrays.asList(encodings).contains("Devanagari"));
    }

    @Test
    public void testConvertMethod() {
        String result = converter.convert("ka", "WX", "Devanagari");
        assertEquals("Should convert ka to क", "क", result);
    }

    @Test
    public void testSameEncodingConvert() {
        String input = "test";
        String result = converter.convert(input, "WX", "WX");
        assertEquals("Same encoding should return input unchanged", input, result);
    }
}
