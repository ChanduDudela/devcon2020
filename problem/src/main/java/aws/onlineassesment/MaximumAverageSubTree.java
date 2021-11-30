package aws.onlineassesment;
import aws.onlineassesment.SubTreeOfAnotherTree.TreeNode;

//https://leetcode.com/problems/maximum-average-subtree/submissions/
public class MaximumAverageSubTree {

    double rootWithMaxAvg = Integer.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        getAverageWeight(root);
        return rootWithMaxAvg;
    }

    private int[] getAverageWeight(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }

        //recursively call left and right child nodes
        int[] left = getAverageWeight(root.left);
        int[] right = getAverageWeight(root.right);

        //maintain sum of the vals in 0th index and number of child nodes in the 1st index
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        //At each node, calculate the average of sum and count and compare with member variable rootWithMaxAvg
        //At the end of iteration, rootWithMaxAvg will have the max average value
        rootWithMaxAvg = Math.max( 1.0 * sum / count, rootWithMaxAvg);

        return new int[]{sum, count};
    }
}
