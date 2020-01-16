package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organisation {
    private final Link link;
    private final List<Positions> Positions = new ArrayList<>();

    public Organisation(String name, String link, List<Positions> Positions) {
        this.link = new Link(name, link);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organisation that = (Organisation) o;

        if (!link.equals(that.link)) return false;
        return Positions.equals(that.Positions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(link);
    }

    @Override
    public String toString() {
        return "Organisation{" + link + "," + '}';
    }

    private class Positions {
        private final LocalDate startDate;
        private final LocalDate finishDate;
        private final String nameOfPosition;
        private final String description;

        public Positions(LocalDate startDate, LocalDate finishDate, String nameOfPosition, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(finishDate, "finishDate must not be null");
            Objects.requireNonNull(nameOfPosition, "nameOfPosition must not be null");
            Objects.requireNonNull(description, "description must not be null");
            this.startDate = startDate;
            this.finishDate = finishDate;
            this.nameOfPosition = nameOfPosition;
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Positions positions = (Positions) o;

            if (!startDate.equals(positions.startDate)) return false;
            if (!finishDate.equals(positions.finishDate)) return false;
            if (!nameOfPosition.equals(positions.nameOfPosition)) return false;
            return description.equals(positions.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, finishDate, nameOfPosition, description);
        }
    }
}


//package com.urise.webapp.model;
//
//        import java.time.LocalDate;
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Objects;
//
//public class Organisation {
//    private List<Position> positions = new ArrayList<>();
//
//    public Organisation(List<Position> positions) {
//        this.positions = positions;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Organisation that = (Organisation) o;
//
//        return positions.equals(that.positions);
//    }
//
//    @Override
//    public int hashCode() {
//        return positions.hashCode();
//    }
//}
//
//class Position {
//    private final String nameOfOrganisation;
//    private final Link link;
//    private final LocalDate startDate;
//    private final LocalDate finishDate;
//    private final String nameOfPosition;
//
//    public Position(String nameOfOrganisation, String name, Link link, LocalDate startDate, LocalDate finishDate, String nameOfPosition, String description) {
//        Objects.requireNonNull(nameOfOrganisation, "nameOfPosition must not be null");
//        Objects.requireNonNull(startDate, "startDate must not be null");
//        Objects.requireNonNull(finishDate, "finishDate must not be null");
//        Objects.requireNonNull(nameOfPosition, "nameOfPosition must not be null");
//        this.nameOfOrganisation = nameOfOrganisation;
//        this.link = new Link(name, link);
//        this.startDate = startDate;
//        this.finishDate = finishDate;
//        this.nameOfPosition = nameOfPosition;
//        this.description = description;
//    }
//
//    public String getNameOfOrganisation() {
//        return nameOfOrganisation;
//    }
//
//    public Link getLink() {
//        return link;
//    }
//
//    public LocalDate getStartDate() {
//        return startDate;
//    }
//
//    public LocalDate getFinishDate() {
//        return finishDate;
//    }
//
//    public String getNameOfPosition() {
//        return nameOfPosition;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    private final String description;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Position position = (Position) o;
//
//        if (!nameOfOrganisation.equals(position.nameOfOrganisation)) return false;
//        if (!link.equals(position.link)) return false;
//        if (!startDate.equals(position.startDate)) return false;
//        if (!finishDate.equals(position.finishDate)) return false;
//        if (!nameOfPosition.equals(position.nameOfPosition)) return false;
//        return description.equals(position.description);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nameOfOrganisation, link, startDate, finishDate, nameOfPosition, description);
//    }
//
//    @Override
//    public String toString() {
//        return "Position{" +
//                "nameOfOrganisation='" + nameOfOrganisation + '\'' +
//                ", link=" + link +
//                ", startDate=" + startDate +
//                ", finishDate=" + finishDate +
//                ", nameOfPosition='" + nameOfPosition + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
//}
