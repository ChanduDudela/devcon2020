package ctci.mediumproblems;

import java.util.ArrayList;
import java.util.HashMap;

public class PairsWithSum {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    ArrayList<Pair> getPairsWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> unpairedCount = new HashMap<>();
        ArrayList<Pair> result = new ArrayList<>();

        for (int element : arr) {
            int difference = element - target;
            if (unpairedCount.getOrDefault(difference, 0) > 0) {
                result.add(new Pair(element, difference));
                unpairedCount.put(difference, unpairedCount.get(difference) -1);
            } else {
                unpairedCount.put(element, unpairedCount.getOrDefault(element, 0) + 1);
            }
        }

        return result;
    }
}
