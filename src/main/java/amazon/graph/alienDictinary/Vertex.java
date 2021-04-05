package amazon.graph.alienDictinary;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    Character id;
    List<Vertex> AdjacentVertexes;

    Vertex(Character id){
        this.id = id;
        AdjacentVertexes = new ArrayList<>();
    }

    public Character getId() {
        return id;
    }

    //return All Adjacent vertex
    public List<Vertex> getAdjVertices() {
        return AdjacentVertexes;
    }

    //Add All Adjacent V
    public void addAdjVertex(Vertex adjVer){
        AdjacentVertexes.add(adjVer);
    }
}
