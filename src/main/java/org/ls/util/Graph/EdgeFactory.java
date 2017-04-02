package org.ls.util.Graph;

/**
 * Created by aludlow on 29/06/2015.
 */
public interface EdgeFactory<V, E extends Edge> {

    public E createEdge(V source, V target);

    public Class getEdgeClass();
}
