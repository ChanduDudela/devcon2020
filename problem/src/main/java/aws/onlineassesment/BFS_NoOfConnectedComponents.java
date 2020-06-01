package aws.onlineassesment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
}
