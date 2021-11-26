package leetcode;

/**
 * This question was asked in Amazon telephonic round.
 *
 * The z-index is a metric that measures both the productivity and citation impact of a researcher.
 * Specifically, a researcher's z-index is the largest number z such that the researcher has published
 * z papers that have each been cited at least z times.
 *
 * For example, if Amy has published papers A, B, C, D, E, F, G, H, I,
 * which have been cited 1, 4, 1, 4, 2, 1, 3, 5, 6 times, respectively,
 * then her z-index is 4 (corresponding to papers B, D, H, I).
 *
 * Design an algorithm that determines a researcher's z-index, then discuss the time and space complexity of your algorithm.
 *
 * [3, 1, 2]-> z == 2
 * [1, 4, 1, 4, 2, 1, 3, 5, 6] -> z == 4
 * [1, 1, 1]-> z == 1
**/
// "Counting Sort" algorithm (Variation of bucket sort)
// Explanation - https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
public class FindZIndexOfResearcher {
    public static int findZIndex (int[] citations) {
        int n = citations.length;

        // an array with length - input array length + 1
        int[] bucket = new int[n+1];

        // If the number of citations for a paper is out of range, increment the last bucket value
        // else, increment the value at it's index
        for (int citation: citations) {
            if (citation >= n) {
                bucket[n]++;
            } else {
                bucket[citation]++;
            }
        }

        int zIndex = 0;

        // Iterate from backwards, and cumulatively add the value in the bucket for that index
        // If the value is >= index of the current element, that's the Z-Index.
        for (int i = n; i >= 0; i--) {
            zIndex += bucket[i];

            if (zIndex >= i) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(FindZIndexOfResearcher.findZIndex(new int[]{1, 1, 1}));
    }
}
