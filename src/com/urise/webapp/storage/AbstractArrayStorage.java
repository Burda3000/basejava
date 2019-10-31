package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10_000;

    Resume[] storage = new Resume[STORAGE_LIMIT];
    int count = 0;

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

    public abstract void save(Resume resume);

    final public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            System.arraycopy(storage, count + 1, storage, count, count - 1 - count);
            count--;
        } else {
            System.out.println("Error: The " + uuid + " doesn't exist");
        }
    }

    final public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    protected abstract int getIndex(String uuid);
}
