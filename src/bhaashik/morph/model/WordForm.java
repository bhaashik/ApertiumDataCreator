package bhaashik.morph.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents a word form of a lemma in a specific paradigm.
 * Supports multiple variants (dialectal variations) for the same morphological slot.
 */
public class WordForm {
    private final String form;
    private final List<String> variants;

    /**
     * Creates a WordForm with a single form (no variants).
     */
    public WordForm(String form) {
        this.form = form;
        this.variants = new ArrayList<>();
        this.variants.add(form);
    }

    /**
     * Creates a WordForm with multiple variants.
     * The first variant is considered the primary form.
     */
    public WordForm(List<String> variants) {
        if (variants == null || variants.isEmpty()) {
            throw new IllegalArgumentException("WordForm must have at least one variant");
        }
        this.variants = new ArrayList<>(variants);
        this.form = variants.get(0); // Primary form is the first variant
    }

    /**
     * Creates a WordForm by parsing a string that may contain variants separated by '/'.
     * Example: "amIrai/amIre/amIrE" -> WordForm with 3 variants
     */
    public static WordForm parseWithVariants(String formString) {
        if (formString == null || formString.isEmpty()) {
            throw new IllegalArgumentException("Form string cannot be null or empty");
        }

        if (formString.contains("/")) {
            String[] parts = formString.split("/");
            List<String> variants = Arrays.stream(parts)
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();
            return new WordForm(variants);
        } else {
            return new WordForm(formString);
        }
    }

    /**
     * Returns the primary form (first variant).
     */
    public String getForm() {
        return form;
    }

    /**
     * Returns all variants for this word form.
     * For non-variant forms, returns a list with a single element.
     */
    public List<String> getVariants() {
        return new ArrayList<>(variants);
    }

    /**
     * Returns true if this word form has multiple variants.
     */
    public boolean hasVariants() {
        return variants.size() > 1;
    }

    /**
     * Returns the number of variants.
     */
    public int getVariantCount() {
        return variants.size();
    }

    @Override
    public String toString() {
        return form;
    }
}
