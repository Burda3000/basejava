package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Integer index = getIndexNotExist(resume.getUuid());
        doUpdate(index, resume);
    }

    public void save(Resume resume) {
        Integer index = getIndexExist(resume.getUuid());
        doSave(index, resume);
    }

    public Resume get(String uuid) {
        Integer index = getIndexNotExist(uuid);
        return doGet(index);
    }

    public void delete(String uuid) {
        Integer index = getIndexNotExist(uuid);
        doDelete(index);
    }

    private Integer getIndexNotExist(String uuid) {
        Integer searchingIndex = getIndex(uuid);
        if (isExist(searchingIndex)) {
            return searchingIndex;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Integer getIndexExist(String uuid) {
        Integer searchingIndex = getIndex(uuid);
        if (!isExist(searchingIndex)) {
            return searchingIndex;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract Integer getIndex(String uuid);

    protected abstract boolean isExist(Integer index);

    protected abstract void doUpdate(Integer searchIndex, Resume resume);

    protected abstract void doSave(Integer searchIndex, Resume resume);

    protected abstract Resume doGet(Integer searchIndex);

    protected abstract void doDelete(Integer searchIndex);
}
