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

    Organisation(LocalDate startDate, LocalDate finishDate,
                 String nameOfOrganisation, String link, String nameOfPosition, String description) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(finishDate, "finishDate must not be null");
        Objects.requireNonNull(nameOfOrganisation, "nameOfOrganisation must not be null");
        Objects.requireNonNull(nameOfPosition, "nameOfPosition must not be null");
        Objects.requireNonNull(description, "description must not be null");
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
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        result = 31 * result + (nameOfOrganisation != null ? nameOfOrganisation.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (nameOfPosition != null ? nameOfPosition.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
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
