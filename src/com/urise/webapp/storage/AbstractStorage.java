package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object index = getIndexNotExist(resume.getUuid());
        doUpdate(index, resume);
    }

    public void save(Resume resume) {
        Object index = getIndexExist(resume.getUuid());
        doSave(index, resume);
    }

    public Resume get(String uuid) {
        Object index = getIndexNotExist(uuid);
        return doGet(index);
    }

    public void delete(String uuid) {
        Object index = getIndexNotExist(uuid);
        doDelete(index);
    }

    private Object getIndexNotExist(String uuid) {
        Object searchingIndex = getIndex(uuid);
        if (isExist(searchingIndex)) {
            return searchingIndex;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object getIndexExist(String uuid) {
        Object searchingIndex = getIndex(uuid);
        if (!isExist(searchingIndex)) {
            return searchingIndex;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract Object getIndex(String uuid);

    protected abstract boolean isExist(Object index);

    protected abstract void doUpdate(Object searchIndex, Resume resume);

    protected abstract void doSave(Object searchIndex, Resume resume);

    protected abstract Resume doGet(Object searchIndex);

    protected abstract void doDelete(Object searchIndex);
}
