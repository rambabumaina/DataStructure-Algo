package amazon.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<Character, Vertex> allVertex;
    List<Edge> allEdges;

    public Graph() {
        this.allVertex = new HashMap<>();
        this.allEdges = new ArrayList<>();
    }

    public Map<Character, Vertex> getAllVertex() {
        return allVertex;
    }

    public void setAllVertex(Map<Character, Vertex> allVertex) {
        this.allVertex = allVertex;
    }

    public List<Edge> getAllEdges() {
        return allEdges;
    }

    public void setAllEdges(List<Edge> allEdges) {
        this.allEdges = allEdges;
    }


    //Add Vertex
    public void addVertex(Character id){
        Vertex v = new Vertex(id);
        allVertex.put(id, v);
    }

    //Add Edges
    public void addEdge(Character v1, Character v2){
        Vertex vertex1 = null;
        Vertex vertex2 = null;

        if(!allVertex.containsKey(v1)){
            addVertex(v1);
        }
        vertex1 = allVertex.get(v1);

        if(!allVertex.containsKey(v2)){
            addVertex(v2);
        }

        vertex2 = allVertex.get(v2);

        vertex1.addAdjVertex(vertex2);

        allEdges.add(new Edge(vertex1, vertex2));
    }
}
