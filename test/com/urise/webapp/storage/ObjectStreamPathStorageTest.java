package com.urise.webapp.storage;

import com.urise.webapp.storage.serializationStorage.ObjectSerializationStream;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {
    public ObjectStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.toString(), new ObjectSerializationStream()) {
        });
    }
}