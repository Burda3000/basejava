package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public void update(Resume resume) {
        LOG.info("Update " + resume);
        SK searchKey = getIndexNotExist(resume.getUuid());
        doUpdate(searchKey, resume);
    }

    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK searchKey = getIndexExist(resume.getUuid());
        doSave(searchKey, resume);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getIndexNotExist(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getIndexNotExist(uuid);
        doDelete(searchKey);
    }

    public List<Resume> getAllSorted() {
        LOG.info("get all sorted");
        List<Resume> list = getAllCopy();
        Collections.sort(list);
        return list;
    }

    private SK getIndexNotExist(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            return searchKey;
        } else {
            LOG.warning("Resume " + uuid + " already exist");
            throw new NotExistStorageException(uuid);
        }
    }

    private SK getIndexExist(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            return searchKey;
        } else {
            LOG.warning("Resume " + uuid + " not exist");
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract List<Resume> getAllCopy();

    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doUpdate(SK searchKey, Resume resume);

    protected abstract void doSave(SK searchKey, Resume resume);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doDelete(SK searchKey);
}
