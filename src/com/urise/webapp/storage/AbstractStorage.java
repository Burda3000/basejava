package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public abstract Integer getIndex(String uuid);

    public void update(Resume resume) {
        Integer index = getIndex(resume.getUuid());
        ifIndexNotExist(String.valueOf(index));
        doUpdate(resume, index);
    }

    public void save(Resume resume) {
        ifIndexExist(resume.getUuid());
        doSave(resume, Integer.valueOf(resume.getUuid()));
    }

    public Resume get(String uuid) {
        Integer index = getIndex(uuid);
        ifIndexNotExist(String.valueOf(index));
        return doGet(index);
    }

    public void delete(String uuid) {
        Integer index = getIndex(uuid);
        ifIndexNotExist(String.valueOf(index));
        doDelete(index);
    }

    private int ifIndexNotExist(String uuid) {
        if (getIndex(uuid) == null) {
            throw new NotExistStorageException(uuid);
        } else {
            return getIndex(uuid);
        }
    }

    private int ifIndexExist(String uuid) {
        if (getIndex(uuid) != null) {
            return getIndex(uuid);
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract void doUpdate(Resume resume, Integer index);

    protected abstract void doSave(Resume resume, Integer index);

    protected abstract Resume doGet(Integer index);

    protected abstract void doDelete(Integer index);
}
