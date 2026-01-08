package bhaashik.morph.util;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for grapheme-aware string operations on Indic scripts.
 *
 * This is critical for Devanagari and other Indic scripts where:
 * - Vowel marks (maatraas) are combining characters
 * - String.length() counts UTF-16 code units, not user-perceived characters
 * - Example: "की" is 2 code units (क + ी) but 1 grapheme cluster
 *
 * @author Anil Kumar Singh
 */
public class GraphemeUtils {

    /**
     * Counts the number of grapheme clusters in a string.
     * This is the correct "length" for Indic scripts.
     *
     * Example:
     * - "की" has 2 code units but 1 grapheme cluster
     * - "वधू" has 3 code units but 2 grapheme clusters (व + धू)
     *
     * @param text the input string
     * @return number of grapheme clusters
     */
    public static int graphemeLength(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        BreakIterator iterator = BreakIterator.getCharacterInstance();
        iterator.setText(text);

        int count = 0;
        while (iterator.next() != BreakIterator.DONE) {
            count++;
        }

        return count;
    }

    /**
     * Extracts a substring based on grapheme cluster positions.
     *
     * @param text the input string
     * @param startGrapheme starting grapheme position (0-based)
     * @param endGrapheme ending grapheme position (exclusive)
     * @return substring from startGrapheme to endGrapheme (in grapheme positions)
     */
    public static String graphemeSubstring(String text, int startGrapheme, int endGrapheme) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        BreakIterator iterator = BreakIterator.getCharacterInstance();
        iterator.setText(text);

        int currentGrapheme = 0;
        int startIndex = 0;
        int endIndex = text.length();

        int boundary = iterator.first();
        while (boundary != BreakIterator.DONE) {
            if (currentGrapheme == startGrapheme) {
                startIndex = boundary;
            }
            if (currentGrapheme == endGrapheme) {
                endIndex = boundary;
                break;
            }
            currentGrapheme++;
            boundary = iterator.next();
        }

        return text.substring(startIndex, endIndex);
    }

    /**
     * Extracts a substring from a starting grapheme position to the end.
     *
     * @param text the input string
     * @param startGrapheme starting grapheme position (0-based)
     * @return substring from startGrapheme to end
     */
    public static String graphemeSubstring(String text, int startGrapheme) {
        return graphemeSubstring(text, startGrapheme, graphemeLength(text));
    }

    /**
     * Finds the longest common prefix of two strings in grapheme clusters.
     *
     * @param s1 first string
     * @param s2 second string
     * @return number of common grapheme clusters at the start
     */
    public static int findLongestCommonPrefixGraphemes(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }

        BreakIterator iter1 = BreakIterator.getCharacterInstance();
        iter1.setText(s1);
        BreakIterator iter2 = BreakIterator.getCharacterInstance();
        iter2.setText(s2);

        int commonGraphemes = 0;
        int boundary1 = iter1.first();
        int boundary2 = iter2.first();
        int prevBoundary1 = 0;
        int prevBoundary2 = 0;

        while (true) {
            boundary1 = iter1.next();
            boundary2 = iter2.next();

            if (boundary1 == BreakIterator.DONE || boundary2 == BreakIterator.DONE) {
                break;
            }

            String grapheme1 = s1.substring(prevBoundary1, boundary1);
            String grapheme2 = s2.substring(prevBoundary2, boundary2);

            if (!grapheme1.equals(grapheme2)) {
                break;
            }

            commonGraphemes++;
            prevBoundary1 = boundary1;
            prevBoundary2 = boundary2;
        }

        return commonGraphemes;
    }

    /**
     * Splits a string into grapheme clusters.
     * Useful for debugging and analysis.
     *
     * @param text the input string
     * @return list of grapheme clusters
     */
    public static List<String> splitIntoGraphemes(String text) {
        List<String> graphemes = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            return graphemes;
        }

        BreakIterator iterator = BreakIterator.getCharacterInstance();
        iterator.setText(text);

        int start = iterator.first();
        int end = iterator.next();

        while (end != BreakIterator.DONE) {
            graphemes.add(text.substring(start, end));
            start = end;
            end = iterator.next();
        }

        return graphemes;
    }

    /**
     * Extracts the grapheme-based suffix by removing a specified number of
     * grapheme clusters from the end.
     *
     * @param text the input string
     * @param suffixGraphemeLength number of grapheme clusters to keep as suffix
     * @return the suffix
     */
    public static String extractSuffixByGraphemeLength(String text, int suffixGraphemeLength) {
        int totalLength = graphemeLength(text);
        if (suffixGraphemeLength >= totalLength) {
            return text;
        }
        int stemLength = totalLength - suffixGraphemeLength;
        return graphemeSubstring(text, stemLength);
    }

    /**
     * Extracts the grapheme-based stem by keeping a specified number of
     * grapheme clusters from the start.
     *
     * @param text the input string
     * @param stemGraphemeLength number of grapheme clusters to keep as stem
     * @return the stem
     */
    public static String extractStemByGraphemeLength(String text, int stemGraphemeLength) {
        int totalLength = graphemeLength(text);
        if (stemGraphemeLength >= totalLength) {
            return text;
        }
        return graphemeSubstring(text, 0, stemGraphemeLength);
    }

    /**
     * Example usage and test cases.
     */
    public static void main(String[] args) {
        // Test cases with Devanagari text
        String[] testCases = {
            "की",      // क + ी (1 grapheme)
            "वधू",     // व + ध + ू (2 graphemes)
            "कहनी",    // क + ह + न + ी (3 graphemes)
            "आदमी",    // आ + द + म + ी (3 graphemes)
            "घर",      // घ + र (2 graphemes)
            "घरों"     // घ + र + ो + ं (3 graphemes)
        };

        System.out.println("=== Grapheme Analysis ===\n");

        for (String text : testCases) {
            System.out.println("Text: " + text);
            System.out.println("  Code units (String.length()): " + text.length());
            System.out.println("  Grapheme clusters: " + graphemeLength(text));
            System.out.println("  Graphemes: " + splitIntoGraphemes(text));
            System.out.println();
        }

        // Test LCP
        System.out.println("=== Longest Common Prefix ===\n");
        String s1 = "घर";
        String s2 = "घरों";
        System.out.println("s1: " + s1 + " (graphemes: " + graphemeLength(s1) + ")");
        System.out.println("s2: " + s2 + " (graphemes: " + graphemeLength(s2) + ")");
        System.out.println("Common graphemes: " + findLongestCommonPrefixGraphemes(s1, s2));
        System.out.println();

        // Test substring
        System.out.println("=== Substring Extraction ===\n");
        String lemma = "कहनी";
        int stemLen = 2; // कहन (2 graphemes)
        String stem = graphemeSubstring(lemma, 0, stemLen);
        String suffix = graphemeSubstring(lemma, stemLen);
        System.out.println("Lemma: " + lemma);
        System.out.println("Stem (first " + stemLen + " graphemes): " + stem);
        System.out.println("Suffix (remaining): " + suffix);
    }
}
