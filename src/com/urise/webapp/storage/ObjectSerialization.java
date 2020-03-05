package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.io.*;

public interface ObjectSerialization {

    void doWrite(Resume resume, OutputStream os) throws IOException;
    Resume doRead(InputStream is) throws IOException;
}
