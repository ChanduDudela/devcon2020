package ctci.mediumproblems;

import java.util.Arrays;
import java.util.HashSet;

public class P21_SumSwap {

    int[] getValuesForSwap(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return null;
        }

        // target => (a-b)
        Integer target = getTargetValue(arr1, arr2);
        if (target == null) {
            return null;
        }

        // convert to hash for constant time lookup
        HashSet<Integer> arr2Hash = getArray2Hash(arr2);

        // b => (a-target)
        for(int element : arr1) {
            int diff = element - target;
            if (arr2Hash.contains(diff)) {
                return new int[]{element, diff};
            }
        }

        return null;
    }

    private HashSet<Integer> getArray2Hash(int[] arr2) {
        HashSet<Integer> arr2Hash = new HashSet<>();
        for(int i : arr2) {
            arr2Hash.add(i);
        }
        return arr2Hash;
    }

    /**
     * We are looking for 2 values a, b such that,
     *  sumA - a + b = SumB + a - b
     *  (a-b) = (sumA - sumB) / 2
     */
    Integer getTargetValue (int[] arr1, int[] arr2) {
        int arr1Sum = sum(arr1);
        int arr2Sum = sum(arr2);

        if (((arr1Sum - arr2Sum) % 2) != 0) {
            return null;
        }

        return (arr1Sum - arr2Sum) / 2;
    }

    int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
