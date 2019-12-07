package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    public void updating(Resume resume) {
        list.set(0, resume);
    }

    @Override
    public void saving(Resume resume) {
        list.add(resume);
    }

    @Override
    public Resume getting(String uuid) {
        return list.get(0);
    }

    @Override
    public void deleting(String uuid) {
        list.remove(uuid);
    }

    @Override
    public void clear() {
        list.clear();
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
