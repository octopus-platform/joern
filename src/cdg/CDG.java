package cdg;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import misc.MultiHashMap;

public class CDG<V> implements Graph<V> {

    private DominatorTree<V> dominatorTree;
    private Set<V> vertices;
    private MultiHashMap<V, V> controlEdges;


    private CDG() {
	vertices = new HashSet<V>();
	controlEdges = new MultiHashMap<V, V>();
    }


    public DominatorTree<V> getDominatorTree() {
	return this.dominatorTree;
    }


    @Override
    public Set<V> getVertices() {
	return Collections.unmodifiableSet(vertices);
    }


    @Override
    public List<V> outNeighborhood(V vertex) {
	if (!contains(vertex)) {
	    throw new IllegalArgumentException("Graph has no such vertex " + vertex);
	}
	return Collections.unmodifiableList(controlEdges.get(vertex));
    }


    @Override
    public List<V> inNeighborhood(V vertex) {
	if (!contains(vertex)) {
	    throw new IllegalArgumentException("Graph has no such vertex " + vertex);
	}
	throw new UnsupportedOperationException();

    }


    @Override
    public int inDegree(V vertex) {
	if (!contains(vertex)) {
	    throw new IllegalArgumentException("Graph has no such vertex " + vertex);
	}
	throw new UnsupportedOperationException();

    }


    @Override
    public int outDegree(V vertex) {
	if (!contains(vertex)) {
	    throw new IllegalArgumentException("Graph has no such vertex " + vertex);
	}
	return controlEdges.containsKey(vertex) ? controlEdges.get(vertex).size() : 0;
    }


    @Override
    public Iterator<V> iterator() {
	return getVertices().iterator();
    }


    public static <V> CDG<V> newInstance(DominatorTree<V> dominatorTree) {
	CDG<V> cdg = new CDG<V>();
	cdg.dominatorTree = dominatorTree;
	for (V vertex : dominatorTree) {
	    Set<V> frontier = dominatorTree.dominanceFrontier(vertex);
	    if (frontier != null) {
		cdg.addVertex(vertex);
		for (V f : frontier) {
		    cdg.addVertex(f);
		    cdg.linkVertices(f, vertex);
		}
	    }
	}
	return cdg;
    }


    private boolean addVertex(V vertex) {
	if (!contains(vertex)) {
	    vertices.add(vertex);
	    return true;
	}
	return false;
    }


    private boolean linkVertices(V vertex1, V vertex2) {
	boolean changed = false;
	if (vertices.contains(vertex1) && vertices.contains(vertex2)) {
	    controlEdges.add(vertex1, vertex2);
	    changed = true;
	}
	return changed;
    }


    @Override
    public boolean contains(V vertex) {
	return vertices.contains(vertex);
    }

}
