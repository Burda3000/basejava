package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeMapStorage extends AbstractStorage {
    private Map<String, Resume> newMap = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return newMap.get(uuid);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected void doUpdate(Object r, Resume resume) {
        newMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Object r, Resume resume) {
        newMap.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(Object resume) {
        newMap.remove((((Resume) resume)).getUuid());
    }

    @Override
    public void clear() {
        newMap.clear();
    }

    @Override
    protected List<Resume> getAllCopy() {
        return new ArrayList<>(newMap.values());
    }

    @Override
    public int size() {
        return newMap.size();
    }
}
