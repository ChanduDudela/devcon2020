package ctci.mediumproblems;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    LinkedList<String> queueByKey;
    HashMap<String, String> map;

    final Integer MAX_SIZE;

    public LRUCache(int size) {
        MAX_SIZE = size;
        queueByKey = new LinkedList<>();
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
        if (queueByKey.size() == MAX_SIZE) {
            String removedKey = queueByKey.pop();
            map.remove(removedKey);
        }
    }

    void moveToHead(String key) {
        queueByKey.remove(key);
        queueByKey.offerFirst(key);
    }
}
