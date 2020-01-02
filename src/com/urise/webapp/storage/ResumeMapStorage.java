package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeMapStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> newMap = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return newMap.get(uuid);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        newMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        newMap.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected void doDelete(Resume resume) {
        newMap.remove(((resume)).getUuid());
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
