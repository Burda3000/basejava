package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int count = 0;
    private int index = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
    }

    public void update(Resume resume) {
        getCheckingResume(resume.getUuid());
        if (index < 0) {
            System.out.println("Error: The resume is not updated. The 'uuids' are not equals");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        for (int j = 0; j < storage.length; j++) {
            if (count > storage.length) {
                System.out.println("Error: The storage is already full");
                break;
            }

            getCheckingResume(resume.getUuid());
            if (index < 0) {
                System.out.println("Error: The resume is already into the storage ");
            } else {
                storage[index] = resume;
                count++;
                index++;
                break;
            }
        }
    }

    public Resume get(String uuid) {
        getCheckingResume(uuid);
        if (index > 0) {
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        getCheckingResume(uuid);
        if (index > 0) {
            for (int k = count; k < count - 1; k++)
                storage[k] = storage[k + 1];
            count--;
            index--;
        } else {
            System.out.println("Error: The resume doesn't exist");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }

    private int getCheckingResume(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return index;
            }
        }
        return -1;
    }
}
