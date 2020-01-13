package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organisation {
    private final LocalDate startDate;
    private final LocalDate finishDate;
    private final String nameOfOrganisation;
    private final String link;
    private final String nameOfPosition;
    private final String description;

    public Organisation(LocalDate startDate, LocalDate finishDate,
                        String nameOfOrganisation, String link, String nameOfPosition, String description) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(finishDate, "finishDate must not be null");
        Objects.requireNonNull(nameOfOrganisation, "nameOfOrganisation must not be null");
        Objects.requireNonNull(nameOfPosition, "nameOfPosition must not be null");
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.nameOfOrganisation = nameOfOrganisation;
        this.link = link;
        this.nameOfPosition = nameOfPosition;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organisation that = (Organisation) o;

        if (!Objects.equals(startDate, that.startDate)) return false;
        if (!Objects.equals(finishDate, that.finishDate)) return false;
        if (!Objects.equals(nameOfOrganisation, that.nameOfOrganisation))
            return false;
        if (!Objects.equals(link, that.link)) return false;
        if (!Objects.equals(nameOfPosition, that.nameOfPosition))
            return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, finishDate, nameOfOrganisation, link, nameOfPosition, description);
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", nameOfOrganisation='" + nameOfOrganisation + '\'' +
                ", link='" + link + '\'' +
                ", nameOfPosition='" + nameOfPosition + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
