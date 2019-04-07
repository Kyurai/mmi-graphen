package entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VertexTest {

    @Test
    public void test_countEdges_withLoop() {
        //given
        Vertex vertex = new Vertex(1);

        Edge loopingEdge = new Edge(1);
        vertex.addEdge(loopingEdge);
        Edge edge = new Edge(2);
        vertex.addEdge(edge);

        //when
        int result = vertex.countEdges();

        //then
        assertEquals(3, result);
    }

    @Test
    public void test_countEdges(){
        //given
        Vertex vertex = new Vertex(1);

        Edge edge1 = new Edge(2);
        vertex.addEdge(edge1);
        Edge edge2 = new Edge(3);
        vertex.addEdge(edge2);
        Edge edge3 = new Edge(4);
        vertex.addEdge(edge3);

        //when
        int result = vertex.countEdges();

        //then
        assertEquals(3, result);
    }


}