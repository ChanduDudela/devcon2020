package aws.random.questions;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsetsInArray {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());

        for (int num: nums) {
            // we will take all existing subsets and insert the current number in them to
            // create new subsets
            int size = subsets.size();
            for (int j = 0; j < size; j++) {
                // create a new subset from the existing subset and
                // insert the current element to it
                List<Integer> newSubset = new ArrayList<>(subsets.get(j));
                newSubset.add(num);

                subsets.add(newSubset);
            }
        }

        return subsets;
    }


    public static void main(String[] args) {
        List<List<Integer>> result = FindAllSubsetsInArray.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = FindAllSubsetsInArray.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
