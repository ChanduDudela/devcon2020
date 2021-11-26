package leetcode;

// Reusing TreeNode class from BinaryTreePathSumToLeafNode
import static leetcode.BinaryTreePathSumToLeafNode.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    private StringBuilder serializeHelper(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("#");
            return sb;
        }

        sb.append(root.val).append(",");
        serializeHelper(sb, root.left).append(",");
        serializeHelper(sb, root.right);

        return sb;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(new StringBuilder(), root).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] dataArr = data.split(",");

        Queue<String> que = new LinkedList<>(Arrays.asList(dataArr));

        return deserializeHelper(que);
    }

    private TreeNode deserializeHelper(Queue<String> que){

        String val = que.poll();

        if(val.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left= deserializeHelper(que);
        node.right= deserializeHelper(que);

        return node;
    }
}
