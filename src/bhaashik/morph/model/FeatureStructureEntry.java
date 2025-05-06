package bhaashik.morph.model;

public class FeatureStructureEntry {
    private final FeatureStructure featureStructure;
    private final String lemmaForm;     // e.g., "घर"
    private final String surfaceForm;   // e.g., "घरों"

    public FeatureStructureEntry(FeatureStructure featureStructure, String lemmaForm, String surfaceForm) {
        this.featureStructure = featureStructure;
        this.lemmaForm = lemmaForm;
        this.surfaceForm = surfaceForm;
    }

    public FeatureStructure getFeatureStructure() {
        return featureStructure;
    }

    public String getLemmaForm() {
        return lemmaForm;
    }

    public String getSurfaceForm() {
        return surfaceForm;
    }

    @Override
    public String toString() {
        return "Entry{FS=" + featureStructure + ", lemma='" + lemmaForm + "', surface='" + surfaceForm + "'}";
    }
}
