package bhaashik.morph.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a single morphological analysis for a morphological unit.
 * Supports multiple alternative analyses (ambiguity) and probability/frequency information.
 */
public class MorphologicalAnalysis {

    private final MorphologicalUnit unit;
    private final Lemma lemma;
    private final FeatureStructure featureStructure;
    private final String paradigmCategory;

    // Optional: for corpus linguistics and disambiguation
    private double probability;
    private long frequency;

    // Optional: alternative analyses
    private Map<String, String> additionalAttributes;

    public MorphologicalAnalysis(MorphologicalUnit unit, Lemma lemma,
                                FeatureStructure featureStructure,
                                String paradigmCategory) {
        this.unit = unit;
        this.lemma = lemma;
        this.featureStructure = featureStructure;
        this.paradigmCategory = paradigmCategory;
        this.probability = 1.0;
        this.frequency = 0;
        this.additionalAttributes = new HashMap<>();
    }

    public MorphologicalUnit getUnit() {
        return unit;
    }

    public Lemma getLemma() {
        return lemma;
    }

    public FeatureStructure getFeatureStructure() {
        return featureStructure;
    }

    public String getParadigmCategory() {
        return paradigmCategory;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public Map<String, String> getAdditionalAttributes() {
        return additionalAttributes;
    }

    public void addAttribute(String key, String value) {
        additionalAttributes.put(key, value);
    }

    public String getAttribute(String key) {
        return additionalAttributes.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(unit.getSurfaceForm());
        sb.append(" -> ");
        sb.append(lemma.getLemmaString());
        sb.append(" [").append(paradigmCategory).append("]");
        sb.append(" {").append(featureStructure).append("}");
        if (probability < 1.0) {
            sb.append(" (p=").append(String.format("%.3f", probability)).append(")");
        }
        if (frequency > 0) {
            sb.append(" (freq=").append(frequency).append(")");
        }
        return sb.toString();
    }
}
