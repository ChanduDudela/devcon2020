package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFU_Cache {

    static class Entry {
        final int key;
        int val;
        int frequency;

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    int capacity;
    Map<Integer, Entry> keyToEntryMap;
    Map<Integer, LinkedHashSet<Entry>> freqToEntryMap;
    int minSize;

    public LFU_Cache(int capacity) {
        this.capacity = capacity;
        keyToEntryMap = new HashMap<>();
        freqToEntryMap = new HashMap<>();

        minSize = 0;
    }

    public int get(int key) {
        if (!keyToEntryMap.containsKey(key)) {
            return -1;
        }

        Entry entry = keyToEntryMap.get(key);

        freqToEntryMap.get(entry.frequency).remove(entry);

        if (entry.frequency == minSize && freqToEntryMap.get(entry.frequency).isEmpty()) {
            freqToEntryMap.remove(entry.frequency);
            minSize++;
        }

        entry.frequency++;

        if (!freqToEntryMap.containsKey(entry.frequency)) {
            freqToEntryMap.put(entry.frequency, new LinkedHashSet<>());
        }
        freqToEntryMap.get(entry.frequency).add(entry);

        return entry.val;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (keyToEntryMap.containsKey(key)) {
            Entry entry = keyToEntryMap.get(key);
            entry.val = value;
            get(key);

            return;
        }

        if (keyToEntryMap.size() == capacity) {

            Entry entryWithMinFreq = freqToEntryMap.get(minSize).iterator().next();
            freqToEntryMap.get(minSize).remove(entryWithMinFreq);

            keyToEntryMap.remove(entryWithMinFreq.key);

            if (freqToEntryMap.get(minSize).size() == 0) {
                freqToEntryMap.remove(minSize);
            }
        }

        Entry newEntry = new Entry(key, value);
        minSize = 1;

        keyToEntryMap.put(key, newEntry);
        if (!freqToEntryMap.containsKey(minSize)) {
            freqToEntryMap.put(minSize, new LinkedHashSet<>());
        }
        freqToEntryMap.get(minSize).add(newEntry);
    }
}
