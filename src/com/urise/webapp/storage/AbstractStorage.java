package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public abstract Integer getIndex(String uuid);

    public void update(Resume resume) {
        Integer index = getIndex(resume.getUuid());
        doUpdate(resume, index);
    }

    public void save(Resume resume) {
        Integer index = getIndex(resume.getUuid());
        doSave(resume, index);
    }

    public Resume get(String uuid) {
        Integer index = getIndex(uuid);
        return doGet(index);
    }

    public void delete(String uuid) {
        Integer index = getIndex(uuid);
        doDelete(index);
    }

    private Integer getIndexNotExist(String uuid) {
        Integer getSearchingIndex = getIndex(uuid);
        if (isExist(getSearchingIndex)) {
            throw new NotExistStorageException(uuid);
        } else {
            return getSearchingIndex;
        }
    }

    private Integer getIndexExist(String uuid) {
        Integer getSearchingIndex = getIndex(uuid);
        if (!isExist(getSearchingIndex)) {
            return getSearchingIndex;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    public abstract boolean isExist(Integer index);

    protected abstract void doUpdate(Resume resume, Integer getSearchingIndex);

    protected abstract void doSave(Resume resume, Integer getSearchingIndex);

    protected abstract Resume doGet(Integer getSearchingIndex);

    protected abstract void doDelete(Integer getSearchingIndex);
}
