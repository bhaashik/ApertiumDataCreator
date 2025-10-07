package bhaashik.morph.api;

import bhaashik.morph.model.FeatureStructure;
import bhaashik.morph.model.Lemma;

import java.util.List;
import java.util.Map;

/**
 * Interface for morphological generation - creating surface forms from lemma + features.
 * Implementations can be rule-based, FST-based, or hybrid.
 */
public interface MorphologicalGenerator {

    /**
     * Generates a word form from a lemma and feature specifications.
     *
     * @param lemma The base lemma
     * @param features Feature structure specifying the desired form
     * @return Generated surface form(s) - may return multiple if ambiguous
     */
    List<String> generate(Lemma lemma, FeatureStructure features);

    /**
     * Generates a word form from a lemma and feature map.
     * Convenience method for direct feature specification.
     *
     * @param lemma The base lemma
     * @param featureMap Map of feature names to values
     * @return Generated surface form(s)
     */
    List<String> generate(Lemma lemma, Map<String, String> featureMap);

    /**
     * Generates all possible forms for a given lemma within its paradigm.
     *
     * @param lemma The base lemma
     * @param paradigmCategory The paradigm category name
     * @return Map of feature structures to generated forms
     */
    Map<FeatureStructure, List<String>> generateAllForms(Lemma lemma, String paradigmCategory);
}
