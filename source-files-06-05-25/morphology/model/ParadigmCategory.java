package morphology.model;
import java.util.*;

public class ParadigmCategory {
    private final String name;
    private final List<Paradigm> paradigms = new ArrayList<>();
    public ParadigmCategory(String name) { this.name = name; }
    public String getName() { return name; }
    public List<Paradigm> getParadigms() { return paradigms; }
    public void addParadigm(Paradigm p) { paradigms.add(p); }
}