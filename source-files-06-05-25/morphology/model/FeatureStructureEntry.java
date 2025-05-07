package morphology.model;
import java.util.List;
public class FeatureStructureEntry {
    private final List<String> features;
    public FeatureStructureEntry(List<String> features) { this.features = features; }
    public List<String> getFeatures() { return features; }
}