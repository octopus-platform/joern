package graphutils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import misc.MultiHashMap;

public abstract class AbstractGraph<V, E extends Edge<V>>
{

	private List<V> vertices;
	private MultiHashMap<V, E> outNeighborhood;

	public AbstractGraph()
	{
		vertices = new LinkedList<V>();
		outNeighborhood = new MultiHashMap<V, E>();
	}

	public Iterator<V> iterator()
	{
		return getVertices().iterator();
	}

	public List<V> getVertices()
	{
		return vertices;
	}

	public List<E> getEdges()
	{
		List<E> edges = new LinkedList<E>();
		for (V vertex : getVertices())
		{
			for (E edge : outgoingEdges(vertex))
			{
				edges.add(edge);
			}
		}
		return edges;
	}

	public List<E> outgoingEdges(V src)
	{
		failIfNotContained(src);
		List<E> list = outNeighborhood.get(src);
		return list != null ? list : new LinkedList<E>();
	}

	public boolean isConnected(V src, V dst)
	{
		for (Edge<V> e : outgoingEdges(src))
		{
			if (e.getDestination().equals(dst))
			{
				return true;
			}
		}
		return false;
	}

	public int outDegree(V vertex)
	{
		return outgoingEdges(vertex).size();
	}

	public boolean contains(V vertex)
	{
		return vertices.contains(vertex);
	}

	public boolean isEmpty()
	{
		return size() == 0;
	}

	public int size()
	{
		return vertices.size();
	}

	public int numberOfEdges()
	{
		return outNeighborhood.totalSize();
	}

	public boolean addVertex(V vertex)
	{
		if (!contains(vertex))
		{
			vertices.add(vertex);
			return true;
		}
		return false;
	}

	public void removeVertex(V vertex)
	{
		removeEdgesFrom(vertex);
		removeEdgesTo(vertex);
		vertices.remove(vertex);
	}

	public void addEdge(E edge)
	{
		failIfNotContained(edge.getSource());
		failIfNotContained(edge.getDestination());
		outNeighborhood.add(edge.getSource(), edge);
	}

	public void removeEdge(E edge)
	{
		removeEdge(edge.getSource(), edge.getDestination());
	}

	public void removeEdge(V src, V dst)
	{
		List<E> edges = outNeighborhood.get(src);
		Iterator<E> it = edges.iterator();
		E edge;
		while (it.hasNext())
		{
			edge = it.next();
			if (edge.getDestination() == dst)
			{
				it.remove();
			}
		}
	}

	public void removeEdgesFrom(V source)
	{
		outNeighborhood.removeAll(source);
	}

	public void removeEdgesTo(V destination)
	{
		Iterator<V> sourceIterator = outNeighborhood.getKeySetIterator();
		while (sourceIterator.hasNext())
		{
			V source = sourceIterator.next();
			Iterator<E> edgeIterator = outgoingEdges(source).iterator();
			while (edgeIterator.hasNext())
			{
				E edge = edgeIterator.next();
				if (edge.getDestination().equals(destination))
				{
					edgeIterator.remove();
				}
			}
		}
	}

	public void failIfNotContained(V vertex)
	{
		if (!contains(vertex))
		{
			throw new NoSuchElementException("Graph has no such vertex : "
					+ vertex);
		}
	}

	@Override
	public String toString()
	{
		String res = "Graph with " + size() + " vertices and "
				+ numberOfEdges() + " edges:\n";
		for (V vertex : getVertices())
		{
			res += vertex.toString() + '\n';
			for (E edge : outgoingEdges(vertex))
			{
				res += edge.toString() + '\n';
			}
		}
		return res;
	}

}
