package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    private int getArrayIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void doUpdate(Resume resume) {
        list.set(getArrayIndex(resume.getUuid()), resume);
    }

    @Override
    public void doSave(Resume resume) {
        list.add(resume);
    }

    @Override
    public Resume doGet(String uuid) {
        return list.get(getArrayIndex(uuid));
    }

    @Override
    public void doDelete(String uuid) {
        list.remove(list.get(getArrayIndex(uuid)));
    }

    @Override
    public Resume[] getAll() {
        return new Resume[list.size()];
    }

    @Override
    public int size() {
        return list.size();
    }
}
