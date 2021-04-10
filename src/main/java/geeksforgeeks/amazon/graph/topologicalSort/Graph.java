package geeksforgeeks.amazon.graph.topologicalSort;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Integer, Vertex> allVertex;
    private List<Edge> allEdges;

    Graph() {
        allVertex = new HashMap<>();
        allEdges = new ArrayList<>();
    }

    public Map<Integer, Vertex> getAllVertex() {
        return allVertex;
    }

    public void setAllVertex(Map<Integer, Vertex> allVertex) {
        this.allVertex = allVertex;
    }

    public List<Edge> getEdgeList() {
        return allEdges;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.allEdges = edgeList;
    }


    //add vertex to the map
    public void addVetex(Vertex vertex) {
        allVertex.put(vertex.getId(), vertex);
    }

    public void addEdges(int id1, int id2) {
        Vertex v1;
        Vertex v2;

        //check if vertex1 exists in the all vertex map, if not then create a new vertex and
        // add to the all vertex map
        if (!allVertex.containsKey(id1)) {
            v1 = new Vertex(id1);
            addVetex(v1);
        } else {
            v1 = allVertex.get(id1);
        }

        if (!allVertex.containsKey(id2)) {
            v2 = new Vertex(id2);
            addVetex(v2);
        } else {
            v2 = allVertex.get(id2);
        }

        Edge e = new Edge(v1, v2);
        allEdges.add(e);
    }
}
