package ctci.hardproblems;

public class MajorityElement {

    int findMajorityElement (int[] array) {
        int majority = findMajorityElementFromArray(array);
        if (validateMajority(majority, array)) {
            return majority;
        } else {
            return -1;
        }
    }

    int findMajorityElementFromArray (int[] array) {
        int majority = 0;
        int count = 0;

        for (int elem : array) {
            if (count == 0) {
                majority = elem;
            }

            if (majority == elem) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
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
