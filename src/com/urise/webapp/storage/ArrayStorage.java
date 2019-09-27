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
        if (index < 0) {
            System.out.println("Error: The resume is not updated. The 'uuids' are not equals");
        } else {
            storage[count] = resume;
        }
    }

    public void save(Resume resume) {
        for (int j = 0; j < count; j++) {
            if (count > storage.length) {
                System.out.println("Error: The storage is already full");
                break;
            }
        }

        //            index = getIndex(resume.getUuid());
        if (index < getIndex(resume.getUuid())) {
            System.out.println("Error: The resume is already into the storage ");
        } else {
            storage[count] = resume;
            count++;
//            index++;
        }
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) > 0) {
            return storage[count];
        }
        return null;
    }

    public void delete(String uuid) {
        if (getIndex(uuid) < 0) {
            if (count - 1 - count >= 0) System.arraycopy(storage, count + 1, storage, count, count - 1 - count);
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

    private int getIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}