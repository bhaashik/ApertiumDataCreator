package bhaashik.morph.algorithm;

/**
 * Stem extraction using Longest Common Subsequence (LCS) algorithm.
 * This handles cases where there might be infixation or more complex morphology.
 *
 * Note: This finds the longest common subsequence (not necessarily contiguous),
 * which may be useful for languages with non-concatenative morphology.
 */
public class LongestCommonSubsequenceStrategy implements StemExtractionStrategy {

    @Override
    public StemAffixResult extract(String lemma, String inflectedForm) {
        if (lemma == null || inflectedForm == null) {
            return new StemAffixResult(lemma, inflectedForm, "", "", "", "", "");
        }

        if (lemma.isEmpty() || inflectedForm.isEmpty()) {
            return new StemAffixResult(lemma, inflectedForm, "", "", lemma, "", inflectedForm);
        }

        // Find LCS
        String lcs = findLCS(lemma, inflectedForm);

        // For simplicity, use LCS as stem and extract affixes
        // This is a simplified version - can be enhanced
        int lcsStartInLemma = lemma.indexOf(lcs);
        int lcsStartInInflected = inflectedForm.indexOf(lcs);

        String lemmaPrefix = lcsStartInLemma >= 0 ? lemma.substring(0, lcsStartInLemma) : "";
        String lemmaSuffix = lcsStartInLemma >= 0 ? lemma.substring(lcsStartInLemma + lcs.length()) : "";
        String inflectedPrefix = lcsStartInInflected >= 0 ? inflectedForm.substring(0, lcsStartInInflected) : "";
        String inflectedSuffix = lcsStartInInflected >= 0 ? inflectedForm.substring(lcsStartInInflected + lcs.length()) : "";

        return new StemAffixResult(
            lemma, inflectedForm, lcs,
            lemmaPrefix, lemmaSuffix,
            inflectedPrefix, inflectedSuffix
        );
    }

    /**
     * Finds the longest common subsequence between two strings.
     * Uses dynamic programming.
     */
    private String findLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Build the LCS length table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the LCS
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }

    @Override
    public String getStrategyName() {
        return "Longest Common Subsequence (LCS)";
    }
}
