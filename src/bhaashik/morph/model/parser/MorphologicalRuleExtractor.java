package bhaashik.morph.model.parser;

import java.util.Optional;

public class MorphologicalRuleExtractor {

    /**
     * Given a lemma and an inflected form, extract the lemma-to-form transformation.
     * If lemma is "घर" and surface is "घरों", this returns "ों" as the suffix.
     */
    public static MorphTransform extractTransform(String lemma, String surfaceForm) {
        if (lemma == null || surfaceForm == null || lemma.isEmpty() || surfaceForm.isEmpty()) {
            return new MorphTransform(lemma, surfaceForm, "", "", "");
        }

        int prefixLen = longestCommonPrefixLength(lemma, surfaceForm);
        int suffixLen = longestCommonSuffixLength(lemma, surfaceForm);

        String stem = lemma.substring(0, prefixLen);
        String lemmaSuffix = lemma.substring(prefixLen);
        String formSuffix = surfaceForm.substring(prefixLen);

        return new MorphTransform(lemma, surfaceForm, stem, lemmaSuffix, formSuffix);
    }

    private static int longestCommonPrefixLength(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int i = 0;
        while (i < len && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return i;
    }

    private static int longestCommonSuffixLength(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int count = 0;
        while (i >= 0 && j >= 0 && a.charAt(i) == b.charAt(j)) {
            i--; j--; count++;
        }
        return count;
    }

    public static class MorphTransform {
        private final String lemma;
        private final String surfaceForm;
        private final String commonStem;
        private final String lemmaSuffix;
        private final String surfaceSuffix;

        public MorphTransform(String lemma, String surfaceForm,
                              String commonStem, String lemmaSuffix, String surfaceSuffix) {
            this.lemma = lemma;
            this.surfaceForm = surfaceForm;
            this.commonStem = commonStem;
            this.lemmaSuffix = lemmaSuffix;
            this.surfaceSuffix = surfaceSuffix;
        }

        public String getLemma() {
            return lemma;
        }

        public String getSurfaceForm() {
            return surfaceForm;
        }

        public String getCommonStem() {
            return commonStem;
        }

        public String getLemmaSuffix() {
            return lemmaSuffix;
        }

        public String getSurfaceSuffix() {
            return surfaceSuffix;
        }

        @Override
        public String toString() {
            return "MorphTransform{" +
                    "lemma='" + lemma + '\'' +
                    ", surfaceForm='" + surfaceForm + '\'' +
                    ", stem='" + commonStem + '\'' +
                    ", lemmaSuffix='" + lemmaSuffix + '\'' +
                    ", surfaceSuffix='" + surfaceSuffix + '\'' +
                    '}';
        }

        /**
         * Generate Apertium-style <p><l>...</l><r>...</r></p> for .dix file.
         */
        public String toDixEntry() {
            return "<p><l>" + lemma + "</l><r>" + surfaceSuffix + "</r></p>";
        }
    }
}
