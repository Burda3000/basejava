package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (count > storage.length) {
            System.out.println("Error: The storage is already full");
        } else if (index < 0) {
            storage[count] = resume;
            count++;
        } else {
            System.out.println("Error: The " + resume.getUuid() + " is already into the storage ");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Error: The " + uuid + " doesn't exist");
        } else {
            System.arraycopy(storage, count - 1, storage, count, count - 1);
            count--;
        }
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}