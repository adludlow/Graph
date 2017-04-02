package org.ls.util.Graph;

import java.util.Set;

/**
 * Created by aludlow on 18/06/2015.
 */
public interface Graph<V, E extends Edge> {
    public E addEdge(V source, V target) throws MissingVertexException;
    public void addEdge(V source, V target, E edge) throws MissingVertexException;

    public void addVertex(V vertex);

    public boolean containsEdge(V source, V target) throws MissingVertexException;

    public boolean containsVertex(V vertex);

    public Set<V> getVertexSet();

    public Set<E> edgesOf(V vertex) throws MissingVertexException;
}
