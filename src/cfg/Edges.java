package cfg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import misc.MultiHashMap;

public class Edges<E extends Edge<V>, V> extends MultiHashMap<V, E> implements
		Iterable<E>
{

	public void addEdge(E edge)
	{
		add(edge.getSource(), edge);
	}

	public List<E> getEdgesFrom(V src)
	{
		return get(src);
	}

	public List<V> outNeighborhood(V src)
	{
		List<V> destinationList = new LinkedList<V>();
		for (Edge<V> e : getEdgesFrom(src))
		{
			destinationList.add(e.getDestination());
		}
		return destinationList;
	}

	public boolean isConnected(V src, V dst)
	{
		for (Edge<V> e : getEdgesFrom(src))
		{
			if (e.getDestination().equals(dst))
			{
				return true;
			}
		}
		return false;
	}

	public void addEdges(Edges<E, V> otherEdges)
	{
		addAll(otherEdges);
	}

	public void removeEdge(V src, V dst)
	{
		List<E> edges = get(src);
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

	public void removeAllEdgesFrom(V src)
	{
		removeAll(src);
	}

	@Override
	public Iterator<E> iterator()
	{
		// TODO
		List<E> list = new LinkedList<E>();
		for (V key : keySet())
		{
			list.addAll(get(key));
		}
		return list.iterator();
	}

}
