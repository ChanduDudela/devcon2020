package aws.onlineassesment;

import java.util.Arrays;

public class MinSpanningTreeKruskalsAlgorithm {

    int[] parent; // represents values of parent node id for each node id (index)
    int sets; // represents the number of dis-joint sets


    public void unionSets(int node1, int node2) {
        int set1 = findSet(node1);
        int set2 = findSet(node2);

        if(set1 != set2){
            parent[set1] = set2;

            // decrement the number of sets
            sets--;
        }
    }


    public int findSet(int node) {

        if(parent[node] == node) {
            return parent[node];
        }

        parent[node] = findSet(parent[node]); //path compression

        return parent[node];
    }


    public int minimumCost(int numOfNodes, int[][] connections) {
        sets = numOfNodes;
        parent = new int[numOfNodes+1];

        //initialize. Each node's parent is itself
        for(int i=0; i<= numOfNodes; i++){
            parent[i] = i;
        }

        //sort edges by weight in ascending order
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

        int minCost = 0;

        for(int[] connection: connections) {
            int setNode1BelongsTo = findSet(connection[0]);
            int setNode2BelongsTo = findSet(connection[1]);

            if(setNode1BelongsTo != setNode2BelongsTo) {
                minCost= minCost + connection[2];

                unionSets(connection[0], connection[1]);
            }
        }

        return sets == 1 ? minCost: -1;
    }
}
