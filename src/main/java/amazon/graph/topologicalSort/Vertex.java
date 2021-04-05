package amazon.graph.topologicalSort;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private Integer data;
    private List<Vertex> av = null;

    Vertex(Integer data) {
        this.data = data;
        av = new ArrayList<>();
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public List<Vertex> getList() {
        return av;
    }

    public void setList(List<Vertex> list) {
        this.av = av;
    }
}
