package cdg;

import java.util.List;
import java.util.Set;

public interface Graph<V> extends Iterable<V> {

    public Set<V> getVertices();


    public List<V> outNeighborhood(V vertex);


    public List<V> inNeighborhood(V vertex);


    public int inDegree(V vertex);


    public int outDegree(V vertex);


    public boolean contains(V vertex);

}
