package bhaashik.morph.model.exporter;

import bhaashik.morph.model.FeatureStructure;
import bhaashik.morph.model.FeatureStructureEntry;
import bhaashik.morph.model.ParCatFeatureStructures;
import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.SpecificParadigm;
import bhaashik.morph.model.parser.MorphologicalRuleExtractor;

import java.util.List;
import java.util.Set;

public class PardefExporter {

    public static String exportPardef(ParadigmCategory category, SpecificParadigm paradigm, ParCatFeatureStructures parCatFeatureStructures) {
        StringBuilder sb = new StringBuilder();
        String pardefName = category.getCategoryName(); // e.g., Noun_m

        sb.append("  <pardef n=\"").append(pardefName).append("\">\n");

        List<String> surfaceForms = paradigm.getLemmaSurfaceForms();
        String lemma = paradigm.getLemma().getLemmaString();

        for (int i = 0; i < surfaceForms.size(); i++) {
            String surface = surfaceForms.get(i);
            MorphologicalRuleExtractor.MorphTransform mt = MorphologicalRuleExtractor.extractTransform(lemma, surface);

            sb.append("    <e>\n");
            sb.append("      ").append(mt.toDixEntry()).append("\n");

            if (parCatFeatureStructures != null && i < parCatFeatureStructures.getFeatureStructureSetSize()) {
                Set<FeatureStructureEntry> featureStructureEntrySet = parCatFeatureStructures.getEntries();

                for(FeatureStructureEntry featureStructureEntry : featureStructureEntrySet) {

                    FeatureStructure featureStructure = featureStructureEntry.getFeatureStructure();
//                    FeatureStructure fs = fe.getFeatureStructure();
                    for (String tag : featureStructure.getAllFeatures().values()) {
                        sb.append("      <s n=\"").append(tag).append("\"/>\n");
                    }
                }

//                FeatureStructureEntry fe = parCatFeatureStructures.getEntries(i);
//                FeatureStructure fs = fe.getFeatureStructure();
//                for (String tag : fs.getAllFeatures().values()) {
//                    sb.append("      <s n=\"").append(tag).append("\"/>\n");
//                }
            }

            sb.append("    </e>\n");
        }

        sb.append("  </pardef>\n");
        return sb.toString();
    }
}
