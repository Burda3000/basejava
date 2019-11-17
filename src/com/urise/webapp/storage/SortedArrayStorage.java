package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void insert(int index, Resume resume) {
        int finalIndex = (-index - 1);
        System.arraycopy(storage, finalIndex, storage, finalIndex + 1, count - finalIndex);
        storage[finalIndex] = resume;
    }

    @Override
    public void remove(int index) {
        int finalIndex = (-index - 1);
        System.arraycopy(storage, index + 1, storage, index, count + finalIndex);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }
}