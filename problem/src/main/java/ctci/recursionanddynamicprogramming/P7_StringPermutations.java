package ctci.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class P7_StringPermutations {
    /**
     *  permutations of P1           = P1
     *  permutations of (P1, P2)     = P2 + permutations of P1
     *  permutations of P1, P2, P3   =
     *      get permutations of (P2, P3) and for each string prepend P1.
     *      + get permutations of (P3, P1) and for each string prepend P2.
     *      + get permutations of (P1, P2) and for each string prepend P3.
     */
    List<String> getPermutations(String str) {
        if (str == null) {
            return null;
        }

        int len = str.length();

        ArrayList<String> result = new ArrayList<>();
        if (len == 0) {
            result.add("");
            return result;
        }

        for (int i = 0; i < len; i++) {
            String begin = str.substring(0, i);
            String end = str.substring(i + 1, len);

            //get permutations for String without character at i
            List<String> words = getPermutations(begin + end);

            // for each word, prepending char at i
            for (String word : words) {
                result.add(str.charAt(i) + word);
            }
        }
        return result;
    }
}
