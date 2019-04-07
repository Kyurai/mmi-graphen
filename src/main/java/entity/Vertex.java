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
//        if (!this.edges.contains(edge)) {
//            return this.edges.add(edge);
//        }
//        return false;
        return this.edges.add(edge);
    }

    /**
     * Removes an edge from the edges list
     *
     * @param edge contains the id of the destination vertex
     * @return true, if removing was successfull,
     * false, if removing was not successfull
     */
    public boolean removeEdge(Edge edge) {
        return this.edges.remove(edge);
    }

    public boolean removeEdge(int id) {
        Edge e = new Edge(id);
        return removeEdge(e);
    }

    /**
     * Returns number of edges
     * If there's a looping edge, it counts as 2 edges
     *
     * @return number of edges
     */
    public int countEdges() {
        int numberEdges = this.edges.size();
//        for (Edge e : edges) {
//            if (e.getDestinationId() == id) {
//                numberEdges++;
//                break;
//            }
//        }
        return numberEdges;
    }
}
