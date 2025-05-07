package bhaashik.morph.model;

public class FeatureStructureEntry {
    private final FeatureStructure featureStructure;
//    private final String lemmaForm;     // e.g., "घर"
    private final Lemma lemma;     // e.g., "घर"
    private final String surfaceForm;   // e.g., "घरों"

    public FeatureStructureEntry(FeatureStructure featureStructure, Lemma lemma, String surfaceForm) {
        this.featureStructure = featureStructure;
        this.lemma = lemma;
        this.surfaceForm = surfaceForm;
    }

    public FeatureStructure getFeatureStructure() {
        return featureStructure;
    }

    public String getLemmaForm() {
        return lemma.getLemmaString();
    }

    public String getSurfaceForm() {
        return surfaceForm;
    }

    @Override
    public String toString() {
        return "Entry{FS=" + featureStructure + ", lemma='" + lemma.getLemmaString() + "', surface='" + surfaceForm + "'}";
    }
}
