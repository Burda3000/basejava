package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        updating(resume);
    }

    public void save(Resume resume) {
        saving(resume);
    }

    public Resume get(String uuid) {
        return getting(uuid);
    }

    public void delete(String uuid) {
        deleting(uuid);
    }

    protected abstract void deleting(String uuid);

    protected abstract void updating(Resume resume);

    protected abstract void saving(Resume resume);

    protected abstract Resume getting(String uuid);
}
