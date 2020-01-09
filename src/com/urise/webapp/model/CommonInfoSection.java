package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class CommonInfoSection extends Section {
    private final List<Section> sections;

    public CommonInfoSection(List<Section> sections) {
        Objects.requireNonNull(sections, "sections must not be null");
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommonInfoSection that = (CommonInfoSection) o;

        return sections.equals(that.sections);
    }

    @Override
    public int hashCode() {
        return sections.hashCode();
    }

    @Override
    public String toString() {
        return "CommonInfoSection{" +
                "sections=" + sections +
                '}';
    }
}
