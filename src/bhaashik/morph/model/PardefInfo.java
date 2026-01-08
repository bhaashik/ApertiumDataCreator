package bhaashik.morph.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a unique paradigm definition (pardef) based on stem/suffix separation.
 *
 * In Apertium's standard format, each pardef is identified by a unique combination of:
 * - stem: the unchanging root of the lemma
 * - lemmaSuffix: the part of the lemma that varies in inflection
 * - categoryName: the paradigm category (e.g., Noun_m, Verb_Transitive)
 *
 * Example: For lemma "वधू" (vadhū):
 * - stem = "वध" (vadh)
 * - lemmaSuffix = "ू" (ū)
 * - categoryName = "Noun_f"
 * - pardefName = "वध/ू__Noun_f"
 *
 * The pardef then contains inflected forms where:
 * - <l> contains the inflected suffix (e.g., "ू", "ुएँ", "ुओं")
 * - <r> contains the lemma suffix + morphological tags
 *
 * @author Anil Kumar Singh
 */
public class PardefInfo {
    private String stem;                    // Unchanging root, e.g., "वध"
    private String lemmaSuffix;             // Variable part of lemma, e.g., "ू"
    private String categoryName;            // Paradigm category name, e.g., "Noun_f"
    private ParadigmCategory paradigm;      // Reference to the paradigm category
    private List<LexiconEntry> entries;     // All lexicon entries using this pardef

    /**
     * Creates a new PardefInfo instance.
     */
    public PardefInfo() {
        this.entries = new ArrayList<>();
    }

    /**
     * Creates a new PardefInfo instance with specified stem, suffix, and category.
     *
     * @param stem the stem part of the lemma
     * @param lemmaSuffix the suffix part of the lemma
     * @param categoryName the paradigm category name
     * @param paradigm the paradigm category reference
     */
    public PardefInfo(String stem, String lemmaSuffix, String categoryName, ParadigmCategory paradigm) {
        this.stem = stem;
        this.lemmaSuffix = lemmaSuffix;
        this.categoryName = categoryName;
        this.paradigm = paradigm;
        this.entries = new ArrayList<>();
    }

    /**
     * Generates the Apertium-standard pardef name in format: stem/lemmaSuffix__categoryName
     *
     * Examples:
     * - "वध/ू__Noun_f"
     * - "घ/र__Noun_m"
     * - "/ई__Noun_f" (empty stem)
     * - "घर/__Noun_m" (empty suffix)
     *
     * @return the pardef name
     */
    public String getPardefName() {
        return stem + "/" + lemmaSuffix + "__" + categoryName;
    }

    /**
     * Adds a lexicon entry to this pardef.
     *
     * @param entry the lexicon entry to add
     */
    public void addEntry(LexiconEntry entry) {
        this.entries.add(entry);
    }

    // Getters and setters

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getLemmaSuffix() {
        return lemmaSuffix;
    }

    public void setLemmaSuffix(String lemmaSuffix) {
        this.lemmaSuffix = lemmaSuffix;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ParadigmCategory getParadigm() {
        return paradigm;
    }

    public void setParadigm(ParadigmCategory paradigm) {
        this.paradigm = paradigm;
    }

    public List<LexiconEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<LexiconEntry> entries) {
        this.entries = entries;
    }

    /**
     * Returns the number of lexicon entries using this pardef.
     *
     * @return the entry count
     */
    public int getEntryCount() {
        return entries.size();
    }

    @Override
    public String toString() {
        return "PardefInfo{" +
                "pardefName='" + getPardefName() + '\'' +
                ", stem='" + stem + '\'' +
                ", lemmaSuffix='" + lemmaSuffix + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", entryCount=" + entries.size() +
                '}';
    }
}
