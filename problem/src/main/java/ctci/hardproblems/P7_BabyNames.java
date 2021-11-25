package ctci.hardproblems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class P7_BabyNames {
    static class Graph {
        Map<String, GraphNode> graphNodes;

        public Graph() {
            this.graphNodes = new HashMap<>();
        }

        GraphNode createNode(String name, Integer frequency) {
            GraphNode node = new GraphNode(name, frequency);
            graphNodes.put(name, node);
            return node;
        }

        void addEdge(String name1, String name2) {
            graphNodes.get(name1).getNeighbours().add(graphNodes.get(name2));
        }
    }

    static class GraphNode {
        boolean isVisited;
        List<GraphNode> neighbours;
        String name;
        int frequency;

        public GraphNode(String name, int frequency) {
            this.name = name;
            this.frequency = frequency;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        public List<GraphNode> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<GraphNode> neighbours) {
            this.neighbours = neighbours;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }

    HashMap<String, Integer> reconcileNames(HashMap<String, Integer> names, String[][] synonyms) {
        // construct graph
        Graph graph = constructGraph(names);

        // associate edges (neighbours)
        connectNeighbours(graph, synonyms);

        // Reconcile based on associated neighbours
        return reconcile(graph);
    }

    Graph constructGraph(HashMap<String, Integer> names) {
        Graph graph = new Graph();
        for (Entry<String, Integer> name : names.entrySet()) {
            GraphNode node = new GraphNode(name.getKey(), name.getValue());
            graph.graphNodes.put(node.name, node);
        }
        return graph;
    }

    void connectNeighbours(Graph graph, String[][] synonyms) {
        for (String[] synonym : synonyms) {
            String first = synonym[0];
            String second = synonym[1];

            graph.addEdge(first, second);
        }
    }

    HashMap<String, Integer> reconcile(Graph graph) {
        HashMap<String, Integer> result = new HashMap<>();

        for (Entry<String, GraphNode> nodeEntry : graph.graphNodes.entrySet()) {
            if (!nodeEntry.getValue().isVisited()) {
                int frequency = getFrequencyFromNeighbours(nodeEntry.getValue());
                result.put(nodeEntry.getKey(), frequency);
            }
        }
        return result;
    }

    int getFrequencyFromNeighbours(GraphNode visitingNode) {
        if (visitingNode.isVisited()) {
            return 0;
        }

        visitingNode.setVisited(true);
        int frequency = visitingNode.getFrequency();

        for (GraphNode neighbour : visitingNode.getNeighbours()) {
            frequency += getFrequencyFromNeighbours(neighbour);
        }

        return frequency;
    }
}
