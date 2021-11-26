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
    Map<Integer, LinkedHashSet<Entry>> freqToEntriesMap;
    int leastFrequency;

    public LFU_Cache(int capacity) {
        this.capacity = capacity;
        keyToEntryMap = new HashMap<>();
        freqToEntriesMap = new HashMap<>();

        leastFrequency = 0;
    }

    public int get(int key) {
        if (!keyToEntryMap.containsKey(key)) {
            return -1;
        }

        Entry entry = keyToEntryMap.get(key);

        freqToEntriesMap.get(entry.frequency).remove(entry);

        if (entry.frequency == leastFrequency && freqToEntriesMap.get(entry.frequency).isEmpty()) {
            freqToEntriesMap.remove(entry.frequency);
            leastFrequency++;
        }

        entry.frequency++;

        if (!freqToEntriesMap.containsKey(entry.frequency)) {
            freqToEntriesMap.put(entry.frequency, new LinkedHashSet<>());
        }
        freqToEntriesMap.get(entry.frequency).add(entry);

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
            Entry entryWithMinFreq = freqToEntriesMap.get(leastFrequency).iterator().next();
            freqToEntriesMap.get(leastFrequency).remove(entryWithMinFreq);

            keyToEntryMap.remove(entryWithMinFreq.key);

            if (freqToEntriesMap.get(leastFrequency).isEmpty()) {
                freqToEntriesMap.remove(leastFrequency);
            }
        }

        Entry newEntry = new Entry(key, value);
        leastFrequency = 1;

        keyToEntryMap.put(key, newEntry);
        if (!freqToEntriesMap.containsKey(leastFrequency)) {
            freqToEntriesMap.put(leastFrequency, new LinkedHashSet<>());
        }
        freqToEntriesMap.get(leastFrequency).add(newEntry);
    }
}
