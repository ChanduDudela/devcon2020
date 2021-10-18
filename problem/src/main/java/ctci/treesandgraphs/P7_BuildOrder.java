package ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// topological sort order - CourseSchedule_TopologicalSort.java
public class P7_BuildOrder {

    public String[] buildOrder(String[] projects, String[][] dependencies) {
        Set<String> visitedSet = new HashSet<>();
        Stack<String> orderStack = new Stack<>();

        if ((dependencies == null || dependencies.length == 0) && projects.length > 0) {
            return new String[0];
        }

        //build adjacency list
        Map<String, List<String>> adjList = new HashMap<>();
        for (String[] dep: dependencies) {
            List<String> list = adjList.getOrDefault(dep[0], new ArrayList<>());
            list.add(dep[1]);
            adjList.put(dep[0], list);
        }

        for(String project: adjList.keySet()) {
            if (visitedSet.contains(project)) {
                continue;
            }
            processChildren(project, adjList, visitedSet, orderStack);
        }

        String[] order = new String[orderStack.size()];
        int i = 0;
        while(!orderStack.empty()){
            order[i] = orderStack.pop();
            i++;
        }

        return order;
    }

    void processChildren(
        String project, Map<String, List<String>> adjList, Set<String> visitedSet,
        Stack<String> orderStack) {

        visitedSet.add(project);

        if(adjList.containsKey(project)) {
            for(String dependent: adjList.get(project)) {
                if (!visitedSet.contains(dependent)) {
                    processChildren(dependent, adjList, visitedSet, orderStack);
                }
            }
        }

        orderStack.push(project);
    }
}
