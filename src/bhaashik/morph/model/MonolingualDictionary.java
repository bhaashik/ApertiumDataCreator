package bhaashik.morph.model;

import java.util.*;

/**
 * Represents a monolingual dictionary that maps morphological units (word forms)
 * to their paradigm categories and analyses.
 *
 * Supports:
 * - Multiple analyses per word form (ambiguity)
 * - Probability/frequency information for corpus linguistics
 * - Additional attributes per entry
 */
public class MonolingualDictionary {

    private final String language;
    private final Map<String, List<MorphologicalAnalysis>> surfaceToAnalyses;
    private final Map<String, List<String>> lemmaToSurfaces;

    public MonolingualDictionary(String language) {
        this.language = language;
        this.surfaceToAnalyses = new HashMap<>();
        this.lemmaToSurfaces = new HashMap<>();
    }

    /**
     * Adds a morphological analysis to the dictionary.
     */
    public void addAnalysis(MorphologicalAnalysis analysis) {
        String surface = analysis.getUnit().getSurfaceForm();
        String lemma = analysis.getLemma().getLemmaString();

        // Add to surface -> analyses map
        surfaceToAnalyses.computeIfAbsent(surface, k -> new ArrayList<>()).add(analysis);

        // Add to lemma -> surfaces map (for generation)
        lemmaToSurfaces.computeIfAbsent(lemma, k -> new ArrayList<>()).add(surface);
    }

    /**
     * Gets all possible analyses for a given surface form.
     * Returns empty list if not found.
     */
    public List<MorphologicalAnalysis> getAnalyses(String surfaceForm) {
        return surfaceToAnalyses.getOrDefault(surfaceForm, new ArrayList<>());
    }

    /**
     * Gets all surface forms for a given lemma (for generation).
     */
    public List<String> getSurfaceForms(String lemma) {
        return lemmaToSurfaces.getOrDefault(lemma, new ArrayList<>());
    }

    /**
     * Checks if the dictionary contains analyses for the given surface form.
     */
    public boolean contains(String surfaceForm) {
        return surfaceToAnalyses.containsKey(surfaceForm);
    }

    /**
     * Returns true if the surface form has multiple analyses (is ambiguous).
     */
    public boolean isAmbiguous(String surfaceForm) {
        List<MorphologicalAnalysis> analyses = surfaceToAnalyses.get(surfaceForm);
        return analyses != null && analyses.size() > 1;
    }

    /**
     * Gets the number of unique surface forms in the dictionary.
     */
    public int getSurfaceFormCount() {
        return surfaceToAnalyses.size();
    }

    /**
     * Gets the number of unique lemmas in the dictionary.
     */
    public int getLemmaCount() {
        return lemmaToSurfaces.size();
    }

    /**
     * Gets all surface forms in the dictionary.
     */
    public Set<String> getAllSurfaceForms() {
        return surfaceToAnalyses.keySet();
    }

    /**
     * Gets all lemmas in the dictionary.
     */
    public Set<String> getAllLemmas() {
        return lemmaToSurfaces.keySet();
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "MonolingualDictionary{" +
                "language='" + language + '\'' +
                ", surfaceForms=" + getSurfaceFormCount() +
                ", lemmas=" + getLemmaCount() +
                '}';
    }
}
