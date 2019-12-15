package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    public Integer getIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean isExist(Object index) {
        return index != null;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void doUpdate(Object index, Resume resume) {
        list.set((Integer) index, resume);
    }

    @Override
    public void doSave(Object index, Resume resume) {
        list.add(resume);
    }

    @Override
    public Resume doGet(Object index) {
        return list.get((Integer) index);
    }

    @Override
    public void doDelete(Object index) {
        list.remove(((Integer) index).intValue());
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return list.size();
    }
}
