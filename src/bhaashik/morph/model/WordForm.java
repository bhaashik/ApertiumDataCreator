package bhaashik.morph.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a word form of a lemma in a specific paradigm.
 */
public class WordForm {
    private final String form;

    public WordForm(String form) {
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    @Override
    public String toString() {
        return form;
    }
}
