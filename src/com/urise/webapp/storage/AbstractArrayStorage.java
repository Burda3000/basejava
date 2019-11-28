package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    public static final int STORAGE_LIMIT = 4;

    Resume[] storage = new Resume[STORAGE_LIMIT];
    int count = 0;

    public int size() {
        return count;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
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

    public abstract void insert(int index, Resume resume);

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            remove(index);
            storage[count - 1] = null;
            count--;
        }
    }

    public abstract void remove(int index);

    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    protected abstract int getIndex(String uuid);
}
