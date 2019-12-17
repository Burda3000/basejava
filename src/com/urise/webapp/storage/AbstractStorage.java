package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object searchKey = getIndexNotExist(resume.getUuid());
        doUpdate(searchKey, resume);
    }

    public void save(Resume resume) {
        Object searchKey = getIndexExist(resume.getUuid());
        doSave(searchKey, resume);
    }

    public Resume get(String uuid) {
        Object searchKey = getIndexNotExist(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getIndexNotExist(uuid);
        doDelete(searchKey);
    }

    private Object getIndexNotExist(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            return searchKey;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object getIndexExist(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            return searchKey;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract Object getSearchKey(String uuid);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doUpdate(Object searchKey, Resume resume);

    protected abstract void doSave(Object searchKey, Resume resume);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(Object searchKey);
}
