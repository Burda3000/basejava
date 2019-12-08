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

//    public Integer getUuidIndex(String uuid) {
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getUuid().equals(uuid)) {
//                return i;
//            }
//        }
//        return null;
//    }
//    for the future
//    private boolean ifResumeExist(Resume resume) {
//        return getArrayIndex(resume.getUuid()) != null;
//    }
//
//    private boolean ifResumeNotExist(Resume resume) {
//        return getArrayIndex(resume.getUuid()) == null;
//    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void doUpdate(Resume resume, Integer index) {
        list.set(index, resume);
    }

    @Override
    public void doSave(Resume resume, Integer index) {
        list.add(resume);
    }

    @Override
    public Resume doGet(Integer index) {
        return list.get(index);
    }

    @Override
    public void doDelete(Integer index) {
        list.remove(index);
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
