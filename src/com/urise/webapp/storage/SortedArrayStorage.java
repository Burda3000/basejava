package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        System.out.println(index);

        if (count > storage.length) {
            System.out.println("Error: The storage is already full");
        } else if (index < 0) {
            storage[- index - 1] = resume;
            count++;
            System.arraycopy(storage, -index-1, storage,-index-1, count);
        } else {
            System.out.println("Error: The " + resume.getUuid() + " is already into the storage ");
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }
}
