package org.ls.util.Graph.test;

import org.ls.util.Graph.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by aludlow on 30/06/2015.
 */
public class GraphTest {

    private EdgeFactory ef;
    private Graph<Integer, BasicEdge> g;

    @Before
    public void init() {
        this.ef = new BasicEdgeFactoryImpl(BasicEdge.class);

        this.g = new AdjacencyMatrixGraphImpl<Integer, BasicEdge>(ef, 5);
    }

    @Test
    public void testAdjacencyMatrixGraph() {
        try {
            for (int i = 1; i <= 5; i++) {
                g.addVertex(new Integer(i));
            }

            g.addEdge(1, 5);
            g.addEdge(4, 5);

            assertTrue(g.containsVertex(new Integer(1)));

        }
        catch(MissingVertexException e) {
            e.printStackTrace();
        }
    }
}
