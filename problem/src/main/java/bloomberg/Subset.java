package bloomberg;

import java.util.ArrayList;
import java.util.List;

public class Subset {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		return backtracking(result, new ArrayList<>(), nums, 0);
	}

	private List<List<Integer>> backtracking(
		List<List<Integer>> result, List<Integer> tempResult, int[] nums, int start) {

		result.add(new ArrayList<>(tempResult));
		for (int i = start; i < nums.length; i++) {
			tempResult.add(nums[i]);
			backtracking(result, tempResult, nums, i+1);
			tempResult.remove(tempResult.size() -1 );
		}

		return result;
	}
}
