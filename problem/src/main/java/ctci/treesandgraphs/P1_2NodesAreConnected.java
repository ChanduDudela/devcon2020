package ctci.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class P1_2NodesAreConnected {

    //BFS
    public boolean areNodesConnected(Graph gr, TreeNode source, TreeNode destination) {
        if (source == destination) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        source.setVisited();
        queue.offer(source);

        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();

            for (TreeNode adjNode : n.getAdjNodes()) {
                if (!adjNode.isVisited()) {
                    if (adjNode == destination) {
                        return true;
                    }
                    adjNode.setVisited();
                    queue.offer(adjNode);
                }
            }
        }
        return false;
    }
}


class Graph {
    TreeNode[] nodes;

    public Graph(TreeNode[] nodes) {
        this.nodes = nodes;
    }

    public TreeNode[] getNodes() {
        return nodes;
    }
}
