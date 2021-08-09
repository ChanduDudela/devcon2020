package ctci.searchingandsorting;

public class MergeSort {
    // split array by half and for each sub-array -
        // sort the sub-arrays and merge them back together

    // O (n Log n) - average and worst runtime.
    void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length-1);
    }

    private void mergeSort(int[] arr, int[] helper, int low, int high) {
        while (low < high) {
            int middle = low + (high - low) /2;
            mergeSort(arr, helper, low, middle);
            mergeSort(arr, helper, middle + 1 , high);

            merge(arr, helper, low, middle, high);
        }
    }

    private void merge(int[] arr, int[] helper, int low, int middle, int high) {
        // copy low to high from arr into helper
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }
        int helperLeft = low;
        int helperRight = middle + 1;
        int current = helperLeft;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                arr[current] = helper[helperLeft];
                helperLeft++;
            } else {
                arr[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        // transfer remaining elements from helperLeft
        int rem = middle - helperLeft;
        for (int i = 0; i < rem; i++) {
            arr[current + i] = helper[helperLeft + i];
        }
    }
}
