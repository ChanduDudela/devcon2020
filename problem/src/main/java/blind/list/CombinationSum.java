package blind.list;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), result, candidates, 0, target);
        return result;
    }

    private void backtrack(
        List<Integer> tempList, List<List<Integer>> result, int[] candidates, int startIndex,
        int target) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(tempList);
        }

        for (int i = startIndex; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(tempList, result, candidates, startIndex, target - candidates[i]);
            tempList.remove(tempList.size()-1);
        }
    }
}
