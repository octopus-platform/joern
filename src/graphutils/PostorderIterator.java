package graphutils;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class PostorderIterator<V, E extends Edge<V>> implements Iterator<V>
{

	private AbstractGraph<V, E> graph;
	Deque<V> remainingNodes;
	List<V> visitedNodes;

	public PostorderIterator(AbstractGraph<V, E> graph, V root)
	{
		this.graph = graph;
		this.remainingNodes = new LinkedList<V>();
		this.visitedNodes = new LinkedList<V>();
		this.remainingNodes.push(root);
	}

	@Override
	public boolean hasNext()
	{
		return !remainingNodes.isEmpty();
	}

	@Override
	public V next()
	{
		while (hasNext())
		{
			V root = remainingNodes.peek();
			// visit root
			if (!visitedNodes.contains(root))
			{
				visitedNodes.add(root);
			}
			// predecessors first if any
			if (graph.outDegree(root) > 0)
			{
				for (E edge : graph.outgoingEdges(root))
				{
					if (!visitedNodes.contains(edge.getDestination()))
					{
						remainingNodes.push(edge.getDestination());
						// depth first
						break;
					}
				}
			}
			// No adjacent vertices or all adjacent vertices already visited
			// This means the current subtree rooted at the current node is
			// done and we can go back to its root.
			if (remainingNodes.peek().equals(root))
			{
				return remainingNodes.poll();
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException("Operation not allowed");
	}

}
