package ctci.mediumproblems;

public class SubSort {
    static class Range {
        int leftIndex;
        int rightIndex;

        public Range(int leftIndex, int rightIndex) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }

    Range findUnsortedSequence(int[] arr) {
        int left = getUnsortedIndexLeftToRight(arr);
        int right = getUnsortedIndexRightToLeft(arr);

        return new Range(left, right);
    }

    int getUnsortedIndexLeftToRight(int[] arr) {
        int max = Integer.MIN_VALUE;
        int leftIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) {
                leftIndex = i;
            }
            max = Math.max(max, arr[i]);
        }
        return leftIndex;
    }

    int getUnsortedIndexRightToLeft(int[] arr) {
        int min = Integer.MAX_VALUE;
        int rightIndex = arr.length-1;
        for (int i = arr.length-1; i >= 0; i--) {
            if (min < arr[i]) {
                rightIndex = i;
            }
            min = Math.min(min, arr[i]);
        }
        return rightIndex;
    }
}
