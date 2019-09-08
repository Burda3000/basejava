package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
    }

    public void update(Resume resume) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(storage[i].getUuid())) {
                storage[i] = resume;
                break;
            } else {
                System.out.println("Error: The resume is already updated");
            }
        }
    }

    public void save(Resume resume) {
        for (int i = 0; i < count; i++) {
            if (count > storage.length) {
                System.out.println("Error: The storage is already full");
                break;
            }
        }
        storage[count] = resume;
        count++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                for (int k = count; k < count - 1; k++)
                    storage[k] = storage[k + 1];
                count--;
                break;
            } else {
                System.out.println("Error: The resume doesn't exist");
            }
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
}
