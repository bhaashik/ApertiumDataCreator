package bhaashik.morph;

import bhaashik.morph.model.MorphologicalUnit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for MorphologicalUnit class.
 */
public class MorphologicalUnitTest {

    @Test
    public void testSingleWordUnit() {
        MorphologicalUnit unit = new MorphologicalUnit("घर");

        assertFalse("Single word should not be multi-word", unit.isMultiWord());
        assertEquals("Word count should be 1", 1, unit.getWordCount());
        assertEquals("Surface form should match", "घर", unit.getSurfaceForm());
        assertEquals("First word should match", "घर", unit.getWord(0));
    }

    @Test
    public void testMultiWordUnit() {
        MorphologicalUnit unit = new MorphologicalUnit("देख रहा है");

        assertTrue("Multi-word unit should be detected", unit.isMultiWord());
        assertEquals("Word count should be 3", 3, unit.getWordCount());
        assertEquals("Surface form should match", "देख रहा है", unit.getSurfaceForm());
        assertEquals("First word should be देख", "देख", unit.getWord(0));
        assertEquals("Second word should be रहा", "रहा", unit.getWord(1));
        assertEquals("Third word should be है", "है", unit.getWord(2));
    }

    @Test
    public void testEmptyUnit() {
        MorphologicalUnit unit = new MorphologicalUnit("");

        assertEquals("Empty unit should have 0 words", 0, unit.getWordCount());
        assertEquals("Surface form should be empty", "", unit.getSurfaceForm());
    }

    @Test
    public void testUnitFromList() {
        java.util.List<String> words = java.util.Arrays.asList("देख", "रहा", "है");
        MorphologicalUnit unit = new MorphologicalUnit(words);

        assertTrue("Should be multi-word", unit.isMultiWord());
        assertEquals("Word count should match", 3, unit.getWordCount());
        assertEquals("Surface form should be joined", "देख रहा है", unit.getSurfaceForm());
    }

    @Test
    public void testEquality() {
        MorphologicalUnit unit1 = new MorphologicalUnit("घर में");
        MorphologicalUnit unit2 = new MorphologicalUnit("घर में");
        MorphologicalUnit unit3 = new MorphologicalUnit("घर");

        assertEquals("Same surface forms should be equal", unit1, unit2);
        assertNotEquals("Different surface forms should not be equal", unit1, unit3);
    }
}
