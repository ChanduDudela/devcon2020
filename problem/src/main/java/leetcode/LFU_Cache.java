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
    int leastFrequency;

    public LFU_Cache(int capacity) {
        this.capacity = capacity;
        keyToEntryMap = new HashMap<>();
        freqToEntryMap = new HashMap<>();

        leastFrequency = 0;
    }

    public int get(int key) {
        if (!keyToEntryMap.containsKey(key)) {
            return -1;
        }

        Entry entry = keyToEntryMap.get(key);

        freqToEntryMap.get(entry.frequency).remove(entry);

        if (entry.frequency == leastFrequency && freqToEntryMap.get(entry.frequency).isEmpty()) {
            freqToEntryMap.remove(entry.frequency);
            leastFrequency++;
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

            Entry entryWithMinFreq = freqToEntryMap.get(leastFrequency).iterator().next();
            freqToEntryMap.get(leastFrequency).remove(entryWithMinFreq);

            keyToEntryMap.remove(entryWithMinFreq.key);

            if (freqToEntryMap.get(leastFrequency).size() == 0) {
                freqToEntryMap.remove(leastFrequency);
            }
        }

        Entry newEntry = new Entry(key, value);
        leastFrequency = 1;

        keyToEntryMap.put(key, newEntry);
        if (!freqToEntryMap.containsKey(leastFrequency)) {
            freqToEntryMap.put(leastFrequency, new LinkedHashSet<>());
        }
        freqToEntryMap.get(leastFrequency).add(newEntry);
    }
}
