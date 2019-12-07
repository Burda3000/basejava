package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        doUpdate(resume);
    }

    public void save(Resume resume) {
        doSave(resume);
    }

    public Resume get(String uuid) {
        return doGet(uuid);
    }

    public void delete(String uuid) {
        doDelete(uuid);
    }

    protected abstract void doUpdate(Resume resume);

    protected abstract void doSave(Resume resume);

    protected abstract Resume doGet(String uuid);

    protected abstract void doDelete(String uuid);
}
