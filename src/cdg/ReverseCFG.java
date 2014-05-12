package cdg;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import misc.MultiHashMap;
import ddg.DefUseCFG.DefUseCFG;

/**
 * A reverse control flow graph augmented with an edge from the exit node to the
 * start node.
 * 
 * @param <V>
 *            the vertex type
 */
public class ReverseCFG<V> implements Graph<V> {

    private MultiHashMap<V, V> outNeighborhood;
    private MultiHashMap<V, V> inNeighborhood;
    private Set<V> basicBlocks;
    private V start;
    private V exit;


    private ReverseCFG() {
	outNeighborhood = new MultiHashMap<V, V>();
	inNeighborhood = new MultiHashMap<V, V>();
	basicBlocks = new HashSet<V>();
    }


    private boolean addVertex(V block) {
	if (basicBlocks.contains(block)) {
	    return false;
	} else {
	    basicBlocks.add(block);
	    return true;
	}
    }


    private boolean setStartNode(V block) {
	if (basicBlocks.contains(block)) {
	    start = block;
	    return true;
	}
	return false;
    }


    private boolean setExitNode(V block) {
	if (basicBlocks.contains(block)) {
	    exit = block;
	    return true;
	}
	return false;
    }


    private boolean linkVertices(V sourceBlock, V targetBlock) {
	if (basicBlocks.contains(sourceBlock) && basicBlocks.contains(targetBlock)) {
	    addLink(sourceBlock, targetBlock);
	    return true;
	}
	return false;
    }


    private void addLink(V source, V target) {
	outNeighborhood.add(source, target);
	inNeighborhood.add(target, source);
    }


    public V getStartNode() {
	return start;
    }


    public V getExitNode() {
	return exit;
    }


    @Override
    public Set<V> getVertices() {
	return Collections.unmodifiableSet(basicBlocks);
    }


    @Override
    public List<V> outNeighborhood(V block) {
	if (!basicBlocks.contains(block)) {
	    throw new IllegalArgumentException("Graph has no such vertex " + block);
	}
	return Collections.unmodifiableList(outNeighborhood.get(block));
    }


    @Override
    public List<V> inNeighborhood(V block) {
	if (!basicBlocks.contains(block)) {
	    throw new IllegalArgumentException("Graph has no such vertex " + block);
	}
	return Collections.unmodifiableList(inNeighborhood.get(block));
    }


    @Override
    public int outDegree(V block) {
	if (!basicBlocks.contains(block)) {
	    throw new IllegalArgumentException("Graph has no such vertex " + block);
	}
	return outNeighborhood.containsKey(block) ? outNeighborhood.get(block).size() : 0;
    }


    @Override
    public int inDegree(V block) {
	if (!basicBlocks.contains(block)) {
	    throw new IllegalArgumentException("Graph has no such vertex " + block);
	}
	return inNeighborhood.containsKey(block) ? inNeighborhood.get(block).size() : 0;
    }


    @Override
    public Iterator<V> iterator() {
	return getVertices().iterator();
    }


    public static ReverseCFG<Object> newInstance(DefUseCFG cfg, Object start, Object exit) {
	return new ReverseCFGCreator<Object>(cfg, start, exit).create();
    }


    private static class ReverseCFGCreator<V> {

	private ReverseCFG<V> reverseCFG;
	private DefUseCFG cfg;
	private V start;
	private V exit;


	public ReverseCFGCreator(DefUseCFG cfg, V start, V exit) {
	    reverseCFG = new ReverseCFG<V>();
	    this.cfg = cfg;
	    this.start = start;
	    this.exit = exit;
	}


	public ReverseCFG<V> create() {
	    addBlocks();
	    linkBlocks();
	    return reverseCFG;
	}


	private void addBlocks() {
	    for (Object block : cfg.getStatements()) {
		reverseCFG.addVertex((V) block);
	    }
	    reverseCFG.setStartNode(start);
	    reverseCFG.setExitNode(exit);
	}


	private void linkBlocks() {
	    MultiHashMap<V, V> outNeighborhood = cfg.getChildBlocks();
	    MultiHashMap<V, V> inNeighborhood = cfg.getParentBlocks();
	    reverseCFG.inNeighborhood = outNeighborhood;
	    reverseCFG.outNeighborhood = inNeighborhood;
	    reverseCFG.linkVertices(exit, start);
	}
    }

}