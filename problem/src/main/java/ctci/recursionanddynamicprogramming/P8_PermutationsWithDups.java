package ctci.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P8_PermutationsWithDups {

    List<String> getPermutations(String str) {
        Set<String> cache = new HashSet<>();
        return getPermutations(str, cache);
    }

    List<String> getPermutations(String str, Set<String> cache) {
        if(str == null) return null;

        List<String> result = new ArrayList<>();
        int len = str.length();

        if (len == 0) {
            result.add("");
            return result;
        }

        for (int i = 0; i < len; i++) {
            String begin = str.substring(0, i);
            String end = str.substring(i+1, len);

            if(cache.contains(begin + end)) {
                continue;
            }

            cache.add(begin + end);

            List<String> permutations = getPermutations(begin + end);

            for (String word : permutations) {
                result.add(str.charAt(i) + word);
            }
        }

        return result;
    }
}
