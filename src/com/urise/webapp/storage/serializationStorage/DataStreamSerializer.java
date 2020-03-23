package com.urise.webapp.storage.serializationStorage;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.Section;
import com.urise.webapp.model.SectionType;

import java.io.*;
import java.util.Map;

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
            Map<SectionType, Section> sections = r.getSection();
            dos.writeUTF(String.valueOf(sections.get(SectionType.PERSONAL)));
            dos.writeUTF(String.valueOf(sections.get(SectionType.OBJECTIVE)));
            dos.writeUTF(String.valueOf(sections.get(SectionType.ACHIEVEMENT)));
            dos.writeUTF(String.valueOf(sections.get(SectionType.QUALIFICATIONS)));
            dos.writeUTF(String.valueOf(sections.get(SectionType.EXPERIENCE)));
            dos.writeUTF(String.valueOf(sections.get(SectionType.EDUCATION)));
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
            SectionType sectionType = SectionType.valueOf(dis.readUTF());
            resume.addSection(sectionType, resume.getSection(SectionType.PERSONAL));
            return resume;
        }
    }
}
