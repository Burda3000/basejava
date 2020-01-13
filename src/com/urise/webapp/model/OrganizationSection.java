package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section {
    private final List<Organisation> organisations;

    OrganizationSection(List<Organisation> organisations) {
        Objects.requireNonNull(organisations, "organisations must not be null");
        this.organisations = organisations;
    }

    public List<Organisation> getOrganisations() {
        return organisations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return Objects.equals(organisations, that.organisations);
    }

    @Override
    public int hashCode() {
        return organisations != null ? organisations.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OrganizationSection{" +
                "organisations=" + organisations +
                '}';
    }
}
