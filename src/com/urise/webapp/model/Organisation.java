package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Organisation {
    private final Link homePage;
    private List<Position> position = new ArrayList<>();

    public Organisation(String name, String url, Position position) {
        this(new Link(name, url), Collections.singletonList((position)));
    }

    public Organisation(Link link, List<Position> position) {
        this.homePage = link;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organisation that = (Organisation) o;

        if (!homePage.equals(that.homePage)) return false;
        return position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, position);
    }

    @Override
    public String toString() {
        return "Organisation{" + homePage + '}';
    }

    public static class Position {
        private final LocalDate startDate;
        private final LocalDate finishDate;
        private final String title;
        private final String description;

        public Position(LocalDate startDate, LocalDate finishDate, String title, String description) {
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

            Position positions = (Position) o;

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
