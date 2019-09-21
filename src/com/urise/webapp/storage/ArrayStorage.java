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

        if (isResumeEquals(resume.getUuid())) {
            storage[index] = resume;
        } else {
            System.out.println("Error: The resume is not updated. The 'uuids' are not equals");
        }
    }

    public void save(Resume resume) {
        for (int j = 0; j < storage.length; j++) {
            if (count > storage.length) {
                System.out.println("Error: The storage is already full");
                break;
            }

            isResumeEquals(resume.getUuid());
            if (???){
                System.out.println("Error: The resume is already into the storage ");
            } else{
                storage[count] = resume;
                count++;
                index++;
                break;
            }
        }
    }

    public Resume get(String uuid) {
        if (isResumeEquals(uuid)) {
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        if (isResumeEquals(uuid)) {
            for (int k = count; k < count - 1; k++)
                storage[k] = storage[k + 1];
            count--;
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

    private int isResumeEquals(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return index;
            }
        }
        return 0;
    }
}
