package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void subSaveMethod(int index, Resume resume) {
        storage[count] = resume;
        count++;
    }

    @Override
    public void subDeleteMethod(int index) {
        System.arraycopy(storage, count - 1, storage, count, count - 1);
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