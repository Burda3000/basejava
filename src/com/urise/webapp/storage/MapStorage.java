package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<Integer, Resume> map = new HashMap<>();

    @Override
    protected Integer getIndex(String uuid) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Integer index) {
        return map.containsKey(index);
    }

    @Override
    protected void doUpdate(Integer searchIndex, Resume resume) {
        map.put(searchIndex, resume);
    }

    @Override
    protected void doSave(Integer searchIndex, Resume resume) {
        map.put(searchIndex, resume);
    }

    @Override
    protected Resume doGet(Integer searchIndex) {
        return map.get(searchIndex);
    }

    @Override
    protected void doDelete(Integer searchIndex) {
        map.remove(searchIndex);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return map.size();
    }
}
