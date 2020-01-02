package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    static final int STORAGE_LIMIT = 10_000;

    Resume[] storage = new Resume[STORAGE_LIMIT];
    int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    @Override
    protected void doUpdate(Integer index, Resume resume) {
        storage[(Integer) index] = resume;
    }

    @Override
    protected void doSave(Integer index, Resume resume) {
        if (count >= storage.length) {
            throw new StorageException("Error: The storage is already full", resume.getUuid());
        } else {
            insert((Integer) index, resume);
            count++;
        }
    }

    @Override
    protected Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    protected void doDelete(Integer getIndex) {
        remove(getIndex);
        storage[count - 1] = null;
        count--;
    }

    protected List<Resume> getAllCopy() {
        return Arrays.asList(Arrays.copyOf(storage, count));
    }

    public int size() {
        return count;
    }

    @Override
    protected boolean isExist(Integer index) {
        return  index >= 0;
    }

    protected abstract void remove(int index);

    protected abstract void insert(int index, Resume resume);
}
