package org.ls.util.Graph;

/**
 * Created by aludlow on 29/06/2015.
 */
public class BasicEdgeFactoryImpl<V, E extends Edge> implements EdgeFactory<V, E> {

    private final Class<? extends E> edgeClass;

    public BasicEdgeFactoryImpl(Class<? extends E> edgeClass) {
        this.edgeClass = edgeClass;
    }

    public Class getEdgeClass() {
        return edgeClass;
    }

    @Override
    public E createEdge(V source, V target) {
        try {
            E edge = this.edgeClass.newInstance();
            edge.addSourceVertex(source);
            edge.addTargetVertex(target);
            return edge;
        }
        catch(Exception e) {
            throw new RuntimeException("Edge creation failed", e);
        }
    }
}
