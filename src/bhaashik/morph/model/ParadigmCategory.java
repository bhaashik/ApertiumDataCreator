package bhaashik.morph.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a paradigm category, e.g., "Noun_f", containing many specific paradigms.
 */
public class ParadigmCategory {
    private final String categoryName;
    private final List<SpecificParadigm> paradigms;

    public ParadigmCategory(String categoryName) {
        this.categoryName = categoryName;
        this.paradigms = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addSpecificParadigm(SpecificParadigm paradigm) {
        paradigms.add(paradigm);
    }

    public List<SpecificParadigm> getParadigms() {
        return paradigms;
    }

    @Override
    public String toString() {
        return "ParadigmCategory: " + categoryName + ", Paradigms: " + paradigms.size();
    }
}
