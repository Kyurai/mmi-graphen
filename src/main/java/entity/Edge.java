package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Edge {

    private Vertex originId;
    private Vertex destinationId;
    private double cost;

    public Edge(Vertex originId, Vertex destinationId) {
        this.originId = originId;
        this.destinationId = destinationId;
        this.cost = 0.0;
    }
}
