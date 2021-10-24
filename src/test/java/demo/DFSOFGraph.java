package demo;

import java.util.ArrayList;
import java.util.Arrays;

public class DFSOFGraph {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> V0 = new ArrayList<>(Arrays.asList(1, 2, 4));
        ArrayList<Integer> V1 = new ArrayList<>(Arrays.asList(0));
        ArrayList<Integer> V2 = new ArrayList<>(Arrays.asList(0));
        ArrayList<Integer> V3 = new ArrayList<>(Arrays.asList(4));
        ArrayList<Integer> V4 = new ArrayList<>(Arrays.asList(0, 3));

        graph.add(V0);
        graph.add(V1);
        graph.add(V2);
        graph.add(V3);
        graph.add(V4);

        //Example 2
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
        graph1.add(new ArrayList<>(Arrays.asList(1, 3)));
        graph1.add(new ArrayList<>(Arrays.asList(0, 2)));
        graph1.add(new ArrayList<>(Arrays.asList(1)));
        graph1.add(new ArrayList<>(Arrays.asList(0)));

        ArrayList<Integer> integers = dfsOfGraph(0, graph);
        System.out.println(integers);
    }

    // Function to return a list containing the DFS traversal of the graph.
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isTraversed = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();
        adjacentTraversal(0, adj, isTraversed, result);
        return result;
    }

    private static void adjacentTraversal(int vertex, ArrayList<ArrayList<Integer>> adjVertices, boolean[] isTraversred, ArrayList<Integer> result) {
        if (isTraversred[vertex]) {
            return;
        }
        isTraversred[vertex] = true;
        result.add(vertex);
        for(int v : adjVertices.get(vertex)){
            adjacentTraversal(v, adjVertices, isTraversred, result);
        }
    }
}
