package amazon.graph.topologicalSort;


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

    public void addVetex (int data){
        Vertex v1 = new Vertex(data);
        allVertex.put(data,v1);
    }
}
