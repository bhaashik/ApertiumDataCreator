package bhaashik.morph.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TAM (Tense-Aspect-Mood) Mapper for cross-language generation.
 * Maps TAM markers from source languages (Bhojpuri, Maithili, Magahi) to target language (Hindi).
 */
public class TAMMapper {

    private final Map<String, String> sourceToTargetMap;
    private final String sourceLang;
    private final String targetLang;

    public TAMMapper(String sourceLang, String targetLang) {
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
        this.sourceToTargetMap = new HashMap<>();
    }

    /**
     * Loads TAM mappings from a file.
     * Expected format: source_TAM\ttarget_TAM
     */
    public void loadMappingsFromFile(File mappingFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(mappingFile))) {
            String line;
            boolean headerSkipped = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Skip empty lines and comments
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                // Skip header line (SL\tTL)
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                // Parse mapping line
                String[] parts = line.split("\\t");
                if (parts.length >= 2) {
                    String sourceTAM = parts[0].trim();
                    String targetTAM = parts[1].trim();
                    sourceToTargetMap.put(sourceTAM, targetTAM);
                }
            }
        }

        System.out.println("Loaded " + sourceToTargetMap.size() + " TAM mappings from " +
                         sourceLang + " to " + targetLang);
    }

    /**
     * Adds a single TAM mapping.
     */
    public void addMapping(String sourceTAM, String targetTAM) {
        sourceToTargetMap.put(sourceTAM, targetTAM);
    }

    /**
     * Maps a source TAM marker to target language.
     * Returns the source TAM if no mapping is found.
     */
    public String map(String sourceTAM) {
        return sourceToTargetMap.getOrDefault(sourceTAM, sourceTAM);
    }

    /**
     * Checks if a mapping exists for the given source TAM.
     */
    public boolean hasMapping(String sourceTAM) {
        return sourceToTargetMap.containsKey(sourceTAM);
    }

    /**
     * Gets all mappings.
     */
    public Map<String, String> getAllMappings() {
        return new HashMap<>(sourceToTargetMap);
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public String getTargetLang() {
        return targetLang;
    }

    /**
     * Creates a default TAM mapper for Bhojpuri/Maithili/Magahi to Hindi.
     * Uses the mappings from TAM-Mapping.md
     */
    public static TAMMapper createDefaultBMMToHindiMapper() {
        TAMMapper mapper = new TAMMapper("BMM", "Hindi");

        // Default mappings from TAM-Mapping.md
        mapper.addMapping("gA", "gA");
        mapper.addMapping("e", "e");
        mapper.addMapping("kara", "kara");
        mapper.addMapping("ba", "nA");
        mapper.addMapping("yeke", "nA");
        mapper.addMapping("ilA", "wA_hE");
        mapper.addMapping("wa", "rahA");
        mapper.addMapping("wa1", "wA_huA");
        mapper.addMapping("wai", "we_hI");
        mapper.addMapping("wai1", "wA_huA");
        mapper.addMapping("ala", "yA_asp");
        mapper.addMapping("yala1", "yA1_huA");
        mapper.addMapping("yala", "yA_huA");
        mapper.addMapping("A", "hE");
        mapper.addMapping("ila", "yA");
        mapper.addMapping("ila1", "yA1");
        mapper.addMapping("yale", "yA");
        mapper.addMapping("yale1", "yA1");
        mapper.addMapping("WA", "WA");
        mapper.addMapping("hE", "hE");
        mapper.addMapping("kA", "kA");
        mapper.addMapping("ko", "ko");
        mapper.addMapping("se", "se");
        mapper.addMapping("meM", "meM");
        mapper.addMapping("para", "para");

        return mapper;
    }

    @Override
    public String toString() {
        return String.format("TAMMapper[%s->%s, %d mappings]",
                           sourceLang, targetLang, sourceToTargetMap.size());
    }

    public static void main(String[] args) {
        try {
            // Test loading from file
            File mappingFile = new File("TAM-Mapping.md");
            if (mappingFile.exists()) {
                TAMMapper mapper = new TAMMapper("BMM", "Hindi");
                mapper.loadMappingsFromFile(mappingFile);

                // Test some mappings
                System.out.println("ba -> " + mapper.map("ba"));
                System.out.println("yeke -> " + mapper.map("yeke"));
                System.out.println("ilA -> " + mapper.map("ilA"));
            } else {
                System.out.println("Using default mappings");
                TAMMapper mapper = TAMMapper.createDefaultBMMToHindiMapper();
                System.out.println(mapper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
