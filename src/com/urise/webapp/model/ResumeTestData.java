package com.urise.webapp.model;

import java.time.Month;

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

        resume.sections.put(SectionType.OBJECTIVE, new CommonInfoSection("position"));
        resume.sections.put(SectionType.PERSONAL, new CommonInfoSection("personal info1"));
        resume.sections.put(SectionType.ACHIEVEMENT, new TextSection("achievment1"));
        resume.sections.put(SectionType.QUALIFICATIONS, new TextSection("qualification"));
        resume.sections.put(SectionType.EXPERIENCE, new OrganizationSection
                (new Organisation(Month.NOVEMBER, Month.NOVEMBER, "copita",
                        "www.copita.com", "java developer",
                            "web app development")));
//        resume.sections.put(SectionType.EDUCATION, new OrganizationSection());

    }
}
