package cdg;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;

public class DominatorTree<V> implements WalkableGraph<V> {

    private HashMap<V, V> dominators;
    private HashMap<V, Set<V>> dominanceFrontiers;
    private HashMap<V, Integer> postorderEnumeration;


    private DominatorTree() {
	dominators = new HashMap<V, V>();
	dominanceFrontiers = new HashMap<V, Set<V>>();
	postorderEnumeration = new HashMap<V, Integer>();
    }


    private boolean addVertex(V vertex) {
	if (!dominators.containsKey(vertex)) {
	    dominators.put(vertex, null);
	    return true;
	}
	return false;
    }


    private boolean setDominator(V vertex, V dominator) {
	boolean changed = false;
	if (dominators.containsKey(vertex)) {
	    V currentDominator = dominators.get(vertex);
	    if (currentDominator == null && dominator != null) {
		dominators.put(vertex, dominator);
		changed = true;
	    } else if (!currentDominator.equals(dominator)) {
		dominators.put(vertex, dominator);
		changed = true;
	    } else {
		changed = false;
	    }
	}
	return changed;
    }


    public void print() {
	for (Entry<V, V> entry : dominators.entrySet()) {
	    System.out.println(entry.getValue() + " IDom " + entry.getKey());
	}
	for (Entry<V, Set<V>> entry : dominanceFrontiers.entrySet()) {
	    System.out.println("dominanceFrontier(" + entry.getKey() + ") = " + entry.getValue());
	}
    }


    public V getDominator(V vertex) {
	return dominators.get(vertex);
    }


    public boolean hasDominator(V vertex) {
	return dominators.get(vertex) != null;
    }


    public V commonDominator(List<V> vertices) {
	if (vertices.isEmpty()) {
	    return null;
	}
	Deque<V> stack = new LinkedList<V>();
	for (V vertex : vertices) {
	    if (hasDominator(vertex)) {
		stack.push(vertex);
	    }
	}
	while (stack.size() > 1) {
	    stack.push(commonDominator(stack.pop(), stack.pop()));
	}
	return stack.pop();
    }


    public V commonDominator(V vertex1, V vertex2) {
	V finger1 = vertex1;
	V finger2 = vertex2;
	while (!finger1.equals(finger2)) {
	    while (postorderEnumeration.get(finger1) < postorderEnumeration.get(finger2)) {
		finger1 = getDominator(finger1);
	    }
	    while (postorderEnumeration.get(finger2) < postorderEnumeration.get(finger1)) {
		finger2 = getDominator(finger2);
	    }
	}
	assert finger1.equals(finger2) : "fingers do not match";
	return finger1;
    }


    public Set<V> dominanceFrontier(V vertex) {
	return dominanceFrontiers.get(vertex);
    }


    public static <T> DominatorTree<T> newInstance(WalkableGraph<T> graph, T entryNode) {
	return new DominatorTreeCreator<T>(graph, entryNode).create();
    }


    private static class DominatorTreeCreator<V> {

	private DominatorTree<V> dominatorTree;
	private WalkableGraph<V> graph;
	private List<V> orderedVertices;
	private V entryNode;


	public DominatorTreeCreator(WalkableGraph<V> graph, V startNode) {
	    this.dominatorTree = new DominatorTree<V>();
	    this.graph = graph;
	    this.orderedVertices = new LinkedList<V>();
	    this.entryNode = startNode;
	}


	public DominatorTree<V> create() {
	    // System.out.println("Enumerating vertices");
	    enumerateVertices();
	    // System.out.println("Initialize dominator tree");
	    initializeDominatorTree();
	    // System.out.println("Build dominator tree");
	    buildDominatorTree();
	    determineDominanceFrontiers();
	    return dominatorTree;
	}


	private void determineDominanceFrontiers() {
	    for (V currentNode : graph.getVertices()) {
		if (graph.inDegree(currentNode) > 1) {
		    V runner;
		    for (V predecessor : graph.inNeighborhood(currentNode)) {
			runner = predecessor;
			while (!runner.equals(dominatorTree.getDominator(currentNode))) {
			    if (!dominatorTree.dominanceFrontiers.containsKey(runner)) {
				dominatorTree.dominanceFrontiers.put(runner, new HashSet<V>());
			    }
			    dominatorTree.dominanceFrontiers.get(runner).add(currentNode);
			    runner = dominatorTree.getDominator(runner);
			}
		    }
		}
	    }
	}


	private void buildDominatorTree() {
	    boolean changed = true;
	    while (changed) {
		changed = false;

		ListIterator<V> reverseVertexIterator = orderedVertices
			.listIterator(orderedVertices.size());
		// Skip the root
		V startNode = reverseVertexIterator.previous();
		assert startNode.equals(entryNode) : "last node does not equal entry node";

		while (reverseVertexIterator.hasPrevious()) {
		    V currentNode = reverseVertexIterator.previous();
		    // System.out.println("Current Node : " + currentNode);
		    V newIdom = dominatorTree.commonDominator(graph.inNeighborhood(currentNode));
		    // System.out.println("New IDom " + newIdom);

		    dominatorTree.addVertex(currentNode);
		    if (dominatorTree.setDominator(currentNode, newIdom)) {
			changed = true;
		    }
		}
	    }
	}


	private void enumerateVertices() {
	    int counter = 0;
	    Deque<V> remainingNodes = new LinkedList<V>();
	    // We do not follow incident edges to these nodes.
	    List<V> visitedNodes = new LinkedList<V>();
	    remainingNodes.push(entryNode);
	    while (!remainingNodes.isEmpty()) {
		V currentNode = remainingNodes.peek();
		visitedNodes.add(currentNode);
		if (graph.outDegree(currentNode) > 0) {
		    for (V next : graph.outNeighborhood(currentNode)) { // TODO <- inefficient
			if (!visitedNodes.contains(next)) {
			    remainingNodes.push(next);
			    // depth first
			    break;
			}
		    }
		}
		// No adjacent vertices or all adjacent vertices already visited
		// This means the current subtree rooted at the current node is
		// done and we can go back to its root.
		if (remainingNodes.peek().equals(currentNode)) {
		    orderedVertices.add(currentNode);
		    dominatorTree.postorderEnumeration.put(currentNode, counter++);
		    remainingNodes.poll();
		}
	    }
	    // System.out.println(orderedVertices);
	}


	private void initializeDominatorTree() {
	    dominatorTree.addVertex(entryNode);
	    dominatorTree.setDominator(entryNode, entryNode);
	}

    }


    @Override
    public Set<V> getVertices() {
	return Collections.unmodifiableSet(dominators.keySet());
    }


    @Override
    public List<V> outNeighborhood(V vertex) {
	throw new UnsupportedOperationException();
    }


    @Override
    public List<V> inNeighborhood(V vertex) {
	if (dominators.containsKey(vertex)) {
	    List<V> list = new LinkedList<V>();
	    list.add(dominators.get(vertex));
	    return list;
	}
	return null;
    }


    @Override
    public int inDegree(V vertex) {
	return 1;
    }


    @Override
    public int outDegree(V vertex) {
	throw new UnsupportedOperationException();
    }

}