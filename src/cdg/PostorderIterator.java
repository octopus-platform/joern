package cdg;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class PostorderIterator<V> implements Iterator<V>
{

	private Graph<V> graph;
	Deque<V> remainingNodes;
	List<V> visitedNodes;

	public PostorderIterator(Graph<V> graph, V root)
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
				for (V next : graph.outNeighborhood(root))
				{
					if (!visitedNodes.contains(next))
					{
						remainingNodes.push(next);
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
