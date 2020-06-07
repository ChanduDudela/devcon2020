package aws.onlineassesment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/clone-graph/
public class DeepCloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> que = new LinkedList<>();
        que.add(node);

        Map<Node, Node> cloneMap = new HashMap<>();
        cloneMap.put(node, new Node(node.val));

        while (!que.isEmpty()) {

            Node currNode = que.poll();

            for (Node neighborNode : currNode.neighbors) {
                if (!cloneMap.containsKey(neighborNode)) {
                    Node clonedNeighborNode = new Node(neighborNode.val);
                    cloneMap.put(neighborNode, clonedNeighborNode);

                    que.offer(neighborNode);
                }

                cloneMap.get(currNode).neighbors.add(cloneMap.get(neighborNode));
            }
        }

        return cloneMap.get(node);
    }
}
