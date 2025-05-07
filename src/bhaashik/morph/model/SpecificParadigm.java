package bhaashik.morph.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a specific paradigm (set of word forms) for a given lemma.
 */
public class SpecificParadigm {
    private final Lemma lemma;
    private final List<WordForm> wordForms;

    public SpecificParadigm(Lemma lemma) {
        this.lemma = lemma;
        this.wordForms = new ArrayList<>();
    }

    public void addWordForm(WordForm wordForm) {
        wordForms.add(wordForm);
    }

    public Lemma getLemma() {
        return lemma;
    }

    public List<WordForm> getWordForms() {
        return wordForms;
    }

    public List<String> getLemmaSurfaceForms() {
        List<String> surfaceForms = new ArrayList<>();

        wordForms.stream().forEach(wordForm -> surfaceForms.add(wordForm.getForm()));

        return surfaceForms;
    }

    @Override
    public String toString() {
        return "Lemma: " + lemma + ", WordForms: " + wordForms;
    }
}
