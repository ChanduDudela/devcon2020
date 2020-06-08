package aws.onlineassesment;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubArrayWithKDiffIntegers {

    //This approach gives Time Limit Exceeded Exception in Leetcode
    public int subArraysWithKDistinct(int[] arr, int k) {
        int i = 0;
        int j = k - 1;
        int q = k - 1;
        Set<Integer> uniqueElements = new HashSet<>();

        int count = 0;

        while (q < arr.length) {
            while (j < arr.length) {
                for (int a = i; a <= j; a++) {
                    uniqueElements.add(arr[a]);
                }

                if (uniqueElements.size() == k) {
                    count++;
                }

                uniqueElements.clear();
                i++;
                j++;
            }
            q++;
            i = 0;
            j = q;
        }
        return count;
    }

    //Find Longest Continuous Increasing Subsequence In An Array - Problem #674
    //https://leetcode.com/problems/longest-continuous-increasing-subsequence/
    public int LongestContinuousIncreasingSubsequenceInAnArray(int[] arr) {

        int anchor = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(i>0 && arr[i-1] >= arr[i]){
                anchor = i;
            }
            count = Math.max(count, i - anchor + 1);
        }
        return count;
    }

}
