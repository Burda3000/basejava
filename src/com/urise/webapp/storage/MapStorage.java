package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getIndex(String uuid) {
        for (int i = 0; i < map.size(); i++) {
            if (map.containsKey(uuid)) {
                return uuid;
            }
        }
        return null;

    }

    @Override
    protected boolean isExist(Object index) {
        return map.containsKey(index);
    }

    @Override
    protected void doUpdate(Object searchIndex, Resume resume) {
        map.put((String) searchIndex, resume);
    }

    @Override
    protected void doSave(Object searchIndex, Resume resume) {
        map.put((String) searchIndex, resume);
    }

    @Override
    protected Resume doGet(Object searchIndex) {
        return map.get(searchIndex);
    }

    @Override
    protected void doDelete(Object searchIndex) {
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
