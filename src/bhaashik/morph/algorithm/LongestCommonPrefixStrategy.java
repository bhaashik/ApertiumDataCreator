package bhaashik.morph.algorithm;

/**
 * Stem extraction using Longest Common Prefix (LCP) algorithm.
 * This is the most common approach for suffixing languages like Hindi, Bhojpuri, etc.
 *
 * Example:
 *   lemma="घर" (ghar), inflected="घरों" (gharoN)
 *   => stem="घर", lemmaSuffix="", inflectedSuffix="ों"
 */
public class LongestCommonPrefixStrategy implements StemExtractionStrategy {

    @Override
    public StemAffixResult extract(String lemma, String inflectedForm) {
        if (lemma == null || inflectedForm == null) {
            return new StemAffixResult(lemma, inflectedForm, "", "", "", "", "");
        }

        if (lemma.isEmpty() || inflectedForm.isEmpty()) {
            return new StemAffixResult(lemma, inflectedForm, "", "", lemma, "", inflectedForm);
        }

        // Find longest common prefix
        int prefixLen = findLongestCommonPrefix(lemma, inflectedForm);

        String stem = lemma.substring(0, prefixLen);
        String lemmaSuffix = lemma.substring(prefixLen);
        String inflectedSuffix = inflectedForm.substring(prefixLen);

        return new StemAffixResult(
            lemma, inflectedForm, stem,
            "", lemmaSuffix,  // No prefix for LCP
            "", inflectedSuffix
        );
    }

    private int findLongestCommonPrefix(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        int i = 0;

        while (i < minLen && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }

        return i;
    }

    @Override
    public String getStrategyName() {
        return "Longest Common Prefix (LCP)";
    }
}
