package ctci.hardproblems;

public class P10_MajorityElement {

    int findMajorityElement (int[] array) {
        int majority = findMajorityElementFromArray(array);
        if (validateMajority(majority, array)) {
            return majority;
        } else {
            return -1;
        }
    }

    int findMajorityElementFromArray (int[] array) {
        int majorityElement = 0;
        int count = 0;

        for (int elem : array) {
            if (count == 0) {
                majorityElement = elem;
            }

            if (majorityElement == elem) {
                count++;
            } else {
                count--;
            }
        }
        return majorityElement;
    }

    boolean validateMajority(int majority, int[] arr) {
        int count = 0;
        for (int elem : arr) {
            if (elem == majority){
                count++;
            }
        }

        return count > arr.length/2;
    }
}
