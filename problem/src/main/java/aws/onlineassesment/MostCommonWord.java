package aws.onlineassesment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/most-common-word/
class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedWordsSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCountMap = new HashMap<>();
        String result = null;

        String[] str = paragraph.toLowerCase().split("[ !?',;.]+");

        int count;
        for (String s : str) {
            if (!bannedWordsSet.contains(s)) {
                count = wordCountMap.getOrDefault(s, 0);
                wordCountMap.put(s, ++count);
            }
        }

        count = 0;
        for (String s : wordCountMap.keySet()) {
            if (wordCountMap.get(s) > count) {
                count = wordCountMap.get(s);
                result = s;
            }
        }

        return result;
    }
}
