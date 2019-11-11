package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (count > storage.length) {
            System.out.println("Error: The storage is already full");
        } else if (index < 0) {
            System.arraycopy(storage, (-index - 1), storage, (-index - 1) + 1, count);
            storage[-index - 1] = resume;
            count++;
        } else {
            System.out.println("Error: The " + resume.getUuid() + " is already into the storage ");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Error: The " + uuid + " doesn't exist");
        } else {
            for (int k = count; k < count - 1; k++)
                storage[k] = storage[k + 1];
            count--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }
}