package com.urise.webapp.model;

public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private final String title;
    private Object SectionType;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
