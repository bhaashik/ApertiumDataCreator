package bhaashik.morph.algorithm;

/**
 * Strategy interface for stem and affix extraction algorithms.
 * Implementations can use different approaches (LCP, LCS, etc.)
 */
public interface StemExtractionStrategy {

    /**
     * Extracts stem and affixes from a lemma and its inflected form.
     *
     * @param lemma The base lemma
     * @param inflectedForm The inflected surface form
     * @return A StemAffixResult containing the extracted components
     */
    StemAffixResult extract(String lemma, String inflectedForm);

    /**
     * Returns the name of this strategy.
     */
    String getStrategyName();

    /**
     * Result class containing extracted stem and affixes.
     */
    class StemAffixResult {
        private final String lemma;
        private final String inflectedForm;
        private final String stem;
        private final String lemmaPrefix;
        private final String lemmaSuffix;
        private final String inflectedPrefix;
        private final String inflectedSuffix;

        public StemAffixResult(String lemma, String inflectedForm, String stem,
                              String lemmaPrefix, String lemmaSuffix,
                              String inflectedPrefix, String inflectedSuffix) {
            this.lemma = lemma;
            this.inflectedForm = inflectedForm;
            this.stem = stem;
            this.lemmaPrefix = lemmaPrefix;
            this.lemmaSuffix = lemmaSuffix;
            this.inflectedPrefix = inflectedPrefix;
            this.inflectedSuffix = inflectedSuffix;
        }

        public String getLemma() { return lemma; }
        public String getInflectedForm() { return inflectedForm; }
        public String getStem() { return stem; }
        public String getLemmaPrefix() { return lemmaPrefix; }
        public String getLemmaSuffix() { return lemmaSuffix; }
        public String getInflectedPrefix() { return inflectedPrefix; }
        public String getInflectedSuffix() { return inflectedSuffix; }

        @Override
        public String toString() {
            return String.format("Stem: '%s' | Lemma: '%s'+'%s'+'%s' | Inflected: '%s'+'%s'+'%s'",
                stem, lemmaPrefix, stem, lemmaSuffix, inflectedPrefix, stem, inflectedSuffix);
        }
    }
}
