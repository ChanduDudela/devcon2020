package aws.onlineassesment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/partition-labels/
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        if (s.length() == 1) {
            return Collections.singletonList(1);
        }

        List<Integer> result = new ArrayList<>();

        partitionRecursive(s, result);
        return result;
    }

    private static void partitionRecursive(String str, List<Integer> result) {
        if (str.length() == 0) {
            return;
        }
        char c = str.charAt(0);
        int lastIndex = str.lastIndexOf(c);

        for (int i = 0; i < lastIndex; i++) {
            int lastIndexOfIthChar = str.lastIndexOf(str.charAt(i));
            if (lastIndexOfIthChar > lastIndex) {
                lastIndex = lastIndexOfIthChar;
            }
        }
        result.add(lastIndex + 1);
        partitionRecursive(str.substring(lastIndex + 1), result);
    }

    // From Leetcode discussion - O(N) time
    public List<Integer> partitionLabels_LinearTime(String S) {
        // get the last seen index for each letter 'a' - 'z'
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }

        int boundary = 0, size = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char curChar = S.charAt(i);

            // update boundary and size along the way
            size++;
            boundary = Math.max(boundary, last[curChar - 'a']);

            // if we reach the boundary, we collect result and reset count to 0
            if (i == boundary) {
                ans.add(size);
                size = 0;
            }
        }
        return ans;
    }
}
