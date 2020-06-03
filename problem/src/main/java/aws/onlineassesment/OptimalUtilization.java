package aws.onlineassesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/discuss/interview-question/373202
public class OptimalUtilization {

    public static void main(String[] args) {
        List<int[]> a = new ArrayList<>();
        a.add(new int[] {1, 3});
        a.add(new int[] {2, 5});
        a.add(new int[] {3, 7});
        a.add(new int[] {4, 10});

        List<int[]> b = new ArrayList<>();
        b.add(new int[] {1, 2});
        b.add(new int[] {2, 3});
        b.add(new int[] {3, 4});
        b.add(new int[] {4, 5});

        int target = 10;
        List<int[]> result = getPairs(a, b, target);

        System.out.println(Arrays.deepToString(result.toArray()));
    }

    private static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {

        Map<Integer, List<int[]>> resultMap = new TreeMap<>(Integer::compareTo);

        int count = 0;
        for (int[] x : a) {
            for (int[] y : b) {
                if (x[1] + y[1] >= count && x[1] + y[1] <= target) {
                    count = x[1] + y[1];
                    List<int[]> listWithSameCount =
                        resultMap.getOrDefault(count, new ArrayList<>());
                    listWithSameCount.add(new int[] {x[0], y[0]});
                    resultMap.putIfAbsent(count, listWithSameCount);
                }
            }
        }

        int maxCount = 0;
        List<int[]> result = new ArrayList<>();

        if (resultMap.size() == 0) {
            return result;
        }

        for (int cnt : resultMap.keySet()) {
            if (cnt > maxCount) {
                result = resultMap.get(cnt);
            }
        }

        return result;
    }
}
