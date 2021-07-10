package geeksforgeeks.mustdo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1#
public class DFSofGraph {
    public static void main(String[] args) {
        ArrayList<Integer> v0 = new ArrayList<>(Arrays.asList(1, 2, 4));
        ArrayList<Integer> v1 = new ArrayList<>(0);
        ArrayList<Integer> v2 = new ArrayList<>(0);
        ArrayList<Integer> v3 = new ArrayList<>(4);
        ArrayList<Integer> v4 = new ArrayList<>(Arrays.asList(0,3));
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(Arrays.asList(v0,v1,v2,v3,v4));

        DFSofGraph dfs = new DFSofGraph();
        ArrayList<Integer> list = dfs.dfsOfGraph(graph.size(), graph);
        Stream.of(list).forEach(t -> System.out.print(t));
    }


    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        dfsOfGraphUtil(adj, 0, visited, result);
        return result;
    }


    public void dfsOfGraphUtil(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] visited, List<Integer> result) {
        //Check If Vertex Visited
        if (visited[vertex]) {
            return;
        }

        //Mark Vertex Visited
        visited[vertex] = true;

        //Add Visited vertex to the result
        result.add(vertex);

        // get all adjacent vertex of the current vertex
        List<Integer> adjVertices = adj.get(vertex);
        for (int adjVertex : adjVertices) {
            dfsOfGraphUtil(adj, adjVertex, visited, result);
        }
    }
}
