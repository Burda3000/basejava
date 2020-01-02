package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    public void update(Resume resume) {
        SK searchKey = getIndexNotExist(resume.getUuid());
        doUpdate(searchKey, resume);
    }

    public void save(Resume resume) {
        SK searchKey = getIndexExist(resume.getUuid());
        doSave(searchKey, resume);
    }

    public Resume get(String uuid) {
        SK searchKey = getIndexNotExist(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        SK searchKey = getIndexNotExist(uuid);
        doDelete(searchKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = getAllCopy();
        Collections.sort(list);
        return list;
    }

    private SK getIndexNotExist(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            return searchKey;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private SK getIndexExist(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            return searchKey;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract List<Resume> getAllCopy();

    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doUpdate(SK searchKey, Resume resume);

    protected abstract void doSave(SK searchKey, Resume resume);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doDelete(SK searchKey);
}
