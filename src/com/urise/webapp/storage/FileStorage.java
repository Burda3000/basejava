package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializationStorage.ObjectSerializationStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private File directory;

    private com.urise.webapp.storage.serializationStorage.ObjectSerializationStream ObjectSerializationStream;

    protected FileStorage(File directory, ObjectSerializationStream objectSerializationStream) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
        this.ObjectSerializationStream = objectSerializationStream;
    }

    @Override
    protected List<Resume> getAllCopy() {
        List<Resume> lists = new ArrayList<>(getNullExceptionFiles().length);
        for (File file : getNullExceptionFiles()) {
            lists.add(doGet(file));
        }
        return lists;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doUpdate(File file, Resume resume) {
        try {
            ObjectSerializationStream.doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void doSave(File file, Resume resume) {
        try {
            file.createNewFile();
            doUpdate(file, resume);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return ObjectSerializationStream.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Reading error", file.getName(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("File has not been deleted", file.getName());
        }
    }

    @Override
    public void clear() {
        if (getNullExceptionFiles() != null) {
            for (File file : getNullExceptionFiles()) {
                doDelete(file);
            }
        }
    }

    @Override
    public int size() {
        return getNullExceptionFiles().length;
    }

    private File[] getNullExceptionFiles() {
        if (directory.listFiles() == null) {
            throw new StorageException("File has not been deleted", (String) null);
        }
        return directory.listFiles();
    }
}
