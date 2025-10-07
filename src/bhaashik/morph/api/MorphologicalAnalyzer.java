package bhaashik.morph.api;

import bhaashik.morph.model.FeatureStructure;
import bhaashik.morph.model.Lemma;

import java.util.List;

/**
 * Interface for morphological analysis - converting surface forms to lemma + features.
 * Implementations can be rule-based, FST-based, or hybrid.
 */
public interface MorphologicalAnalyzer {

    /**
     * Analyzes a word form and returns possible analyses (lemma + feature structure).
     * Multiple analyses may be returned for ambiguous forms.
     *
     * @param wordForm The surface form to analyze (in any supported encoding)
     * @return List of possible analyses, each containing lemma and features
     */
    List<Analysis> analyze(String wordForm);

    /**
     * Represents a single morphological analysis result.
     */
    class Analysis {
        private final Lemma lemma;
        private final FeatureStructure featureStructure;
        private final String paradigmCategory;
        private final double confidence; // Optional: confidence score

        public Analysis(Lemma lemma, FeatureStructure featureStructure, String paradigmCategory) {
            this(lemma, featureStructure, paradigmCategory, 1.0);
        }

        public Analysis(Lemma lemma, FeatureStructure featureStructure, String paradigmCategory, double confidence) {
            this.lemma = lemma;
            this.featureStructure = featureStructure;
            this.paradigmCategory = paradigmCategory;
            this.confidence = confidence;
        }

        public Lemma getLemma() { return lemma; }
        public FeatureStructure getFeatureStructure() { return featureStructure; }
        public String getParadigmCategory() { return paradigmCategory; }
        public double getConfidence() { return confidence; }

        @Override
        public String toString() {
            return String.format("%s<%s> [%s] (%.2f)",
                lemma.getLemmaString(),
                featureStructure.getCategory(),
                paradigmCategory,
                confidence);
        }
    }
}
