package ctci.searchingandsorting;

import java.util.Arrays;

public class P11_PeaksAndValleys {
    void sortForPeaksAndValleys(int[] arr) {
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i+=2) {
            swap(arr, i-1, i);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
