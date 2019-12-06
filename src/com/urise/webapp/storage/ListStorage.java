package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> list = new ArrayList<>();

    int index1 = list.indexOf();

    @Override
    public void doUpdate(Resume resume) {
        //todo updating
        // где взять индекс?
        ifNotExist(resume.getUuid());
        list.set(0, resume);
    }

    @Override
    public void doSave(Resume resume) {
        //todo saving
        // индекс?
        list.add(resume);
    }

    @Override
    public Resume doGet(String uuid) {
        //todo getting
        // индекс?
        ifNotExist(uuid);
        return list.get(0);
    }

    @Override
    public void doDelete(String uuid) {
        //todo deleteting
        // индекс?
        ifNotExist(uuid);
        list.remove(uuid);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray();
    }

    @Override
    public int size() {
        return list.size();
    }
}
