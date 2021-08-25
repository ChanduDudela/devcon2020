package ctci.hardproblems;

import java.util.Random;

public class RandomSet {
    int[] pickRandomSubset(int[] original, int m) {
        if (m > original.length) return null;

        int[] subset = new int[m];

        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }

        Random rand = new Random();
        for (int i = m; i < original.length; i++) {
            int k = rand.nextInt(i + 1);
            if (k < m) {
                subset[k] = original[i];
            }
        }

        return subset;
    }
}
