package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Organisation {
    private final Link link;
    private List<Positions> positions = new ArrayList<>();

    public Organisation(String name, String link, List<Positions> positions) {
        this.link = new Link(name, link);
        this.positions = positions;
    }

    public Organisation(String name, String link, Positions positions) {
        this.link = new Link(name, link);
        this.positions = Collections.singletonList(positions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organisation that = (Organisation) o;

        if (!link.equals(that.link)) return false;
        return positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, positions);
    }

    @Override
    public String toString() {
        return "Organisation{" + link + '}';
    }

    public static class Positions {
        private final LocalDate startDate;
        private final LocalDate finishDate;
        private final String title;
        private final String description;

        public Positions(LocalDate startDate, LocalDate finishDate, String title, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(finishDate, "finishDate must not be null");
            Objects.requireNonNull(title, "nameOfPosition must not be null");
            Objects.requireNonNull(description, "description must not be null");
            this.startDate = startDate;
            this.finishDate = finishDate;
            this.title = title;
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Positions positions = (Positions) o;

            if (!startDate.equals(positions.startDate)) return false;
            if (!finishDate.equals(positions.finishDate)) return false;
            if (!title.equals(positions.title)) return false;
            return description.equals(positions.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, finishDate, title, description);
        }
    }
}
