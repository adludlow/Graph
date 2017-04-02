package org.ls.util.Graph;

/**
 * Created by aludlow on 30/06/2015.
 */
public class BasicEdge<V> implements Edge<V> {

    private V sourceVertex;
    private V targetVertex;

    @Override
    public void addSourceVertex(V vertex) {
        this.sourceVertex = vertex;
    }

    @Override
    public void addTargetVertex(V vertex) {
        this.targetVertex = vertex;
    }

    @Override
    public V getSourceVertex() {
        return sourceVertex;
    }

    @Override
    public V getTargetVertex() {
        return targetVertex;
    }
}
