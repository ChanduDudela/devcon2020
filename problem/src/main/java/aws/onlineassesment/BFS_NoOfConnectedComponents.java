package aws.onlineassesment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS_NoOfConnectedComponents {

    public int countComponents(int n, int[][] edges) {

        List<Integer>[] adjacencyArray = new List[n];

        for (int i = 0; i < n; i++) {
            adjacencyArray[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjacencyArray[edge[0]].add(edge[1]);
            adjacencyArray[edge[1]].add(edge[0]);
        }

        int components = 0;
        Queue<Integer> nodesQ = new LinkedList<>();
        boolean[] visitedNodes = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!visitedNodes[i]) {
                ++components;

                visitedNodes[i] = true;
                nodesQ.offer(i);
            }

            while (!nodesQ.isEmpty()) {
                int curr = nodesQ.poll();

                for (int neighbour : adjacencyArray[curr]) {
                    if (!visitedNodes[neighbour]) {
                        visitedNodes[neighbour] = true;
                        nodesQ.offer(neighbour);
                    }
                }
            }
        }

        return components;
    }

    // DFS
    public int countComponents_DFS(int n, int[][] edges) {
        if (n == 0) {
            return 0;
        } else if (edges == null || edges.length == 0) {
            return n;
        }

        int result = 0;
        Map<Integer, List<Integer>> graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];

        // dfs(graph, visited, i), and count result
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                result++;
            }
        }

        return result;
    }

    // build graph in form of adjacent list
    private Map<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    // dfs: mark visited nodes, and keep dfs into children nodes
    private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j : graph.get(i)) {
            dfs(graph, visited, j);
        }
    }
}
