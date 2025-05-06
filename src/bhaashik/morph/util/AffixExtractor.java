package bhaashik.morph.util;

import java.util.*;

public class AffixExtractor {

    public static class AffixResult {
        public final String lemma;
        public final String prefix;
        public final String suffix;
        public final String surfaceForm;

        public AffixResult(String lemma, String prefix, String suffix, String surfaceForm) {
            this.lemma = lemma;
            this.prefix = prefix;
            this.suffix = suffix;
            this.surfaceForm = surfaceForm;
        }

        @Override
        public String toString() {
            return "Lemma: " + lemma + ", Prefix: " + prefix + ", Suffix: " + suffix + ", Surface: " + surfaceForm;
        }
    }

    /**
     * Extracts the longest common prefix and suffix from lemma and surface form.
     * Useful for Apertium-style <l>lemma</l><r>suffix</r> style generation.
     */
    public static AffixResult extractAffix(String lemma, String surfaceForm) {
        if (lemma == null || surfaceForm == null) return null;

        int prefixLen = longestCommonPrefix(lemma, surfaceForm);
        int suffixLen = longestCommonSuffix(lemma, surfaceForm);

        // Prefer prefix stripping by default (suffixing model)
        if (prefixLen >= suffixLen) {
            String common = lemma.substring(0, prefixLen);
            String lemmaStem = common;
            String suffix = surfaceForm.substring(prefixLen);
            return new AffixResult(lemma, "", suffix, surfaceForm);
        } else {
            String common = lemma.substring(lemma.length() - suffixLen);
            String prefix = surfaceForm.substring(0, surfaceForm.length() - suffixLen);
            return new AffixResult(lemma, prefix, common, surfaceForm);
        }
    }

    private static int longestCommonPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) return i;
        }
        return len;
    }

    private static int longestCommonSuffix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 1; i <= len; i++) {
            if (a.charAt(a.length() - i) != b.charAt(b.length() - i)) return i - 1;
        }
        return len;
    }

    public static void main(String[] args) {
        List<String[]> testPairs = List.of(
                new String[]{"ghar", "gharon"},
                new String[]{"ladZikA", "ladZikAeM"},
                new String[]{"kamra", "kamre"},
                new String[]{"kitaab", "kitaaben"}
        );

        for (String[] pair : testPairs) {
            AffixResult result = extractAffix(pair[0], pair[1]);
            System.out.println(result);
        }
    }
}
