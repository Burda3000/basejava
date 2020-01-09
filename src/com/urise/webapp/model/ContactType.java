package com.urise.webapp.model;

public enum ContactType {
    PHONE("телефон"),
    SKYPE("скайп"),
    EMAIL("почта"),
    PROFILE_LINKEDIN("профиль LinkedIn"),
    PROFILE_GITNUB("профиль GitHub"),
    PROFILE_STACKOVERFLOW("профиль Stackoverflow"),
    HOME_PAGE("домашняя страница");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}