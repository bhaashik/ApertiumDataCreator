package bhaashik.morph.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ParadigmFSEntries {
    private final String paradigmCategoryName;
    private final Set<FeatureStructureEntry> entries;

    public ParadigmFSEntries(String paradigmCategoryName) {
        this.paradigmCategoryName = paradigmCategoryName;
        this.entries = new LinkedHashSet<>();
    }

    public String getParadigmCategoryName() {
        return paradigmCategoryName;
    }

//    public List<FeatureStructureEntry> getEntries() {
//        return entries;
//    }
    public Set<FeatureStructureEntry> getEntries() {
        return entries;
    }

    public void addEntry(FeatureStructureEntry entry) {
        entries.add(entry);
    }

    @Override
    public String toString() {
        return "ParadigmFSEntries{" +
                "category='" + paradigmCategoryName + '\'' +
                ", entries=" + entries.size() +
                '}';
    }
}
