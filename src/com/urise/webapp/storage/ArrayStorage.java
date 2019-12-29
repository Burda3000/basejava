package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insert(int index, Resume resume) {
        storage[count] = resume;
    }

    @Override
    protected void remove(int index) {
        storage[index] = storage[count - 1];
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}