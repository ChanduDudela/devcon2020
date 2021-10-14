package core.algorithms;

public class QuickSort {
    public int partition(int[] nums, int low, int high) {
        int i = low;
        int pivot = nums[high];

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private void swap (int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
