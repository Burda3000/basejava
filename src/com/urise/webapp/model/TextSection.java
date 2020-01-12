package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class TextSection extends Section {
    private final List<String> textContent;

    TextSection(List<String> textContent) {
        Objects.requireNonNull(textContent, "textContent must not be null");
        this.textContent = textContent;
    }

    public List<String> getTextContent() {
        return textContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return textContent.equals(that.textContent);
    }

    @Override
    public int hashCode() {
        return textContent.hashCode();
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "textContent=" + textContent +
                '}';
    }
}
