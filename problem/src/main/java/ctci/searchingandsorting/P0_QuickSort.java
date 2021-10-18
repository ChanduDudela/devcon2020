package ctci.searchingandsorting;

public class P0_QuickSort {
    // pick a random partition element in the arr
    // all elements left of partition element should be less than partition element
    // all elements right of partition element should be greater than partition element
    // repeating this task multiple times will make the arr sorted.

    // O (n Log n) - average and O (n ^ 2) worst runtime (depends on the selection of pivot).
    // O (n Log n) memory
    void quickSort (int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    void quickSort (int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index) {
            quickSort(arr, left, index);
        }

        if (right > index) {
            quickSort(arr, index + 1, right);
        }
    }

    // find element on the left which should be on the right
    // find element on the right which should be on the left
    // swap both of them
    int partition(int[] arr, int left, int right) {
        int pivot = arr[left + (right- left) / 2];

        while (left <= right) {
            while (arr[left] < pivot) {
                left ++;
            }

            while (arr[right] > pivot) {
                right --;
            }

            if (left <= right) {
                swap(arr, left, right);
                left ++;
                right --;
            }
        }

        return left;
    }

    void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
