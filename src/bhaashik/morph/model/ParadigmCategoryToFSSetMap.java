package bhaashik.morph.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ParadigmCategoryToFSSetMap {

    private final LinkedHashMap<String, ParCatFeatureStructures> paradigmCategoryFSEntriesMap;

    public ParadigmCategoryToFSSetMap()
    {
        paradigmCategoryFSEntriesMap = new LinkedHashMap<>();
    }

    public ParCatFeatureStructures getParadigmCategoryFSSet(String paradigmCategoryName) {
        return paradigmCategoryFSEntriesMap.get(paradigmCategoryName);
    }

    public void addParadigmCatogory(String paradigmCategory, ParCatFeatureStructures parCatFeatureStructures)
    {
        paradigmCategoryFSEntriesMap.put(paradigmCategory, parCatFeatureStructures);
    }

    public int getWordFormCount(String paradigmCategory)
    {
//        return entries.size();
        if(getParadigmCategoryFSSet(paradigmCategory) != null) {
            return getParadigmCategoryFSSet(paradigmCategory).getFeatureStructureSetSize();
        }

        return 0;
    }

    public LinkedHashMap<String, Integer> getParadigmCategoryNumForms()
    {
        LinkedHashMap<String, Integer> paradigmCategoryNumForms = new LinkedHashMap<>();

        paradigmCategoryFSEntriesMap.entrySet().stream()
                .forEach(
                        entry -> {
                            paradigmCategoryNumForms.put(entry.getKey(), entry.getValue().getFeatureStructureSetSize());
                        }
               );

        return paradigmCategoryNumForms;
    }

    public int getNumParadigmCategories()
    {
        return paradigmCategoryFSEntriesMap.size();
    }

    public ArrayList<String> getParadigmCategoryNames() {
            ArrayList<String> paradigmCategoryNames = new ArrayList<>();

            paradigmCategoryFSEntriesMap.entrySet().stream().forEach(
                entry -> {
                paradigmCategoryNames.add(entry.getKey());
            });

        return paradigmCategoryNames;
    }

    public ParCatFeatureStructures getParCatFeatureStructures(String paradigmCategory)
    {
        return paradigmCategoryFSEntriesMap.get(paradigmCategory);
    }
}
