package ctci.treesandgraphs;

public class TreeNode {
    int val;
    int height;
    private TreeNode[] adjNodes;
    private boolean visited;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
    }

    public TreeNode(int val, TreeNode[] adjNodes) {
        this.val = val;
        this.adjNodes = adjNodes;
        this.visited = false;
    }

    public TreeNode[] getAdjNodes() {
        return adjNodes;
    }

    public void setVisited() {
        this.visited = true;
    }

    public boolean isVisited() {
        return visited;
    }
}