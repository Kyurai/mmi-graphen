package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Graph {

    //key: id of vertex, value: vertex with id
    private Map<Integer, Vertex> vertices;

    public Graph(){
        this.vertices = new HashMap<>();
    }

    public int countVertices() {
        return vertices.size();
    }

    /**
     * Adds new vertex to list of vertices,
     * if vertex doesn't already exist for the given id
     * @param id of vertex to add
     */
    public void addVertex(int id) {

//        if (!vertices.containsKey(id)) {
//            vertices.put(id, new Vertex(id));
//        } else {
//            System.out.println("Error: Vertex with id: " + id + " already exists!");
//        }
        vertices.put(id, new Vertex(id));
    }

    /**
     * Searches for vertex with given id
     *
     * @param id of vertex
     * @return Vertex for given id,
     * if vertex with given id doesn't exist null is returned
     */
    public Vertex getVertex(int id) {
        return vertices.get(id);
    }
}
