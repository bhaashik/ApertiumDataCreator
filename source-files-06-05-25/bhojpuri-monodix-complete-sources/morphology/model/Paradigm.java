package morphology.model;
import java.util.*;

public class Paradigm {
    private final String lemma;
    private final List<String> forms;
    public Paradigm(String lemma, List<String> forms) {
        this.lemma = lemma; this.forms = forms;
    }
    public String getLemma() { return lemma; }
    public List<String> getForms() { return forms; }
}