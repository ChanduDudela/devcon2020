package aws.onlineassesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/discuss/interview-question/436073/
//https://leetcode.com/problems/critical-connections-in-a-network/
public class CriticalConnections_TarjansAlgorithm {

    private int time = 0;                       //discovery time

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n]; // Adjacency List
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();       // [ [ ], [ ], [ ],.....,size n [  ] ]
        }

        //construct adjacency list with given input connections
        for (List<Integer> pair : connections) {
            int x = pair.get(0);
            int y = pair.get(1);
            graph[x].add(y);
            graph[y].add(x);
        }

        int[] discoveryTimeList = new int[n];   // discovery time of each node
        int[] lowKeyList = new int[n];          // to maintain lowest key of the node reachable from this node in DFS

        boolean[] visitedList = new boolean[n];     // maintain visited flag for each node
        List<List<Integer>> output = new ArrayList<>();

        dfs(0, -1, discoveryTimeList, lowKeyList, visitedList, graph, output);

        return output;
    }

    public void dfs(
        int rootNode, int parent, int[] discoveryTimeList, int[] lowKeyList, boolean[] visitedList,
        List<Integer>[] graph, List<List<Integer>> output) {

        visitedList[rootNode] = true;
        discoveryTimeList[rootNode] = ++time;
        lowKeyList[rootNode] = discoveryTimeList[rootNode]; // initially low key for a node will be its discovery time

        for (int adjacentNode : graph[rootNode]) { // For this node, loop through its adjacent nodes
            if (adjacentNode == parent) {        // if this node adj node is not parent
                continue;
            }

            if (!visitedList[adjacentNode]) {    // and it is not already visited
                // apply dfs recursively
                dfs(adjacentNode, rootNode, discoveryTimeList, lowKeyList, visitedList, graph,
                    output);

                lowKeyList[rootNode] = Math.min(lowKeyList[rootNode], lowKeyList[adjacentNode]);

                // Tarjan's algorithm = (if id/discovery time of the source node < low key of the target node (adjacent node)
                if (discoveryTimeList[rootNode] < lowKeyList[adjacentNode]) {
                    output.add(Arrays.asList(rootNode, adjacentNode));
                }
            } else {
                lowKeyList[rootNode] =
                    Math.min(lowKeyList[rootNode], discoveryTimeList[adjacentNode]);
            }
        }
    }
}
