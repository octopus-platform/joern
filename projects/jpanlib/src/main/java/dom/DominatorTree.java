package dom;

import graphutils.Edge;
import graphutils.IncidenceListGraph;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import cfg.CFG;
import cfg.CFGEdge;
import cfg.nodes.CFGNode;

public class DominatorTree<V>
{

	private HashMap<V, V> dominators;
	private HashMap<V, Integer> postorderEnumeration;

	private DominatorTree(V root)
	{
		dominators = new HashMap<V, V>();
		postorderEnumeration = new HashMap<V, Integer>();
		addVertex(root);
		setDominator(root, root);
	}

	public static <V> DominatorTree<V> newDominatorTree(
			IncidenceListGraph<V, Edge<V>> graph, V root)
	{
		return new DominatorTreeCreator<V, Edge<V>>(graph, root).create();
	}

	public static DominatorTree<CFGNode> newDominatorTree(CFG cfg)
	{
		return new DominatorTreeCreator<CFGNode, CFGEdge>(cfg,
				cfg.getEntryNode()).create();
	}

	public static DominatorTree<CFGNode> newPostDominatorTree(CFG cfg)
	{
		CFG reverseCFG = cfg.reverse();
		return new DominatorTreeCreator<CFGNode, CFGEdge>(reverseCFG,
				reverseCFG.getEntryNode()).create();
	}

	public Collection<V> getVertices()
	{
		return dominators.keySet();
	}

	public V getDominator(V vertex)
	{
		return dominators.get(vertex);
	}

	public int postorderNumber(V vertex)
	{
		return postorderEnumeration.get(vertex);
	}

	private V commonDominator(List<V> vertices)
	{
		Deque<V> stack = new LinkedList<V>();
		for (V vertex : vertices)
		{
			if (hasDominator(vertex))
			{
				stack.push(vertex);
			}
		}
		if (stack.isEmpty())
		{
			return null;
		}
		while (stack.size() > 1)
		{
			stack.push(commonDominator(stack.pop(), stack.pop()));
		}
		return stack.pop();
	}

	private boolean isSmaller(V vertex1, V vertex2)
	{
		return postorderNumber(vertex1) < postorderNumber(vertex2);
	}

	private V commonDominator(V vertex1, V vertex2)
	{
		V finger1 = vertex1;
		V finger2 = vertex2;
		while (!finger1.equals(finger2))
		{
			while (isSmaller(finger1, finger2))
			{
				finger1 = getDominator(finger1);
			}
			while (isSmaller(finger2, finger1))
			{
				finger2 = getDominator(finger2);
			}
		}
		return finger1;
	}

	private boolean addVertex(V vertex)
	{
		if (!contains(vertex))
		{
			dominators.put(vertex, null);
			return true;
		}
		return false;
	}

	private boolean setDominator(V vertex, V dominator)
	{
		boolean changed = false;
		if (contains(vertex))
		{
			V currentDominator = dominators.get(vertex);
			if (currentDominator == null && dominator != null)
			{
				dominators.put(vertex, dominator);
				changed = true;
			}
			else if (!currentDominator.equals(dominator))
			{
				dominators.put(vertex, dominator);
				changed = true;
			}
			else
			{
				changed = false;
			}
		}
		return changed;
	}

	public boolean contains(V vertex)
	{
		return dominators.containsKey(vertex);
	}

	private boolean hasDominator(V vertex)
	{
		return dominators.get(vertex) != null;
	}

	public String toString()
	{
		String repr = "";
		for (V vertex : getVertices())
		{
			repr += vertex + " IDOM " + getDominator(vertex) + "\n";
		}
		return repr;
	}

	private static class DominatorTreeCreator<V, E extends Edge<V>>
	{

		private DominatorTree<V> dominatorTree;
		private IncidenceListGraph<V, E> flowgraph;
		private Deque<V> queue;
		private V startNode;

		public DominatorTreeCreator(IncidenceListGraph<V, E> flowgraph,
				V startNode)
		{
			this.dominatorTree = new DominatorTree<V>(startNode);
			this.flowgraph = flowgraph;
			this.queue = new LinkedList<V>();
			this.startNode = startNode;
		}

		public DominatorTree<V> create()
		{
			createStack(startNode);
			createDominatorTree();
			return dominatorTree;
		}

		private void createDominatorTree()
		{
			boolean changed = true;
			queue.remove();
			while (changed)
			{
				changed = false;
				for (V currentNode : queue)
				{
					List<V> list = new LinkedList<V>();
					for (Edge<V> edge : flowgraph.incomingEdges(currentNode))
					{
						list.add(edge.getSource());
					}
					V newIdom = dominatorTree.commonDominator(list);
					dominatorTree.addVertex(currentNode);
					if (dominatorTree.setDominator(currentNode, newIdom))
					{
						changed = true;
					}
				}
			}
		}

		private void createStack(V node)
		{
			queue.add(node);
			dominatorTree.postorderEnumeration.put(node,
					flowgraph.size() - queue.size());
			for (E edge : flowgraph.outgoingEdges(node))
			{
				V destination = edge.getDestination();
				if (!dominatorTree.postorderEnumeration
						.containsKey(destination))
				{
					createStack(destination);
				}
			}
		}

	}

}
