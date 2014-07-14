package cdg;

import graphutils.AbstractTwoWayGraph;
import cfg.CFG;
import cfg.CFGEdge;
import cfg.CFGNode;

/**
 * A reverse control flow graph augmented with an edge from the exit node to the
 * start node.
 * 
 * @param <V>
 *            the vertex type
 */
public class ReverseCFG extends AbstractTwoWayGraph<CFGNode, CFGEdge>
{

	private CFGNode entry;
	private CFGNode exit;

	private ReverseCFG()
	{
	}

	public static ReverseCFG newInstance(CFG cfg)
	{
		ReverseCFG reverseCFG = new ReverseCFG();
		for (CFGNode vertex : cfg.getVertices())
		{
			reverseCFG.addVertex(vertex);
		}
		for (CFGEdge edge : cfg.getEdges())
		{
			CFGEdge reverseEdge = new CFGEdge(edge.getDestination(),
					edge.getSource(), edge.getLabel());
			reverseCFG.addEdge(reverseEdge);
		}
		reverseCFG.entry = cfg.getLastStatement();
		reverseCFG.exit = cfg.getFirstStatement();
		CFGEdge augmentedEdge = new CFGEdge(reverseCFG.getEntryNode(),
				reverseCFG.getExitNode(), CFGEdge.EMPTY_LABEL);
		reverseCFG.addEdge(augmentedEdge);
		return reverseCFG;
	}

	public CFGNode getEntryNode()
	{
		return entry;
	}

	public CFGNode getExitNode()
	{
		return exit;
	}
}