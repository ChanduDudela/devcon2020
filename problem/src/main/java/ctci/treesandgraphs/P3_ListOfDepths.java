package ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P3_ListOfDepths {

    // BFS - https://www.youtube.com/watch?v=XZnWETlZZ14
    public List<List<TreeNode>> getLevelOrder(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                levelList.add(node);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }
}
