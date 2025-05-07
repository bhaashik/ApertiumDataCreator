package bhaashik.morph.model;

import java.util.HashMap;
import java.util.Map;

public class FeatureStructure {
//    private final String lemmaPlaceholder;
    private final Lemma lemma;
    private final String category;
    private final String gender;
    private final String number;
    private final String person;
    private final String grammaticalCase;
    private final String vibhakti;
    private final String tam;

    // Optional named features
    private final Map<String, String> additionalFeatures;
    private final Map<String, String> allFeatures;

    public FeatureStructure(Lemma lemma, String category, String gender, String number,
                            String person, String grammaticalCase, String vibhakti, String tam,
                            Map<String, String> additionalFeatures) {
        this.additionalFeatures = additionalFeatures != null ? additionalFeatures : new HashMap<>();
        this.allFeatures = new HashMap<>();
        this.lemma = lemma;
        allFeatures.put("lemma", lemma.getLemmaString());
        this.category = category;
        allFeatures.put("category", category);
        this.gender = gender;
        allFeatures.put("gender", gender);
        this.number = number;
        allFeatures.put("number", number);
        this.person = person;
        allFeatures.put("person", person);
        this.grammaticalCase = grammaticalCase;
        allFeatures.put("grammaticalCase", grammaticalCase);
        this.vibhakti = vibhakti;
        allFeatures.put("grammaticalCase", grammaticalCase);
        this.tam = tam;
        allFeatures.put("tam", tam);

        allFeatures.putAll(additionalFeatures);
    }

    public Lemma getLemma() { return lemma; }
    public String getCategory() { return category; }
    public String getGender() { return gender; }
    public String getNumber() { return number; }
    public String getPerson() { return person; }
    public String getGrammaticalCase() { return grammaticalCase; }
    public String getVibhakti() { return vibhakti; }
    public String getTam() { return tam; }

    public Map<String, String> getAdditionalFeatures() { return additionalFeatures; }

    public Map<String, String> getAllFeatures() { return allFeatures; }

    public String getFeatureValue(String featureName) { return allFeatures.get(featureName); }

    @Override
    public String toString() {
//        return "FeatureStructure{" +
//                "af='" + String.join(",", lemmaPlaceholder, category, gender, number, person, grammaticalCase, vibhakti, tam) +
//                "', additionalFeatures=" + additionalFeatures + '}';
        return allFeatures.toString();
    }
}
