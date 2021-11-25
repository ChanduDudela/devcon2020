package ctci.hardproblems;

import java.util.HashMap;

public class P5_LettersAndNumbers {
    // find delta array between letter and numbers
    // find max span with same delta value

    char[] findLongestSubArray (char[] array) {
        int[] deltaArray = findDeltaArray(array);

        int[] indexRange = getMaxSpanIndices(deltaArray);

        return extractSubArray(array, indexRange[0] + 1, indexRange[1]);
    }

    int[] findDeltaArray (char[] array) {
        int diff = 0;
        int[] delta = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if(Character.isLetter(array[i])) {
                diff++;
            } else if (Character.isDigit(array[i])) {
                diff--;
            }
            delta[i] = diff;
        }

        return delta;
    }

    int[] getMaxSpanIndices(int[] delta) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] max = new int[2];

        for (int i = 0; i < delta.length; i++) {
            if (!map.containsKey(delta[i])){
                map.put(delta[i], i);
            } else {
                int sameDiffIndex = map.get(delta[i]);

                if (i - sameDiffIndex > max[1] - max[0]) {
                    max[0] = sameDiffIndex;
                    max[1] = i;
                }
            }
        }
        return max;
    }

    char[] extractSubArray(char[] array, int start, int end) {
        char[] result = new char[end-start+1];

        for (int i = start; i < end; i++) {
            result[i - start] = array[start];
        }
        return result;
    }
}
