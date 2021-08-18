package ctci.mediumproblems;

import java.util.Arrays;

public class SmallestDifference {
    int findSmallestDifference(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return -1;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int smallestDiff = Integer.MAX_VALUE;
        int indexA = 0;
        int indexB = 0;
        while(indexA < a.length && indexB < b.length) {
            int difference = Math.abs(a[indexA] - b[indexB]);
            smallestDiff = Math.min(smallestDiff, difference);

            if (a[indexA] > b[indexB]) {
                indexB++;
            } else {
                indexA++;
            }
        }
        return smallestDiff;
    }
}
