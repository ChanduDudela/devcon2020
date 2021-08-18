package ctci.mediumproblems;

import java.util.HashSet;

public class DivingBoard {
    HashSet<Integer> getLengthsOfBoard(int k, int l1, int l2) {
        HashSet<Integer> lengths = new HashSet<>();
        HashSet<String> cache = new HashSet<>(); // storing combination of - total + " " + k

        getLengths(k, 0, l1, l2, lengths, cache);
        return lengths;
    }

    void getLengths(
        int k, int total, int l1, int l2, HashSet<Integer> lengths, HashSet<String> cache) {
        if (k == 0) {
            lengths.add(total);
            return;
        }
        String key = total + " " + k;

        if (cache.contains(key)) {
            return;
        }

        getLengths(k-1, total + l1, l1, l2, lengths, cache);
        getLengths(k-1, total + l2, l1, l2, lengths, cache);

        cache.add(key);
    }

    /////// Approach 2 //////

    HashSet<Integer> getDiffLengthsOfBoard(int k, int l1, int l2) {
        HashSet<Integer> lengths = new HashSet<>();
        for (int nShorter = 0; nShorter < l1; nShorter++) {
            int nLonger = k - nShorter;
            int length = nShorter * l1 + nLonger * l2;
            lengths.add(length);
        }
        return lengths;
    }
}
