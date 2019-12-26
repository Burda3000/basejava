package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewMapStorage extends AbstractStorage {
    private Map<String, Resume> newMap = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return newMap.get(uuid);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return newMap.containsKey((String) searchKey);
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        newMap.put((String) searchKey, resume);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        newMap.put((String) searchKey, resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return newMap.get((String) searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        newMap.remove((String) searchKey);
    }

    @Override
    public void clear() {
        newMap.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return (List<Resume>) newMap.values();
    }

    @Override
    public int size() {
        return newMap.size();
    }
}
