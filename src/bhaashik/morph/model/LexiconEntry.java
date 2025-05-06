package bhaashik.morph.model;

/**
 * Represents a single entry from the lexicon file.
 */
public class LexiconEntry {
    private final String lemma;
    private final String specificParadigm;
    private final String paradigmCategory;

    public LexiconEntry(String lemma, String specificParadigm, String paradigmCategory) {
        this.lemma = lemma;
        this.specificParadigm = specificParadigm;
        this.paradigmCategory = paradigmCategory;
    }

    public String getLemma() {
        return lemma;
    }

    public String getSpecificParadigm() {
        return specificParadigm;
    }

    public String getParadigmCategory() {
        return paradigmCategory;
    }

    @Override
    public String toString() {
        return "Lemma: " + lemma +
                ", SpecificParadigm: " + specificParadigm +
                ", ParadigmCategory: " + paradigmCategory;
    }
}
