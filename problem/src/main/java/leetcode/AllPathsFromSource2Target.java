package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/all-paths-from-source-to-target/
public class AllPathsFromSource2Target {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);

        int target = graph.length - 1;

        dfs(0, target, path, res, graph);
        return res;
    }

    public void dfs(
        int currNode, int target, LinkedList<Integer> path, List<List<Integer>> res,
        int[][] graph) {
        if (currNode == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int neighbour : graph[currNode]) {
            path.addLast(neighbour);
            dfs(neighbour, target, path, res, graph);
            path.removeLast();
        }
    }
}
