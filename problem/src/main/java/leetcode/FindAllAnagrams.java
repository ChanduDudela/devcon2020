package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
    // Using this template -
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
    public List<Integer> findAnagrams(String s, String p) {

        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequency of the Characters)
        Map<Character, Integer> charMap = new HashMap<>();
        for (char ch: p.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        int counter = charMap.size();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            char charAtEnd = s.charAt(end);
            if (charMap.containsKey(charAtEnd)) {
                charMap.put(charAtEnd, charMap.get(charAtEnd) -1);

                if (charMap.get(charAtEnd) == 0) {
                    counter--;
                }
            }
            end++;

            while (counter == 0) {
                char charAtStart = s.charAt(start);
                if (charMap.containsKey(charAtStart)) {
                    if (charMap.get(charAtStart) == 0) {
                        counter++;
                    }

                    charMap.put(charAtStart, charMap.get(charAtStart) +1);
                }

                if (end-start == p.length()) {
                    result.add(start);
                }

                start++;
            }
        }

        return result;
    }
}
