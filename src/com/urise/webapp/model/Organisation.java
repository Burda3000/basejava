package com.urise.webapp.model;

import com.urise.webapp.utill.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.urise.webapp.utill.DateUtill.of;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organisation implements Serializable {
    private static final long serialVersionUID = 1L;
    private Link homePage;
    private List<Position> position = new ArrayList<>();

    public Organisation() {
    }

    public Organisation(String name, String url, Position... position) {
        this(new Link(name, url), Arrays.asList((position)));
    }

    public Organisation(Link homePage, List<Position> position) {
        this.homePage = homePage;
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
        return "Organisation(" + homePage + ", " + position + ")";
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position implements Serializable {
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate startDate;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate finishDate;
        private String title;
        private String description;

        public Position() {
        }

        public Position(int startYear, Month startMonth, String title, String description) {
            this(of(startYear, startMonth), LocalDate.now(), title, description);
        }

        public Position(int startYear, Month startMonth, int endYear, Month endMonth, String title, String description) {
            this(of(startYear, startMonth), of(endYear, endMonth), title, description);
        }

        public Position(LocalDate startDate, LocalDate finishDate, String title, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(finishDate, "finishDate must not be null");
            Objects.requireNonNull(title, "nameOfPosition must not be null");
            this.startDate = startDate;
            this.finishDate = finishDate;
            this.title = title;
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return startDate.equals(position.startDate) &&
                    finishDate.equals(position.finishDate) &&
                    title.equals(position.title) &&
                    description.equals(position.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, finishDate, title, description);
        }
    }
}
