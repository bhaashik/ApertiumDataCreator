package bhaashik.morph;

import bhaashik.morph.algorithm.LongestCommonPrefixStrategy;
import bhaashik.morph.algorithm.LongestCommonSubsequenceStrategy;
import bhaashik.morph.algorithm.StemExtractionStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for stem extraction algorithms.
 */
public class StemExtractionTest {

    @Test
    public void testLCPWithSuffix() {
        StemExtractionStrategy strategy = new LongestCommonPrefixStrategy();

        // घर -> घरों (ghar -> gharoN)
        StemExtractionStrategy.StemAffixResult result = strategy.extract("घर", "घरों");

        assertEquals("Stem should be घर", "घर", result.getStem());
        assertEquals("Lemma suffix should be empty", "", result.getLemmaSuffix());
        assertEquals("Inflected suffix should be ों", "ों", result.getInflectedSuffix());
    }

    @Test
    public void testLCPWithNoChange() {
        StemExtractionStrategy strategy = new LongestCommonPrefixStrategy();

        // Same word
        StemExtractionStrategy.StemAffixResult result = strategy.extract("घर", "घर");

        assertEquals("Stem should be घर", "घर", result.getStem());
        assertEquals("Lemma suffix should be empty", "", result.getLemmaSuffix());
        assertEquals("Inflected suffix should be empty", "", result.getInflectedSuffix());
    }

    @Test
    public void testLCPWithPrefix() {
        StemExtractionStrategy strategy = new LongestCommonPrefixStrategy();

        // Testing with prefix change (rare in Indic languages)
        StemExtractionStrategy.StemAffixResult result = strategy.extract("कर", "करना");

        assertEquals("Stem should be कर", "कर", result.getStem());
        assertEquals("Inflected suffix should be ना", "ना", result.getInflectedSuffix());
    }

    @Test
    public void testLCSBasic() {
        StemExtractionStrategy strategy = new LongestCommonSubsequenceStrategy();

        StemExtractionStrategy.StemAffixResult result = strategy.extract("घर", "घरों");

        assertNotNull("Result should not be null", result);
        assertEquals("Original lemma should be preserved", "घर", result.getLemma());
        assertEquals("Original inflected form should be preserved", "घरों", result.getInflectedForm());
    }

    @Test
    public void testLCPEmptyStrings() {
        StemExtractionStrategy strategy = new LongestCommonPrefixStrategy();

        StemExtractionStrategy.StemAffixResult result = strategy.extract("", "test");

        assertEquals("Empty lemma should return empty stem", "", result.getStem());
    }

    @Test
    public void testLCPNullInput() {
        StemExtractionStrategy strategy = new LongestCommonPrefixStrategy();

        StemExtractionStrategy.StemAffixResult result = strategy.extract(null, "test");

        assertNotNull("Should handle null input", result);
        assertEquals("Stem should be empty", "", result.getStem());
    }

    @Test
    public void testStrategyName() {
        StemExtractionStrategy lcpStrategy = new LongestCommonPrefixStrategy();
        StemExtractionStrategy lcsStrategy = new LongestCommonSubsequenceStrategy();

        assertTrue("LCP strategy name should contain 'Prefix'",
                  lcpStrategy.getStrategyName().contains("Prefix"));
        assertTrue("LCS strategy name should contain 'Subsequence'",
                  lcsStrategy.getStrategyName().contains("Subsequence"));
    }
}
