package com.urise.webapp.storage.serializationStorage;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.urise.webapp.model.SectionType.getSectionType;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());

            Map<ContactType, String> contacts = r.getContact();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            // TODO implements sections
            for (Map.Entry<SectionType, Section> entry : r.getSection().entrySet()) {
                SectionType type = entry.getKey();
                switch (type) {
                    case PERSONAL:
                    case OBJECTIVE:
                        writeTextSection(dos, r, type);
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeListSection(dos, r, type);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        writeOrganization(dos, r, type);
                        break;
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }
            // TODO implements sections
            for (Map.Entry<SectionType, Section> entry : resume.getSection().entrySet()) {
                SectionType type = entry.getKey();
                switch (type) {
                    case PERSONAL:
                    case OBJECTIVE:
                        readTextSection(dis, resume);
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        readListSection(dis, resume);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        readOrganization(dis, resume);
                        break;
                }
            }
            return resume;
        }
    }

    private void writeTextSection(DataOutputStream dos, Resume r, SectionType sectionType) throws IOException {
        TextSection textSection = (TextSection) r.getSection(sectionType);
        dos.writeUTF(sectionType.name());
        dos.writeUTF(textSection.getContent());
    }

    private void writeListSection(DataOutputStream dos, Resume r, SectionType sectionType) throws IOException {
        ListSection listSection = (ListSection) r.getSection(sectionType);
        dos.writeUTF(sectionType.name());
        List<String> items = listSection.getItems();
        dos.writeInt(items.size());

        for (String item : items) {
            dos.writeUTF(item);
        }
    }

    private void writeOrganization(DataOutputStream dos, Resume r, SectionType sectionType) throws IOException {
        OrganizationSection organizationSection = (OrganizationSection) r.getSection(sectionType);
        dos.writeUTF(sectionType.name());
        List<Organisation> organisations = organizationSection.getOrganisations();
        dos.writeInt(organisations.size());

        for (Organisation organisation : organisations) {
            dos.writeUTF(organisation.getHomePage().toString());
            List<Organisation.Position> positionList = organisation.getPosition();
            dos.writeInt(positionList.size());
            for (Organisation.Position position : positionList) {
                dos.writeUTF(position.getStartDate().toString());
                dos.writeUTF(position.getFinishDate().toString());
                dos.writeUTF(position.getTitle());
                dos.writeUTF(position.getDescription());
            }
        }
    }

    private void readTextSection(DataInputStream dis, Resume resume) throws IOException {
        String key = dis.readUTF();
        String value = dis.readUTF();
        resume.addSection(getSectionType(key), new TextSection(value));
    }

    private void readListSection(DataInputStream dis, Resume resume) throws IOException {
        String key = dis.readUTF();
        int size = dis.readInt();
        List<String> items = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            items.add(dis.readUTF());
        }
        if (items.size() != 0) {
            resume.addSection(getSectionType(key), new ListSection(items));
        }
    }

    private void readOrganization(DataInputStream dis, Resume resume) throws IOException {
        String key = dis.readUTF();
        List<Organisation> organisationList = new ArrayList<>();
        int organisationSize = dis.readInt();

        for (int i = 0; i < organisationSize; i++) {
            Organisation organisation = new Organisation(new Link(dis.readUTF()), new ArrayList<>());
            int perodSize = dis.readInt();
            for (int j = 0; j < perodSize; j++) {
                organisation.addPosition1(new Organisation.Position(
                        LocalDate.parse(dis.readUTF()),
                        LocalDate.parse(dis.readUTF()),
                        dis.readUTF(),
                        dis.readUTF()));
            }
            organisationList.add(organisation);
        }
        resume.addSection(getSectionType(key), new OrganizationSection(organisationList));
    }
}
