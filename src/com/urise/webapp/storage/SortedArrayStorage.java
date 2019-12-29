package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    /*
    private static class ResumeComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }
    */

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void insert(int index, Resume resume) {
        int finalIndex = -index - 1;
        System.arraycopy(storage, finalIndex, storage, finalIndex + 1, count - finalIndex);
        storage[finalIndex] = resume;
    }

    @Override
    protected void remove(int index) {
        int finalIndex = -index - 1;
        System.arraycopy(storage, index + 1, storage, index, count + finalIndex);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "fullName");
        return Arrays.binarySearch(storage, 0, count, searchKey, RESUME_COMPARATOR);
    }
}