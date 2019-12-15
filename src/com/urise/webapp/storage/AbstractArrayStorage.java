package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    static final int STORAGE_LIMIT = 10_000;

    Resume[] storage = new Resume[STORAGE_LIMIT];
    int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    @Override
    public void doUpdate(Object index, Resume resume) {
        storage[(int) index] = resume;
    }

    @Override
    public void doSave(Object index, Resume resume) {
        if (count >= storage.length) {
            throw new StorageException("Error: The storage is already full", resume.getUuid());
        } else {
            insert((Integer) index, resume);
            count++;
        }
    }

    @Override
    public Resume doGet(Object index) {
        return storage[(int) index];
    }

    @Override
    public void doDelete(Object getIndex) {
        remove((Integer) getIndex);
        storage[count - 1] = null;
        count--;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }

    @Override
    public boolean isExist(Object index) {
        return (int) index >= 0;
    }

    public abstract void remove(int index);

    public abstract void insert(int index, Resume resume);

    public abstract Integer getIndex(String uuid);
}
