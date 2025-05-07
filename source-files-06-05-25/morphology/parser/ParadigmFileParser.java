package morphology.parser;
import java.io.*; import java.util.*;
import morphology.model.*;

public class ParadigmFileParser {
    public ParadigmCategory parse(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String categoryName = br.readLine().trim();
        ParadigmCategory category = new ParadigmCategory(categoryName);
        List<String> lines = br.lines().filter(line -> !line.trim().isEmpty()).toList();

        int index = 0;
        while (index < lines.size()) {
            String lemma = lines.get(index++).trim();
            List<String> forms = new ArrayList<>();
            for (int i = 0; i < 4 && index < lines.size(); i++) {
                forms.add(lines.get(index++).trim());
            }
            category.addParadigm(new Paradigm(lemma, forms));
        }
        return category;
    }
}