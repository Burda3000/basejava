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
    public void doUpdate(Resume resume) {
        storage[Integer.parseInt(resume.getUuid())] = resume;
    }

    @Override
    public void doSave(Resume resume) {
        if (count >= storage.length) {
            throw new StorageException("Error: The storage is already full", resume.getUuid());
        } else {
            insert(getIndex(resume.getUuid()), resume);
            count++;
        }
    }

    @Override
    public Resume doGet(String uuid) {
        return storage[getIndex(uuid)];
    }

    @Override
    public void doDelete(String uuid) {
        remove(getIndex(uuid));
        storage[count - 1] = null;
        count--;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }

    public abstract void remove(int index);

    public abstract void insert(int index, Resume resume);

    protected abstract int getIndex(String uuid);
}
