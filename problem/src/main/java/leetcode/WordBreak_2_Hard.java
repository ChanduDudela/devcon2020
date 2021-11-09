package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/word-break-ii/
//https://leetcode.com/problems/word-break-ii/discuss/44179/Slightly-modified-DP-Java-solution
public class WordBreak_2_Hard {

    //cache for memoization of previous results
    Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        if (cache.containsKey(s)) {
            //cache already has result for this String, just return it
            return cache.get(s);
        }

        List<String> res = new ArrayList<>();

        if (wordDict.contains(s)) {
            res.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            if (wordDict.contains(left)) { // && containsSuffix(wordDict, right)) { // for more optimization
                List<String> rightStrResponse = wordBreak(right, wordDict);

                // for each right subtree result, push it into the array
                for (String str : rightStrResponse) {
                    res.add(left + " " + str);
                }
            }
        }
        cache.put(s, res);

        return cache.get(s);
    }

    // for optimizing
    // for checking any of the 'right' substring is in the dictionary,
    // if not, no need to recurse for this right substring
    private boolean containsSuffix(List<String> dict, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (dict.contains(str.substring(i))) {
                return true;
            }
        }
        return false;
    }
}
