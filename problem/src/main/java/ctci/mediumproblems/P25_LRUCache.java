package ctci.mediumproblems;

import java.util.HashMap;
import java.util.LinkedList;

public class P25_LRUCache {
    LinkedList<String> linkedListOfKeys;
    HashMap<String, String> map;

    private final Integer MAX_SIZE;

    public P25_LRUCache(int size) {
        MAX_SIZE = size;
        linkedListOfKeys = new LinkedList<>();
        map = new HashMap<>(size);
    }

    String get(String key) {
        if (map.containsKey(key)) {
            moveToHead(key);
            return map.get(key);
        } else {
            return null;
        }
    }

    void insert (String key, String value) {
        map.put(key, value);
        moveToHead(key);
        if (linkedListOfKeys.size() >= MAX_SIZE) {
            String removedKey = linkedListOfKeys.removeLast();
            map.remove(removedKey);
        }
    }

    void moveToHead(String key) {
        linkedListOfKeys.remove(key);
        linkedListOfKeys.offerFirst(key);
    }
}
