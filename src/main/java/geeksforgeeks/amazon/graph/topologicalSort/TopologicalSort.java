package geeksforgeeks.amazon.graph.topologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        ArrayList<Integer> v0 = new ArrayList<>();
        ArrayList<Integer> v1 = new ArrayList<>();
        ArrayList<Integer> v2 = new ArrayList<>(Arrays.asList(3));
        ArrayList<Integer> v3 = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> v4 = new ArrayList<>(Arrays.asList(0,1));
        ArrayList<Integer> v5 = new ArrayList<>(Arrays.asList(2,0));

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(Arrays.asList(v0, v1, v2, v3,v4,v5));
        int [] result = topoSort(graph.size(), graph);
        Arrays.stream(result).forEach(r -> System.out.print(r + " "));
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < V) {
            if (!visited[i]) {
                topoSort_util(adj, i, visited, stack);
            }
            i++;
        }

        int [] result = new int[V];
        int j =0;
        while (j<V){
            result[j++] = stack.pop();
        }

        return result;
    }

    private static void topoSort_util(ArrayList<ArrayList<Integer>> vertex, int i, boolean[] visited, Stack<Integer> stack) {

        if(visited[i]){
            return;
        }

        visited[i] = true;
        for (int adjVertex : vertex.get(i)) {
           topoSort_util(vertex, adjVertex, visited, stack);
        }
        System.out.println(i);
        stack.push(i);
    }
}