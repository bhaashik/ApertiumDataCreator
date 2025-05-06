package bhaashik.morph.model;

import java.util.ArrayList;
import java.util.List;

public class ParadigmFeatureSet {
    private final String paradigmCategoryName;
    private final List<FeatureStructureEntry> entries;

    public ParadigmFeatureSet(String paradigmCategoryName) {
        this.paradigmCategoryName = paradigmCategoryName;
        this.entries = new ArrayList<>();
    }

    public String getParadigmCategoryName() {
        return paradigmCategoryName;
    }

    public List<FeatureStructureEntry> getEntries() {
        return entries;
    }

    public void addEntry(FeatureStructureEntry entry) {
        entries.add(entry);
    }

    @Override
    public String toString() {
        return "ParadigmFeatureSet{" +
                "category='" + paradigmCategoryName + '\'' +
                ", entries=" + entries.size() +
                '}';
    }
}
