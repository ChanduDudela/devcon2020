package ctci.mediumproblems;

public class P16_SubSort {
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
        int leftMax = Integer.MIN_VALUE;
        int leftIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (leftMax > arr[i]) {
                leftIndex = i;
            }
            leftMax = Math.max(leftMax, arr[i]);
        }
        return leftIndex;
    }

    int getUnsortedIndexRightToLeft(int[] arr) {
        int rightMin = Integer.MAX_VALUE;
        int rightIndex = arr.length-1;
        for (int i = arr.length-1; i >= 0; i--) {
            if (rightMin < arr[i]) {
                rightIndex = i;
            }
            rightMin = Math.min(rightMin, arr[i]);
        }
        return rightIndex;
    }
}
