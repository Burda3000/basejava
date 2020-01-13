package com.urise.webapp.model;

import java.util.Objects;

public class TextSection extends Section {
    private final String sections;

    public TextSection(String sections) {
        Objects.requireNonNull(sections, "sections must not be null");
        this.sections = sections;
    }

    public String getSections() {
        return sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return sections.equals(that.sections);
    }

    @Override
    public int hashCode() {
        return sections.hashCode();
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "sections=" + sections +
                '}';
    }
}
