package amazon.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    Character id;
    List<Vertex> adjVertices;

    Vertex(Character id){
        this.id = id;
        adjVertices = new ArrayList<>();
    }

    public Character getId() {
        return id;
    }

    public List<Vertex> getAdjVertices() {
        return adjVertices;
    }

    //Add All Adjucent V
    public void addAdjVertex(Vertex adjVer){
        adjVertices.add(adjVer);
    }
}
