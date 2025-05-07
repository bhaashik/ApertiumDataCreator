package morphology.parser;
import java.io.*; import java.util.*;
import morphology.model.*;

public class LexiconParser {
    public List<LexiconEntry> parse(File file) throws IOException {
        List<LexiconEntry> entries = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.replaceAll(""", "").split(",");
            if (parts.length >= 4) {
                entries.add(new LexiconEntry(parts[0].trim(), parts[2].trim(), parts[3].trim()));
            }
        }
        return entries;
    }
}