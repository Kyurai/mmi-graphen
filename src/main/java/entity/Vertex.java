package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Vertex {

    @NonNull
    private int id;
    private List<Edge> edges;

    public Vertex(int id) {
        this.id = id;
        edges = new ArrayList<>();
    }

    /**
     * Adds an edge to the edges map, if it doesn't exist yet
     *
     * @param edge contains the id of the destination vertex and cost
     * @return true, if adding was successfull,
     * false, if edge already exists
     */
    public boolean addEdge(Edge edge) {
        return this.edges.add(edge);
    }

    /**
     * Returns number of edges
     * If there's a looping edge, it counts as 2 edges
     *
     * @return number of edges
     */
    public int countEdges() {
        return this.edges.size();
    }
}
