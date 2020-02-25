package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.nio.file.Path;

public class ObjectStreamPathStorage extends AbstractPathStorage {
    public ObjectStreamPathStorage(Path directory) {
        super(String.valueOf(directory));
    }

    @Override
    protected void doWrite(Resume resume, OutputStream Path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Path)) {
            oos.writeObject(resume);
        }
    }

    @Override
    protected Resume doRead(InputStream Path) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(Path)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume",null, e);
        }
    }
}
