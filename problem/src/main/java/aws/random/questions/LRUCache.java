package aws.random.questions;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    static class Entry {
        final int key;
        int value;

        Entry right;
        Entry left;

        Entry(int k, int v){
            key = k;
            value = v;
        }

        int getKey(){
            return key;
        }

        int getValue(){
            return value;
        }

        void setValue(int v){
            value = v;
        }
    }

    Map<Integer, Entry> map;
    Entry start;
    Entry end;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        size = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            removeEntry(entry);
            moveToTop(entry);

            return entry.getValue();
        }

        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.setValue(value);
            removeEntry(entry);
            moveToTop(entry);

        } else {
            Entry newEntry = new Entry(key, value);
            newEntry.left = null;
            newEntry.right = null;

            if(map.size() == size){
                map.remove(end.key);
                removeEntry(end);
            }
            moveToTop(newEntry);

            map.put(key, newEntry);
        }
    }

    private void removeEntry(Entry node){
        if(node.right != null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }

        if(node.left != null){
            node.left.right = node.right;
        } else {
            start = node.right;
        }
    }

    private void moveToTop(Entry node){
        node.right = start;
        node.left = null;
        if(start != null) {
            start.left = node;
        }
        start = node;
        if(end == null){
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
