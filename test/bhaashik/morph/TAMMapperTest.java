package bhaashik.morph;

import bhaashik.morph.util.TAMMapper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for TAMMapper class.
 */
public class TAMMapperTest {

    @Test
    public void testBasicMapping() {
        TAMMapper mapper = new TAMMapper("Bhojpuri", "Hindi");
        mapper.addMapping("ba", "nA");
        mapper.addMapping("yeke", "nA");

        assertEquals("ba should map to nA", "nA", mapper.map("ba"));
        assertEquals("yeke should map to nA", "nA", mapper.map("yeke"));
    }

    @Test
    public void testDefaultMapping() {
        TAMMapper mapper = TAMMapper.createDefaultBMMToHindiMapper();

        assertEquals("ba should map to nA", "nA", mapper.map("ba"));
        assertEquals("yeke should map to nA", "nA", mapper.map("yeke"));
        assertEquals("ilA should map to wA_hE", "wA_hE", mapper.map("ilA"));
        assertEquals("wa should map to rahA", "rahA", mapper.map("wa"));
        assertEquals("gA should map to gA", "gA", mapper.map("gA"));
    }

    @Test
    public void testUnmappedValue() {
        TAMMapper mapper = new TAMMapper("Bhojpuri", "Hindi");
        mapper.addMapping("ba", "nA");

        // Unmapped value should return itself
        assertEquals("Unmapped value should return itself", "xyz", mapper.map("xyz"));
    }

    @Test
    public void testHasMapping() {
        TAMMapper mapper = new TAMMapper("Bhojpuri", "Hindi");
        mapper.addMapping("ba", "nA");

        assertTrue("Should have mapping for ba", mapper.hasMapping("ba"));
        assertFalse("Should not have mapping for xyz", mapper.hasMapping("xyz"));
    }

    @Test
    public void testGetAllMappings() {
        TAMMapper mapper = new TAMMapper("Bhojpuri", "Hindi");
        mapper.addMapping("ba", "nA");
        mapper.addMapping("wa", "rahA");

        java.util.Map<String, String> mappings = mapper.getAllMappings();

        assertEquals("Should have 2 mappings", 2, mappings.size());
        assertTrue("Should contain ba mapping", mappings.containsKey("ba"));
        assertTrue("Should contain wa mapping", mappings.containsKey("wa"));
    }

    @Test
    public void testLanguageInfo() {
        TAMMapper mapper = new TAMMapper("Bhojpuri", "Hindi");

        assertEquals("Source language should be Bhojpuri", "Bhojpuri", mapper.getSourceLang());
        assertEquals("Target language should be Hindi", "Hindi", mapper.getTargetLang());
    }
}
