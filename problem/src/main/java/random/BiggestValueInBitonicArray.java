package random;

/**
 * A Bitonic array is a sorted array;
 * The only difference is that its first part is sorted in ascending order,
 * and the second part is sorted in descending order.
 */
public class BiggestValueInBitonicArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 9, 10, 12, 4, 3, 2, 1};
        System.out.println(findMax(arr));
    }

    public static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid+1]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return arr[start];
    }
}
