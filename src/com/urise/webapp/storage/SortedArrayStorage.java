package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void insert(int index, Resume resume) {
        int lastIndex = (-index - 1);
        System.arraycopy(storage, lastIndex, storage, lastIndex + 1, count);
        storage[lastIndex] = resume;
    }

    @Override
    public void remove(int index) {
        System.arraycopy(storage, index + 1, storage, index, count);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }
}