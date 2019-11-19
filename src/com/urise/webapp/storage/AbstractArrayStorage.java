package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 3;

    Resume[] storage = new Resume[STORAGE_LIMIT];
    int count = 0;

    final public int size() {
        return count;
    }

    final public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.print("Error: The " + uuid + " is ");
            return null;
        }
        return storage[index];
    }

    final public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    final public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Error: The " + resume.getUuid() + " is not updated. The 'uuids' are not equals");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (count >= storage.length) {
            System.out.println("Error: The storage is already full");
        } else if (index < 0) {
            insert(index, resume);
            count++;
        } else {
            System.out.println("Error: The " + resume.getUuid() + " is already into the storage ");
        }
    }

    public abstract void insert(int index, Resume resume);

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Error: The " + uuid + " doesn't exist");
        } else {
            remove(index);
            storage[count - 1] = null;
            count--;
        }
    }

    public abstract void remove(int index);

    final public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    protected abstract int getIndex(String uuid);
}
