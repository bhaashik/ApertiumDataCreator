package bhaashik.morph.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class ParCatFeatureStructures {
//    private final String paradigmCategoryName;
    private final Set<FeatureStructureEntry> entries;

//    public ParadigmCategoryFSEntries(String paradigmCategoryName) {
    public ParCatFeatureStructures() {
//        this.paradigmCategoryName = paradigmCategoryName;
        this.entries = new LinkedHashSet<>();
    }
//
//    public String getParadigmCategoryName() {
//        return paradigmCategoryName;
//    }

//    public List<FeatureStructureEntry> getEntries() {
//        return entries;
//    }
    public Set<FeatureStructureEntry> getEntries() {
        return entries;
    }

    public void addEntry(FeatureStructureEntry entry) {
        entries.add(entry);
    }

    public int getFeatureStructureSetSize()
    {
        return entries.size();
    }

    @Override
    public String toString() {
        return "ParadigmFSEntries{" +
//                "category='" + paradigmCategoryName + '\'' +
                ", entries=" + entries.size() +
                '}';
    }
}
