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


    public int minimumCost(int N, int[][] connections) {
        sets = N;
        parent = new int[N+1];

        for(int i=0; i<= N; i++){
            parent[i] = i;
        }

        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

        int minCost = 0;

        for(int[] connection: connections) {
            if(findSet(connection[0]) != findSet(connection[1])) {
                minCost= minCost + connection[2];

                unionSets(connection[0], connection[1]);
            }
        }

        return sets == 1 ? minCost: -1;
    }
}
