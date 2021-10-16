package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BfsAndDfsGraphTraversal {

    //Helper HashMap to maintain index of all nodes in the graph
    HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public void addNode(int id) {
        nodeLookup.put(id, new Node(id));
    }

    /**
     *  BFS algorithm to check a path exists between 2 nodes
     */
    public boolean hasPath_BFS_Graph(int source, int destination) {
        Node sourceNode = nodeLookup.get(source);
        Node destNode = nodeLookup.get(destination);

        HashSet<Integer> visitedMap = new HashSet<>();
        Queue<Node> nextToVisit = new LinkedList<>();

        nextToVisit.offer(sourceNode);

        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.poll();

            if (node == destNode) {
                return true;
            }
            if (visitedMap.contains(node.id)) {
                return false;
            }
            visitedMap.add(node.id);

            nextToVisit.addAll(node.adjNodesQ);
        }

        return false;
    }


    /**
     *  DFS algorithm to check a path exists between 2 nodes
     */
    public boolean DFS_Graph(int source, int destination) {
        HashSet<Integer> visitedMap = new HashSet<>();

        return hasPath_DFS_Graph(nodeLookup.get(source), nodeLookup.get(destination), visitedMap);
    }

    private boolean hasPath_DFS_Graph(Node source, Node destination, HashSet<Integer> visited) {
        if (source == destination) {
            return true;
        }
        if (visited.contains(source.id)) {
            return false;
        }
        visited.add(source.id);

        for (Node adjNode : source.adjNodesQ) {
            if (hasPath_DFS_Graph(adjNode, destination, visited)) {
                return true;
            }
        }
        return false;
    }


    // Node class with an id and list of its adjacent nodes
    public static class Node {
        int id;
        Queue<Node> adjNodesQ = new LinkedList<>(); //adjacency list

        public Node(int id) {
            this.id = id;
        }
    }
}
