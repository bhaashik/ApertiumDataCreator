package morphology.util;
import java.io.*; import java.util.*;
import morphology.model.*;

public class DixWriter {
    public void write(File out, List<ParadigmCategory> categories, Map<String, List<FeatureStructureEntry>> fsMap, List<LexiconEntry> lexicon) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<dictionary>\n  <alphabet>अ आ इ ई उ ऊ ए ऐ ओ औ क ख ग घ च छ ज झ ट ठ ड ढ त थ द ध न प फ ब भ म य र ल व श ष स ह ् ा ि ी ु ू ृ े ै ो ौ ं ् ड़ ढ़ ॐ</alphabet>\n");
            bw.write("  <sdefs>\n    <sdef n=\"n\"/><sdef n=\"m\"/><sdef n=\"f\"/><sdef n=\"sg\"/><sdef n=\"pl\"/><sdef n=\"3\"/><sdef n=\"d\"/><sdef n=\"o\"/><sdef n=\"0\"/>\n  </sdefs>\n");
            bw.write("  <section id=\"main\">\n");
            for (ParadigmCategory cat : categories) {
                bw.write("    <pardef n=\"" + cat.getName() + "\">\n");
                for (Paradigm p : cat.getParadigms()) {
                    List<FeatureStructureEntry> fsList = fsMap.getOrDefault(cat.getName(), new ArrayList<>());
                    List<String> forms = p.getForms();
                    for (int i = 0; i < forms.size(); i++) {
                        String form = forms.get(i);
                        String suffix = form.startsWith(p.getLemma()) ? form.substring(p.getLemma().length()) : "";
                        bw.write("      <e><p><l>" + p.getLemma() + "</l><r>" + suffix + "</r></p>");
                        if (i < fsList.size()) {
                            for (String f : fsList.get(i).getFeatures()) {
                                bw.write("<s n=\"" + f + "\"/>");
                            }
                        }
                        bw.write("</e>\n");
                    }
                }
                bw.write("    </pardef>\n");
            }
            for (LexiconEntry entry : lexicon) {
                bw.write("    <e lm=\"" + entry.getLemma() + "\"><i>" + entry.getLemma() + "</i><par n=\"" + entry.getParadigmCategory() + "\"/></e>\n");
            }
            bw.write("  </section>\n</dictionary>");
        }
    }
}