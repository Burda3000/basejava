package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    private Integer getArrayIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void doUpdate(Resume resume) {
        if (getArrayIndex(resume.getUuid()) != null) {
            list.set(getArrayIndex(resume.getUuid()), resume);
        } else {

            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void doSave(Resume resume) {
        if (getArrayIndex(resume.getUuid()) != null) {
            list.add(resume);
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    public Resume doGet(String uuid) {
        if (getArrayIndex(uuid) == null) {
            throw new NotExistStorageException(uuid);
        }
        return list.get(getArrayIndex(uuid));
    }

    @Override
    public void doDelete(String uuid) {
        if (getArrayIndex(uuid) == null) {
            throw new NotExistStorageException(uuid);
        } else {
            list.remove(list.get(getArrayIndex(uuid)));
        }
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
