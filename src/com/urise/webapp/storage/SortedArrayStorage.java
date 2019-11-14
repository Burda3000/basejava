package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void subSaveMethod(int index, Resume resume) {
        System.arraycopy(storage, (-index - 1), storage, (-index - 1) + 1, count);
        storage[-index - 1] = resume;
        count++;
    }

    @Override
    public void subDeleteMethod(int index) {
        System.arraycopy(storage, index + 1, storage, index, count);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }
}