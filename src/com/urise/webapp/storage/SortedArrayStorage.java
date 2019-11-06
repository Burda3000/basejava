package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
            storage[-index - 1] = resume;
            System.arraycopy(storage, count, storage, (-index - 1) + 1, count);
            count++;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            for (int k = count; k < count - 1; k++)
                storage[k] = storage[k + 1];
            count--;
        } else {
            System.out.println("Error: The " + uuid + " doesn't exist");
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }
}
