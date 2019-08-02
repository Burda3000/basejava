import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        Arrays.fill(storage, 0, storage.length, null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int k = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < storage.length - 1; j++)
                storage[j] = storage[j + 1];
            storage[storage.length - 1] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, 3);
    }

    int size() {
        for (int i = 0; i > storage.length; i++) {
            if (storage[i] != null) {
                count++;
            }
            System.out.print(count);
        }
        return 0;
    }
}
