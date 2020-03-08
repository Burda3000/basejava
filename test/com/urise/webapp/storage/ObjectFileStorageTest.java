package com.urise.webapp.storage;

import com.urise.webapp.storage.serializationStorage.ObjectSerializationStream;

public class ObjectFileStorageTest extends AbstractStorageTest {
    public ObjectFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectSerializationStream()));
    }
}
