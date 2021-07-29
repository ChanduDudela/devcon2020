package ctci.recursionanddynamicprogramming;

import java.util.ArrayList;

public class P4_PowerSet {

    public static ArrayList<ArrayList<Integer>> getAllSubsets(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // start by adding the empty subset
        result.add(new ArrayList<>());

        for (int a: arr) {
            // we will take all existing subsets and insert the current number in them to
            // create new subsets
            int subsetSize = result.size();
            for (int i = 0; i < subsetSize; i++) {
                // create a new subset from the existing subset and
                // insert the current element to it
                ArrayList<Integer> clone = new ArrayList<>(result.get(i));
                clone.add(a);

                result.add(clone);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = P4_PowerSet.getAllSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = P4_PowerSet.getAllSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
