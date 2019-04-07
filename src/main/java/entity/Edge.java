package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Edge {

    private int destinationId;
    private double cost;

    public Edge(int destinationId) {
        this.destinationId = destinationId;
        this.cost = 0.0;
    }
}
