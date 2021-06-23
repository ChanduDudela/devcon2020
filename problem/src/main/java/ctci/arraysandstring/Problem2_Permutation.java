package ctci.arraysandstring;

import java.util.Arrays;

public class Problem2_Permutation {
    // sort both strings and equate
    private boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }

    // character counts for both strings using hash table like implementation using array
    private boolean isPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] arr = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)]++ ;
        }

        for (int i = 0; i < s2.length(); i++) {
            arr[s2.charAt(i)]-- ;

            if(arr[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new Problem2_Permutation().isPermutation2("cat", "tac");
        System.out.println(result);
    }
}
