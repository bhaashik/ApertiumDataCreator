package bhaashik.morph.model;

import java.util.HashMap;
import java.util.Map;

public class FeatureStructure {
    private final String lemmaPlaceholder;
    private final String category;
    private final String gender;
    private final String number;
    private final String person;
    private final String grammaticalCase;
    private final String vibhakti;
    private final String tam;

    // Optional named features
    private final Map<String, String> additionalFeatures;

    public FeatureStructure(String lemmaPlaceholder, String category, String gender, String number,
                            String person, String grammaticalCase, String vibhakti, String tam,
                            Map<String, String> additionalFeatures) {
        this.lemmaPlaceholder = lemmaPlaceholder;
        this.category = category;
        this.gender = gender;
        this.number = number;
        this.person = person;
        this.grammaticalCase = grammaticalCase;
        this.vibhakti = vibhakti;
        this.tam = tam;
        this.additionalFeatures = additionalFeatures != null ? additionalFeatures : new HashMap<>();
    }

    public String getLemmaPlaceholder() { return lemmaPlaceholder; }
    public String getCategory() { return category; }
    public String getGender() { return gender; }
    public String getNumber() { return number; }
    public String getPerson() { return person; }
    public String getGrammaticalCase() { return grammaticalCase; }
    public String getVibhakti() { return vibhakti; }
    public String getTam() { return tam; }
    public Map<String, String> getAdditionalFeatures() { return additionalFeatures; }

    @Override
    public String toString() {
        return "FeatureStructure{" +
                "af='" + String.join(",", lemmaPlaceholder, category, gender, number, person, grammaticalCase, vibhakti, tam) +
                "', additionalFeatures=" + additionalFeatures + '}';
    }
}
