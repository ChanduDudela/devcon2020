package ctci.recursionanddynamicprogramming;

public class P3_MagicIndex {

    int getMagicIndex(int[] arr) {
        return getMagicIndex(arr, 0);
        //getMagicIndexDistinctNumbers(arr, 0, arr.length-1);
    }

    // my own solution
    int getMagicIndex(int[] arr, int idx) {
        if (arr[idx] == idx) {
            return idx;
        } else {
            idx = arr[idx];

            if (idx+1 <= arr.length - 1) {
                getMagicIndex(arr, idx+1);
            }
        }
        return -1;
    }

    // when numbers are distinct. Runtime O(log N), N - length of the array
    int getMagicIndexDistinctNumbers(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }

        int mid = start + end / 2;
        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] > mid) {
            return getMagicIndexDistinctNumbers(arr, start, mid - 1);
        } else {
            return getMagicIndexDistinctNumbers(arr, mid + 1, end);
        }
    }

    // when numbers are not distinct. Runtime O(log N), N - length of the array
    int getMagicIndexNonDistinctNumbers(int[] arr, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return -1;
        }

        int midIndex = startIndex + endIndex / 2;
        int midValue = arr[midIndex];

        if (midValue == midIndex) {
            return midIndex;
        }

        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = getMagicIndexNonDistinctNumbers(arr, startIndex, leftIndex);
        if (left > 0) {
            return left;
        }

        int rightIndex = Math.max(midIndex + 1, midValue);
        return getMagicIndexNonDistinctNumbers(arr, rightIndex, endIndex);
    }
}
