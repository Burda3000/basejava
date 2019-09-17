package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
    }

    public void update(Resume resume) {

        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                storage[i] = resume;
                break;
            } else {
                System.out.println("Error: The resume is not updated. The 'uuids' are not equals");
                break;
            }
        }
//        for (int i = 0; i < count; i++) {
//            if (storage[i].getUuid().equals(resume.getUuid())) {
//                storage[i] = resume;
//                break;
//            } else {
//                System.out.println("Error: The resume is not updated. The 'uuids' are not equals");
//                break;
//            }
//        }
    }

    public void save(Resume resume) {
        for (int j = 0; j < storage.length; j++) {
            if (count > storage.length) {
                System.out.println("Error: The storage is already full");
                break;
            }
//            if (getEquals(count, resume.getUuid())) {
//                System.out.println("Error: The resume is already into the storage ");
//                break;
//            } else {
//                storage[count] = resume;
//                count++;
//                break;
//            }

            for (int i = 0; i < count; i++) {
                if (storage[i].getUuid().equals(resume.getUuid())) {
                    System.out.println("Error: The resume is already into the storage ");
                    break;
                } else {
                    storage[count] = resume;
                    count++;
                    break;
                }
            }
        }
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
                break;
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

    //integer = count;
//    public boolean getEquals (int integer, String resume) {
//        for (int i = 0; i < integer; i++) {
//            if (storage[i].getUuid().equals(resume)) {
//                break;
//            }
//        }
//        return false;
//    }
}
