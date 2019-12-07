package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void doUpdate(Resume resume) {
        list.set(0, resume);
    }

    @Override
    public void doSave(Resume resume) {
        list.add(resume);
    }

    @Override
    public Resume doGet(String uuid) {
        return list.get(0);
    }

    @Override
    public void doDelete(String uuid) {
        list.remove(uuid);
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return list.size();
    }
}
