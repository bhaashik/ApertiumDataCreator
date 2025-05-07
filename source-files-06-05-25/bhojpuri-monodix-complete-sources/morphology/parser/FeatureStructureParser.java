package morphology.parser;
import java.io.*; import java.util.*;
import morphology.model.*;

public class FeatureStructureParser {
    public Map<String, List<FeatureStructureEntry>> parse(File file) throws IOException {
        Map<String, List<FeatureStructureEntry>> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line; String current = null;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("[[")) {
                current = line.replaceAll("[\[\]]", "");
                map.put(current, new ArrayList<>());
            } else if (line.startsWith("<fs")) {
                String fs = line.substring(line.indexOf("'") + 1, line.lastIndexOf("'"));
                List<String> features = Arrays.asList(fs.split(","));
                map.get(current).add(new FeatureStructureEntry(features));
            }
        }
        return map;
    }
}