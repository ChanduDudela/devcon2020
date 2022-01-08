package blind.list;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        int begin = 0;
        int end = 0;
        int maxLength = 0;

        while (end < s.length()) {
            char charAtEnd = s.charAt(end);

            if (charToIndexMap.containsKey(charAtEnd)) {
                int idx = charToIndexMap.get(charAtEnd);
                begin = Math.max(begin, idx);
            }
            charToIndexMap.put(charAtEnd, end);

            maxLength = Math.max(maxLength, end - begin + 1);
        }

        return maxLength;
    }
}
