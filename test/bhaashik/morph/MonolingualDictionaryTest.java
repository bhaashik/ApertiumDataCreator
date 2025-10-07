package bhaashik.morph;

import bhaashik.morph.model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for MonolingualDictionary class.
 */
public class MonolingualDictionaryTest {

    private MonolingualDictionary dict;
    private MorphologicalUnit unit1;
    private MorphologicalUnit unit2;
    private Lemma lemma1;
    private Lemma lemma2;

    @Before
    public void setUp() {
        dict = new MonolingualDictionary("Hindi");

        unit1 = new MorphologicalUnit("घरों");
        unit2 = new MorphologicalUnit("घर");

        lemma1 = new Lemma("घर");
        lemma2 = new Lemma("लड़का");
    }

    @Test
    public void testAddAnalysis() {
        FeatureStructure fs = new FeatureStructure(
            lemma1, "n", "m", "pl", "", "o", "0", "0", new java.util.HashMap<>()
        );

        MorphologicalAnalysis analysis = new MorphologicalAnalysis(
            unit1, lemma1, fs, "Noun_m"
        );

        dict.addAnalysis(analysis);

        assertTrue("Dictionary should contain the surface form", dict.contains("घरों"));
        assertEquals("Should have 1 analysis", 1, dict.getAnalyses("घरों").size());
    }

    @Test
    public void testMultipleAnalyses() {
        FeatureStructure fs1 = new FeatureStructure(
            lemma1, "n", "m", "pl", "", "o", "0", "0", new java.util.HashMap<>()
        );
        FeatureStructure fs2 = new FeatureStructure(
            lemma1, "v", "m", "sg", "", "d", "0", "0", new java.util.HashMap<>()
        );

        MorphologicalAnalysis analysis1 = new MorphologicalAnalysis(unit1, lemma1, fs1, "Noun_m");
        MorphologicalAnalysis analysis2 = new MorphologicalAnalysis(unit1, lemma1, fs2, "Verb");

        dict.addAnalysis(analysis1);
        dict.addAnalysis(analysis2);

        assertTrue("Should be ambiguous", dict.isAmbiguous("घरों"));
        assertEquals("Should have 2 analyses", 2, dict.getAnalyses("घरों").size());
    }

    @Test
    public void testGetSurfaceForms() {
        FeatureStructure fs = new FeatureStructure(
            lemma1, "n", "m", "sg", "", "d", "0", "0", new java.util.HashMap<>()
        );

        MorphologicalAnalysis analysis1 = new MorphologicalAnalysis(unit1, lemma1, fs, "Noun_m");
        MorphologicalAnalysis analysis2 = new MorphologicalAnalysis(unit2, lemma1, fs, "Noun_m");

        dict.addAnalysis(analysis1);
        dict.addAnalysis(analysis2);

        java.util.List<String> surfaces = dict.getSurfaceForms("घर");

        assertEquals("Should have 2 surface forms for lemma", 2, surfaces.size());
        assertTrue("Should contain घरों", surfaces.contains("घरों"));
        assertTrue("Should contain घर", surfaces.contains("घर"));
    }

    @Test
    public void testCounts() {
        FeatureStructure fs1 = new FeatureStructure(
            lemma1, "n", "m", "sg", "", "d", "0", "0", new java.util.HashMap<>()
        );
        FeatureStructure fs2 = new FeatureStructure(
            lemma2, "n", "m", "sg", "", "d", "0", "0", new java.util.HashMap<>()
        );

        dict.addAnalysis(new MorphologicalAnalysis(unit1, lemma1, fs1, "Noun_m"));
        dict.addAnalysis(new MorphologicalAnalysis(unit2, lemma2, fs2, "Noun_m"));

        assertEquals("Should have 2 surface forms", 2, dict.getSurfaceFormCount());
        assertEquals("Should have 2 lemmas", 2, dict.getLemmaCount());
    }

    @Test
    public void testEmptyDictionary() {
        assertFalse("Empty dict should not contain anything", dict.contains("test"));
        assertFalse("Empty dict should not be ambiguous", dict.isAmbiguous("test"));
        assertEquals("Empty dict should have 0 surface forms", 0, dict.getSurfaceFormCount());
        assertEquals("Empty dict should have 0 lemmas", 0, dict.getLemmaCount());
    }

    @Test
    public void testLanguage() {
        assertEquals("Language should be Hindi", "Hindi", dict.getLanguage());
    }
}
