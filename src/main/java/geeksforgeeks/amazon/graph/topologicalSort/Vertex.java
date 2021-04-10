package geeksforgeeks.amazon.graph.topologicalSort;

import java.util.ArrayList;
import java.util.List;


public class Vertex {
    private Integer id;
    private List<Vertex>  adjacentVertex= null;

    Vertex(Integer data) {
        this.id = data;
        adjacentVertex = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vertex> getAdjacentVertex() {
        return adjacentVertex;
    }

    public void setAdjacentVertex(List<Vertex> adjacentVertex) {
        this.adjacentVertex = adjacentVertex;
    }
}
