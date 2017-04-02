package org.ls.util.Graph;

/**
 * Created by aludlow on 29/06/2015.
 */
public interface Edge<V> {

    public void addSourceVertex(V v);
    public void addTargetVertex(V v);
    public V getSourceVertex();
    public V getTargetVertex();

}
