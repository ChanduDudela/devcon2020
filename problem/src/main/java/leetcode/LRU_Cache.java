package leetcode;

import java.util.HashMap;
import java.util.Map;

class LRU_Cache {

    static class Entry {
        final int key;
        int value;

        Entry right;
        Entry left;

        Entry(int k, int v) {
            key = k;
            value = v;
            right = null;
            left = null;
        }

        int getKey() {
            return key;
        }

        int getValue() {
            return value;
        }

        void setValue(int v) {
            value = v;
        }
    }

    Map<Integer, Entry> map;
    Entry start;
    Entry end;
    private final int MAX_CAPACITY;

    public LRU_Cache(int capacity) {
        map = new HashMap<>(capacity);
        MAX_CAPACITY = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Entry entry = map.get(key);
        removeEntry(entry);
        moveToTop(entry);

        return entry.getValue();
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            entry.setValue(value);
            removeEntry(entry);
            moveToTop(entry);
        } else {
            Entry newEntry = new Entry(key, value);

            if (map.size() == MAX_CAPACITY) {
                map.remove(end.key);
                removeEntry(end);
            }

            map.put(key, newEntry);
            moveToTop(newEntry);
        }
    }

    private void removeEntry(Entry node) {
        if (node.right != null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }

        if (node.left != null) {
            node.left.right = node.right;
        } else {
            start = node.right;
        }
    }

    private void moveToTop(Entry node) {
        node.right = start;
        node.left = null;
        if (start != null) {
            start.left = node;
        }
        start = node;
        if (end == null) {
            end = start;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
