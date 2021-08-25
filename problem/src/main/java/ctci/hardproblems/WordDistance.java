package ctci.hardproblems;

import java.util.ArrayList;
import java.util.HashMap;

public class WordDistance {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    // Pre-computation step of constructing a hash of words to their locations by index.
    // This will take O(N) time.
    Pair getLocation(
        HashMap<String, ArrayList<Integer>> mapWordToLocation, String word1, String word2) {

        ArrayList<Integer> word1Locations = mapWordToLocation.get(word1);
        ArrayList<Integer> word2Locations = mapWordToLocation.get(word2);

        int diff = Integer.MAX_VALUE;
        int index1 = 0, index2 = 0;

        Pair location = new Pair(-1, -1);

        // Finding the closest pair will take O(A+B) time
        while (index1 < word1Locations.size() && index2 < word2Locations.size()) {
            int val1 = word1Locations.get(index1);
            int val2 = word2Locations.get(index2);

            if (Math.abs(val1 - val2) < diff) {
                diff = Math.abs(val1 - val2);
                location.first = val1;
                location.second = val2;
            }

            if (val1 > val2) {
                index2 ++;
            } else {
                index1 ++;
            }
        }

        return location;
    }
}
