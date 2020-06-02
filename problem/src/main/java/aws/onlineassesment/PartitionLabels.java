package aws.onlineassesment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/partition-labels/
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        if (s.length() == 1) {
            return Collections.singletonList(1);
        }

        List<Integer> result = new ArrayList<>();

        partitionRecursive(s, result);
        return result;
    }

    private static void partitionRecursive(String str, List<Integer> result) {
        if (str.length() == 0) {
            return;
        }
        char c = str.charAt(0);
        int lastIndex = str.lastIndexOf(c);

        for (int i = 0; i < lastIndex; i++) {
            int lastIndexOfIthChar = str.lastIndexOf(str.charAt(i));
            if (lastIndexOfIthChar > lastIndex) {
                lastIndex = lastIndexOfIthChar;
            }
        }
        result.add(lastIndex + 1);
        partitionRecursive(str.substring(lastIndex + 1), result);
    }
}
