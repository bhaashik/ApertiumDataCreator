package bhaashik.morph.model;

/**
 * Represents a single entry from the lexicon file.
 *
 * After creation, the stem and lemmaSuffix fields are computed based on
 * the paradigm's word forms to enable Apertium-style pardef naming.
 */
public class LexiconEntry {
    private final String lemma;
    private final String specificParadigm;
    private final String paradigmCategory;

    // Computed fields for stem/suffix separation (set after creation)
    private String stem;              // Extracted stem (unchanging part)
    private String lemmaSuffix;       // Lemma suffix (lemma - stem)

    public LexiconEntry(String lemma, String specificParadigm, String paradigmCategory) {
        this.lemma = lemma;
        this.specificParadigm = specificParadigm;
        this.paradigmCategory = paradigmCategory;
        // stem and lemmaSuffix will be computed later
        this.stem = null;
        this.lemmaSuffix = null;
    }

    public String getLemma() {
        return lemma;
    }

    public String getSpecificParadigm() {
        return specificParadigm;
    }

    public String getParadigmCategory() {
        return paradigmCategory;
    }

    /**
     * Gets the extracted stem (unchanging part of the lemma).
     * This is computed based on the paradigm's word forms.
     *
     * @return the stem, or null if not yet computed
     */
    public String getStem() {
        return stem;
    }

    /**
     * Sets the extracted stem.
     *
     * @param stem the stem to set
     */
    public void setStem(String stem) {
        this.stem = stem;
    }

    /**
     * Gets the lemma suffix (variable part = lemma - stem).
     * This is computed as: lemmaSuffix = lemma.substring(stem.length())
     *
     * @return the lemma suffix, or null if not yet computed
     */
    public String getLemmaSuffix() {
        return lemmaSuffix;
    }

    /**
     * Sets the lemma suffix.
     *
     * @param lemmaSuffix the lemma suffix to set
     */
    public void setLemmaSuffix(String lemmaSuffix) {
        this.lemmaSuffix = lemmaSuffix;
    }

    /**
     * Computes and sets both stem and lemmaSuffix from a given stem.
     * The lemmaSuffix is automatically calculated as lemma - stem.
     *
     * @param stem the stem to set
     */
    public void setStemAndComputeSuffix(String stem) {
        this.stem = stem;
        if (stem != null && lemma != null) {
            if (lemma.startsWith(stem)) {
                this.lemmaSuffix = lemma.substring(stem.length());
            } else {
                // Fallback: treat entire lemma as suffix
                this.lemmaSuffix = lemma;
            }
        }
    }

    /**
     * Generates the Apertium-style pardef name for this entry.
     * Format: stem/lemmaSuffix__paradigmCategory
     *
     * @return the pardef name, or null if stem/suffix not yet computed
     */
    public String getPardefName() {
        if (stem == null || lemmaSuffix == null || paradigmCategory == null) {
            return null;
        }
        return stem + "/" + lemmaSuffix + "__" + paradigmCategory;
    }

    @Override
    public String toString() {
        String base = "Lemma: " + lemma +
                ", SpecificParadigm: " + specificParadigm +
                ", ParadigmCategory: " + paradigmCategory;
        if (stem != null) {
            base += ", Stem: " + stem + ", LemmaSuffix: " + lemmaSuffix;
        }
        return base;
    }
}
