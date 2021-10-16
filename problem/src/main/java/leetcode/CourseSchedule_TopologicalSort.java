package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseSchedule_TopologicalSort {

    //Using Node InDegree approach
    public int[] findOrder_Using_Node_InDegree(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            adjListMap.put(i, new ArrayList<>());
        }

        for(int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            adjListMap.get(from).add(to);

            inDegree.put(to, inDegree.get(to) +1);
        }

        int[] resultArr = new int[numCourses];
        int idx = 0;

        Queue<Integer> zeroInDegreeQue = new LinkedList<>();
        for(int node : inDegree.keySet()){
            if(inDegree.get(node) == 0){
                zeroInDegreeQue.offer(node);
                resultArr[idx] = node;
                idx++;
            }
        }

        while(!zeroInDegreeQue.isEmpty()){
            int parent = zeroInDegreeQue.poll();

            List<Integer> children = adjListMap.get(parent);
            for(int child: children){
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child) == 0){
                    zeroInDegreeQue.offer(child);
                    resultArr[idx] = child;
                    idx++;
                }
            }
        }
        return idx == numCourses ? resultArr: new int[0];
    }


    // This approach is using Tushar Roy's explanation
    // to sort the graph nodes in topological order.
    // Below solution works if input has no cyclic graphs.
    Map<Integer, List<Integer>> adjListMap;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> orderedStack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        //If invalid input, just return an array with numbers 0 to numCourses
        if (prerequisites.length == 0 && numCourses >= 0) {
            int[] resultArr = new int[numCourses];

            for (int i = 0; i < resultArr.length; i++) {
                resultArr[i] = i;
            }
            return resultArr;
        }

        adjListMap = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            //directed graphs
            List<Integer> list = adjListMap.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);

            adjListMap.put(prerequisite[1], list);
        }

        for (int parentVertex : adjListMap.keySet()) {
            if (visited.contains(parentVertex)) {
                continue;
            }
            processChildren(parentVertex, orderedStack, visited);
        }

        int[] resultArr = new int[orderedStack.size()];

        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = orderedStack.pop();
        }

        return resultArr;
    }

    private void processChildren(int parent, Stack<Integer> orderedStack, Set<Integer> visited) {

        visited.add(parent);

        if (adjListMap.containsKey(parent)) {
            for (int child : adjListMap.get(parent)) {
                if (visited.contains(child)) {
                    continue;
                }

                processChildren(child, orderedStack, visited);
            }
        }
        orderedStack.push(parent);
    }
}
