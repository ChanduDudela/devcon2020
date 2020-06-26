package aws.random.questions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LFU_Cache {

    static class Entry {
        int key;
        int val;
        int count;
        Entry(int k, int v, int c) {
            key = k;
            val = v;
            count = c;
        }
    }

    private HashMap<Integer, Entry> cache;
    private HashMap<Integer, LinkedHashSet<Entry>> countMap;
    private int capacity;
    private int min = -1;

    public LFU_Cache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        countMap = new HashMap<>();
        countMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Entry e = cache.get(key);
        countMap.get(e.count).remove(e);
        if (e.count == min && countMap.get(e.count).isEmpty()) {
            countMap.remove(e.count);
            min++;
        }
        e.count++;
        if (!countMap.containsKey(e.count)) {
            countMap.put(e.count, new LinkedHashSet<>());
        }
        countMap.get(e.count).add(e);
        return e.val;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (cache.containsKey(key)) {
            Entry e = cache.get(key);
            e.val = value;
            get(key);
            return;
        }
        if (cache.size() == capacity) {
            Iterator<Entry> it = countMap.get(min).iterator();
            Entry e = it.next();
            it.remove();
            cache.remove(e.key);
            if (!it.hasNext()) countMap.remove(min);
        }
        Entry ne = new Entry(key, value, 1);
        cache.put(key, ne);
        min = 1;
        if (!countMap.containsKey(1)) {
            countMap.put(1, new LinkedHashSet<>());
        }
        countMap.get(1).add(ne);
    }
}
