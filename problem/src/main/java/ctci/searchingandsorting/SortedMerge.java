package ctci.searchingandsorting;

public class SortedMerge {

    //
    int[] mergeSortedArrays(int a[], int b[], int aCount, int bCount) {
        int mergedIndex = aCount + bCount - 1; // last index of merged array
        int aLastIndex = aCount - 1; // last index in arr a
        int bLastIndex = bCount - 1; // last index in arr b

        // come from backwards, whichever is greater, assign it to a[mergedIndex]
        while (bLastIndex >= 0) {
            if (aLastIndex >=0 && a[aLastIndex] > b[bLastIndex]) {
                a[mergedIndex] = a[aLastIndex];
                aLastIndex--;
            } else {
                a[mergedIndex] = b[bLastIndex];
                bLastIndex--;
            }
            mergedIndex--;
        }
        return a;
    }
}
