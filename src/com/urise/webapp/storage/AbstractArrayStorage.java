package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    final public int size() {
        return count;
    }

    final public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.print("Error: The " + uuid + " is ");
        return null;
    }

    public abstract void clear();

    public abstract void update(Resume resume);

    public abstract void save(Resume resume);

    public abstract void delete(String uuid);

    public abstract Resume[] getAll();

    protected abstract int getIndex(String uuid);
}
