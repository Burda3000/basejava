package com.urise.webapp.storage;

import com.urise.webapp.storage.serializationStorage.ObjectSerializationStream;
//import com.urise.webapp.storage.serializationStorage.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectSerializationStream()));
    }
}