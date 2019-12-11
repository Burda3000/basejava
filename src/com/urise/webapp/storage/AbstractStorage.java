package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Integer index = getIndexNotExist(resume.getUuid());
        doUpdate(resume, index);
    }

    public void save(Resume resume) {
        Integer index = getIndexExist(resume.getUuid());
        doSave(resume, index);
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
            throw new NotExistStorageException(uuid);
        } else {
            return searchingIndex;
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

    protected abstract void doUpdate(Resume resume, Integer getSearchingIndex);

    protected abstract void doSave(Resume resume, Integer getSearchingIndex);

    protected abstract Resume doGet(Integer getSearchingIndex);

    protected abstract void doDelete(Integer getSearchingIndex);
}
