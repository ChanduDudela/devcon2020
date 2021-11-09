package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/word-break/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordDictSet = new HashSet<>(wordDict);

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    // Approach 2 using BFS
    public boolean wordBreak_2(String s, List<String> wordDictL) {
        Set<String> wordDict = new HashSet<>(wordDictL);
        if (wordDict.contains(s)) {
            return true;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> indexQue = new LinkedList<>();
        indexQue.add(0);
        visited.add(0);

        while (!indexQue.isEmpty()) {
            int currIndex = indexQue.poll();

            for (int i = currIndex + 1; i <= s.length(); i++) {
                if (visited.contains(i)) {
                    continue;
                }

                if (wordDict.contains(s.substring(currIndex, i))) {
                    if (i == s.length()) {
                        return true;
                    }

                    visited.add(i);
                    indexQue.add(i);
                }
            }
        }

        return false;
    }
}
