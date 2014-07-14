package graphutils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import misc.MultiHashMap;

public abstract class AbstractTwoWayGraph<V, E extends Edge<V>> extends
		AbstractGraph<V, E>
{
	private MultiHashMap<V, E> inNeighborhood;

	public AbstractTwoWayGraph()
	{
		super();
		inNeighborhood = new MultiHashMap<V, E>();
	}

	public List<E> ingoingEdges(V dst)
	{
		failIfNotContained(dst);
		List<E> list = inNeighborhood.get(dst);
		return list != null ? list : new LinkedList<E>();
	}

	public int inDegree(V vertex)
	{
		return ingoingEdges(vertex).size();
	}

	public void addEdge(E edge)
	{
		super.addEdge(edge);
		inNeighborhood.add(edge.getDestination(), edge);
	}

	public void removeEdge(V src, V dst)
	{
		super.removeEdge(src, dst);
		List<E> edges = inNeighborhood.get(dst);
		Iterator<E> it = edges.iterator();
		E edge;
		while (it.hasNext())
		{
			edge = it.next();
			if (edge.getSource() == src)
			{
				it.remove();
			}
		}
	}

}
