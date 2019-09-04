import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        Arrays.fill(storage, 0, count, null);
    }

    void update(Resume r) {
        for (int i = 0; i < count; i++) {
            if (r.uuid == storage[i].uuid) {
                storage[i].uuid = r.uuid;
            } else {
                System.out.println("Error");
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < count; i++) {
            if (count > storage.length) {
                System.out.println("Error: The storage is already full");
                break;
            }
        }

        if (r != storage[count]) {
            storage[count] = r;
            count++;
        } else {
            System.out.println("Error: This resume is already in the storage");
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            } else {
                System.out.println("Error: The resume doesn't exist");
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid != storage[i].uuid) {
                System.out.println("Error: The resume doesn't exist");
                break;
            } else {
                for (int k = count; k < count - 1; k++)
                    storage[k].uuid = storage[k + 1].uuid;
                count--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    int size() {
        return count;
    }
}
