package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewMapStorage extends AbstractStorage {
    private Map<String, Resume> newMap = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {

    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    public void clear() {

    }

    @Override
    public List<Resume> getAllSorted() {
        return (List<Resume>) newMap.values();
    }

    @Override
    public int size() {
        return 0;
    }
}
