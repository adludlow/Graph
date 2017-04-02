package org.ls.util.Graph;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by aludlow on 18/06/2015.
 */
public class AdjacencyMatrixGraphImpl<V, E extends Edge> implements Graph<V, E> {

    private EdgeFactory<V, E> edgeFactory;
    private E[][] adjacencyMatrix;
    private Set<V> vertexSet;
    private Map<V, Integer> vertexLookup;
    private Integer vertexCount;
    private Integer currentVertexCount = 0;

    public AdjacencyMatrixGraphImpl(
            EdgeFactory<V, E> ef,
            Integer vertexCount) {
        if(ef == null)
            throw new NullPointerException();

        edgeFactory = ef;
        this.vertexCount = vertexCount;
        vertexSet = new HashSet<V>();
        vertexLookup = new HashMap<V, Integer>();

        adjacencyMatrix = (E[][])Array.newInstance(ef.getEdgeClass(), vertexCount, vertexCount);
    }

    public int getVertexCount() {
        return vertexCount;
    }

    @Override
    public E addEdge(V source, V target) throws MissingVertexException{
        E edge;
        if(containsVertex(source)) {
            if(containsVertex(target)) {
                edge = edgeFactory.createEdge(source, target);
                Integer sourceIndex = vertexLookup.get(source);
                Integer targetIndex = vertexLookup.get(target);
                adjacencyMatrix[sourceIndex][targetIndex] = edge;
                adjacencyMatrix[targetIndex][sourceIndex] = edge;
            }
            else{
                throw new MissingVertexException("Target vertex has not been added.");
            }
        }
        else {
            throw new MissingVertexException("Target vertex has not been added.");
        }
        return edge;
    }

    @Override
    public void addEdge(V source, V target, E edge) throws MissingVertexException{
        if(containsVertex(source)) {
            if(containsVertex(target)) {
                Integer sourceIndex = vertexLookup.get(source);
                Integer targetIndex = vertexLookup.get(target);
                adjacencyMatrix[sourceIndex][targetIndex] = edge;
                adjacencyMatrix[targetIndex][sourceIndex] = edge;
            }
            else{
                throw new MissingVertexException("Target vertex has not been added.");
            }
        }
        else {
            throw new MissingVertexException("Target vertex has not been added.");
        }
    }

    @Override
    public void addVertex(V vertex) {
        vertexSet.add(vertex);
        vertexLookup.put(vertex, currentVertexCount);
        incrementCurrentVertexCount();
    }

    @Override
    public boolean containsEdge(V source, V target)  throws MissingVertexException{
        if(containsVertex(source) && containsVertex(target)) {
            Integer sourceId = vertexLookup.get(source);
            Integer targetId = vertexLookup.get(target);

            if(adjacencyMatrix[sourceId][targetId] != null || adjacencyMatrix[targetId][sourceId] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsVertex(V vertex) {
        if(vertexSet.contains(vertex)) {
            return true;
        }
        return false;
    }

    @Override
    public Set<V> getVertexSet() {
        return vertexSet;
    }

    @Override
    public Set<E> edgesOf(V vertex)  throws MissingVertexException{
        Set<E> edges = null;
        if(vertexSet.contains(vertex)) {
            edges = new HashSet<E>();
            Integer vertexId = vertexLookup.get(vertex);
            for(int i = 0; i < getVertexCount(); i++) {
                E e = adjacencyMatrix[vertexId][i];
                if(e != null) {
                    edges.add(e);
                }
            }
            if(edges.size() > 0) {
                return edges;
            }
        }
        else
            throw new MissingVertexException("Vertex not found");

        return edges;
    }

    private void incrementCurrentVertexCount() {
        currentVertexCount++;
    }
}
