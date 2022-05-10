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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Sample output:
// findContiguousHistory(user0, user1)
// /pink, /register, /orange
public class ContiguousBrowserHistory {
    private static List<String> findContiguousHistory(String[] a, String[] b) {
        //Fill up DP table.
        int[][] dp = new int[a.length+1][b.length+1];

        int maxLength = 0;
        int maxUserinA = -1;

        for(int i=1; i<=a.length; i++) {
            for (int j=1; j<=b.length; j++) {

                if (Objects.equals(a[i - 1], b[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if(dp[i][j] > maxLength) {
                        maxUserinA = i;
                        maxLength = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return Arrays.asList(a).subList(maxUserinA-maxLength, maxUserinA);
    }
}
