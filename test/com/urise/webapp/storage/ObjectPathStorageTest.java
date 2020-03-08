package com.urise.webapp.storage;

import com.urise.webapp.storage.serializationStorage.ObjectSerializationStream;

public class ObjectPathStorageTest extends AbstractStorageTest {
    public ObjectPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectSerializationStream()));
    }
}