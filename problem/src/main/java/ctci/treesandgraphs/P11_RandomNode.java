package ctci.treesandgraphs;

import java.util.Random;

public class P11_RandomNode {

    static class TreeNode {
        public TreeNode(int val) {
            this.value = val;
            this.size = 1;
        }

        TreeNode left;
        TreeNode right;
        int value;
        int size;

        TreeNode getRandomNode() {
            Random random = new Random();
            int randomIndex = random.nextInt(this.size);

            int leftSubtreeSize = left == null ? 0: left.size;
            if (randomIndex <  leftSubtreeSize) {
                return left.getRandomNode();
            } else if (randomIndex > leftSubtreeSize) {
                return right.getRandomNode();
            } else {
                return this;
            }
        }

        void insertInorder(int val) {
            if (val <= this.value) {
                if (left != null) {
                    left.insertInorder(val);
                } else {
                    this.left = new TreeNode(val);
                }
            } else {
                if (right != null) {
                    right.insertInorder(val);
                } else {
                    this.right = new TreeNode(val);
                }
            }
            size ++;
        }

        TreeNode find(int val) {
            if (val == this.value) {
                return this;
            } else if (val < this.value) {
                if (left != null) {
                    left.find(val);
                }
            } else {
                if (right != null) {
                    right.find(val);
                }
            }
            return null;
        }
    }
}
