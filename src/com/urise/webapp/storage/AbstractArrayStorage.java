package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
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
    public void doUpdate(Resume resume) {
        //todo undex
        int index = getIndex(resume.getUuid());
//        ifNotExist(resume.getUuid());
        storage[index] = resume;
    }

    @Override
    public void doSave(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (count >= storage.length) {
            throw new StorageException("Error: The storage is already full", resume.getUuid());
        } else if (index < 0) {
            insert(index, resume);
            count++;
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    public Resume doGet(String uuid) {
        //todo index
        int index = getIndex(uuid);
//        ifNotExist(uuid);
        return storage[index];
    }

    @Override
    public void doDelete(String uuid) {
        //todo index
        int index = getIndex(uuid);
//        ifNotExist(uuid);
        remove(index);
        storage[count - 1] = null;
        count--;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }

    public abstract void insert(int index, Resume resume);

    protected abstract int getIndex(String uuid);

    public abstract void remove(int index);
}
