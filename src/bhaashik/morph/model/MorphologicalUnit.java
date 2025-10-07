package bhaashik.morph.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a morphological unit, which may consist of one or more words.
 * This aligns with modern NLP frameworks like Universal Dependencies and UniMorph.
 *
 * Examples:
 * - Single word: "घरों" (gharoN - houses)
 * - Multi-word: "देख रहा है" (dekh raha hai - is seeing)
 */
public class MorphologicalUnit {

    private final List<String> words;
    private final String surfaceForm;

    public MorphologicalUnit(String surfaceForm) {
        this.surfaceForm = surfaceForm;
        this.words = new ArrayList<>();

        // Split by whitespace for multi-word units
        if (surfaceForm != null && !surfaceForm.isEmpty()) {
            String[] parts = surfaceForm.trim().split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    words.add(part);
                }
            }
        }
    }

    public MorphologicalUnit(List<String> words) {
        this.words = new ArrayList<>(words);
        this.surfaceForm = String.join(" ", words);
    }

    /**
     * Returns true if this is a multi-word unit.
     */
    public boolean isMultiWord() {
        return words.size() > 1;
    }

    /**
     * Returns the number of words in this unit.
     */
    public int getWordCount() {
        return words.size();
    }

    /**
     * Returns the word at the given index.
     */
    public String getWord(int index) {
        return words.get(index);
    }

    /**
     * Returns all words in this unit.
     */
    public List<String> getWords() {
        return new ArrayList<>(words);
    }

    /**
     * Returns the complete surface form (all words joined).
     */
    public String getSurfaceForm() {
        return surfaceForm;
    }

    @Override
    public String toString() {
        return surfaceForm + (isMultiWord() ? " [multi-word]" : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MorphologicalUnit that = (MorphologicalUnit) o;
        return surfaceForm.equals(that.surfaceForm);
    }

    @Override
    public int hashCode() {
        return surfaceForm.hashCode();
    }
}
