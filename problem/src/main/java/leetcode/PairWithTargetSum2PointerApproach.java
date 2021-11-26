package leetcode;

public class PairWithTargetSum2PointerApproach {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 6};
        int[] res = getTargetSumIndices(arr, 2);
        System.out.println(res[0] + " " + res[1]);
    }

    private static int[] getTargetSumIndices(int[] arr, int target) {
        int[] res = new int[]{-1, -1};
        int start = 0, end = arr.length - 1;

        while (start < end) {
            if (arr[start] + arr[end] == target) {
                return new int[] {start, end};
            } else if (arr[start] + arr[end] > target) {
                end = end - 1;
            } else {
                start = start + 1;
            }
        }
        return res;
    }
}
