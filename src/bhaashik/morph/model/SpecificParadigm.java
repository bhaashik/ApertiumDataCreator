package bhaashik.morph.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a specific paradigm (set of word forms) for a given lemma.
 */
public class SpecificParadigm {
    private final String lemma;
    private final List<WordForm> wordForms;

    public SpecificParadigm(String lemma) {
        this.lemma = lemma;
        this.wordForms = new ArrayList<>();
    }

    public void addWordForm(WordForm wordForm) {
        wordForms.add(wordForm);
    }

    public String getLemma() {
        return lemma;
    }

    public List<WordForm> getWordForms() {
        return wordForms;
    }

    @Override
    public String toString() {
        return "Lemma: " + lemma + ", WordForms: " + wordForms;
    }
}
