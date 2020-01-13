package com.urise.webapp.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Иван Попов");
        resume.contacts.put(ContactType.PHONE, "PHONE");
        resume.contacts.put(ContactType.SKYPE, "SKYPE");
        resume.contacts.put(ContactType.EMAIL, "EMAIL");
        resume.contacts.put(ContactType.PROFILE_LINKEDIN, "PROFILE_LINKEDIN");
        resume.contacts.put(ContactType.PROFILE_GITNUB, "PROFILE_GITHUB");
        resume.contacts.put(ContactType.PROFILE_STACKOVERFLOW, "PROFILE_STACKOVERFLOW");
        resume.contacts.put(ContactType.HOME_PAGE, "HOME_PAGE");

        resume.sections.put(SectionType.OBJECTIVE, new CommonInfoSection(Collections.singletonList("position")));
        resume.sections.put(SectionType.PERSONAL, new CommonInfoSection(Collections.singletonList("personal info")));
        resume.sections.put(SectionType.ACHIEVEMENT, new TextSection(Collections.singletonList("achievement")));
        resume.sections.put(SectionType.QUALIFICATIONS, new TextSection(Collections.singletonList("qualification")));
        resume.sections.put(SectionType.EXPERIENCE, new OrganizationSection(Collections.singletonList
                (new Organisation(LocalDate.of(2017, Month.FEBRUARY, 3), LocalDate.of(2017, Month.MARCH, 3),
                        "copita", "www.copita.com", "java developer", "web app development"))));
        resume.sections.put(SectionType.EDUCATION, new OrganizationSection(Collections.singletonList
                (new Organisation(LocalDate.of(2000, Month.SEPTEMBER, 1), LocalDate.of(2004, Month.MARCH, 3),
                        "someUnivercity", "www.univer.com", "networking", "communication with people"))));
    }
}
