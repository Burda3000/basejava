package com.urise.webapp.storage;

import com.urise.webapp.storage.serializationStorage.ObjectSerializationStream;

public class ObjectStreamFileStorageTest extends AbstractStorageTest {
    public ObjectStreamFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectSerializationStream()) {
        });
    }
}
