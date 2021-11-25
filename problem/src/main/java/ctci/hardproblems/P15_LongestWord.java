package ctci.hardproblems;

import java.util.Arrays;
import java.util.HashMap;

public class P15_LongestWord {
    String getLongestWord (String[] words) {
        if (words.length == 0) return "";

        Arrays.sort(words, (a, b) -> b.length() - a.length());

        HashMap<String, Boolean> map = new HashMap<>();
        for (String word: words) {
            map.put(word, true);
        }

        for (String word : words) {
            if (canBeBuilt(word, true, map)) {
                return word;
            }
        }

        return "";
    }

    boolean canBeBuilt (String str, boolean isOriginal, HashMap<String, Boolean> map) {
        if (map.containsKey(str) && !isOriginal) {
            map.get(str);
        }

        for (int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);

            if (map.containsKey(left) && map.get(left) && canBeBuilt(right, false, map)) {
                return true;
            }
        }

        map.put(str, false);
        return false;
    }
}
