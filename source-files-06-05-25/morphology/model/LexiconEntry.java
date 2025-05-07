package morphology.model;
public class LexiconEntry {
    private final String lemma, specificParadigm, paradigmCategory;
    public LexiconEntry(String lemma, String specificParadigm, String paradigmCategory) {
        this.lemma = lemma; this.specificParadigm = specificParadigm; this.paradigmCategory = paradigmCategory;
    }
    public String getLemma() { return lemma; }
    public String getSpecificParadigm() { return specificParadigm; }
    public String getParadigmCategory() { return paradigmCategory; }
}