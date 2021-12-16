package leetcode;
// We have some click stream data that we gathered on our client's website.
// Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site.
// The histories are in chronological order, and no URL was visited more than once per person.

// Write a function that takes two users' browsing histories as input and
// returns the longest contiguous sequence of URLs that appears in both.

// Sample input:
// user0 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
// user1 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
// user2 = ["a", "/one", "/two"]
// user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
// user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
// user5 = ["a"]

import java.util.ArrayList;
import java.util.List;

// Sample output:
// findContiguousHistory(user0, user1)
// /pink, /register, /orange
public class ContiguousBrowserHistory {
    static List<String> findContiguousHistory(String[] user1, String[] user2) {
        List<String> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int endIndex = -1;
        int[][] dp = new int[user1.length+1][user2.length+1];

        for (int i = user1.length-1; i >=0; i--) {
            for (int j = user2.length-1; j >=0 ; j--) {
                if (user1[i].equalsIgnoreCase(user2[j])) {
                    dp[i][j] = dp[i+1][j+1] + 1;

                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        endIndex = j;
                    }
                    break;
                }
            }
        }

        if (max == Integer.MIN_VALUE) {
            return result;
        } else {
            for(int i = endIndex; i < max + endIndex; i++) {
                result.add(user2[i]);
            }
        }

        return result;
    }
}
