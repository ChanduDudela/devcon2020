package ctci.treesandgraphs;

// https://youtu.be/5cPbNCrdotA?t=242
public class P6_Successor {

    TreeNode findSuccessor(TreeNode node) {
        if (node == null) return null;

        // If there is right subtree, left most node of the right subtree is the successor
        if (node.right != null) {
            return findLeftMostNode(node.right);
        } else {
            // left sub tree is already covered and right sub tree doesn't exist,
            // so, successor would be the ancestor for which this current node is left child.
            while (node.parent != null && node.parent.left != node) {
                node = node.parent;
                node.parent = node.parent.parent;
            }
            return node.parent;
        }
    }

    TreeNode findLeftMostNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
