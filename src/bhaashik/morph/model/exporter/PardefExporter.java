package bhaashik.morph.model.exporter;

import bhaashik.morph.model.FeatureStructure;
import bhaashik.morph.model.FeatureStructureEntry;
import bhaashik.morph.model.ParadigmCategory;
import bhaashik.morph.model.SpecificParadigm;
import bhaashik.morph.model.parser.MorphologicalRuleExtractor;

import java.util.List;

public class PardefExporter {

    public static String exportPardef(ParadigmCategory category, SpecificParadigm paradigm, List<FeatureStructureEntry> featureEntries) {
        StringBuilder sb = new StringBuilder();
        String pardefName = category.getName(); // e.g., Noun_m

        sb.append("  <pardef n=\"").append(pardefName).append("\">\n");

        List<String> wordForms = paradigm.getWordForms();
        String lemma = paradigm.getLemma();

        for (int i = 0; i < wordForms.size(); i++) {
            String surface = wordForms.get(i);
            MorphologicalRuleExtractor.MorphTransform mt = MorphologicalRuleExtractor.extractTransform(lemma, surface);

            sb.append("    <e>\n");
            sb.append("      ").append(mt.toDixEntry()).append("\n");

            if (featureEntries != null && i < featureEntries.size()) {
                FeatureStructureEntry fe = featureEntries.get(i);
                FeatureStructure fs = fe.getFeatureStructure();
                for (String tag : fs.getFeatures().values()) {
                    sb.append("      <s n=\"").append(tag).append("\"/>\n");
                }
            }

            sb.append("    </e>\n");
        }

        sb.append("  </pardef>\n");
        return sb.toString();
    }
}
