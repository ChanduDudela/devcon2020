package ctci.treesandgraphs;

public class P12_PathSum {

    // Brute Force - O (N Log N)
    int findPathsWithGivenSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int countFromRoot = findPathsWithGivenSumFromRoot(root, 0, targetSum);
        int countFromRootLeft = findPathsWithGivenSum(root.left, targetSum);
        int countFromRootRight = findPathsWithGivenSum(root.right, targetSum);

        return countFromRoot + countFromRootRight + countFromRootLeft;
    }

    int findPathsWithGivenSumFromRoot(TreeNode root, int balanceSum, int targetSum) {
        if (root == null) {
            return 0;
        }

        int totalPaths = 0;
        balanceSum += root.val;
        if (balanceSum == targetSum) {
            totalPaths++;
        }

        totalPaths += findPathsWithGivenSumFromRoot(root.left, balanceSum, targetSum);
        totalPaths += findPathsWithGivenSumFromRoot(root.right, balanceSum, targetSum);

        return totalPaths;
    }
}
