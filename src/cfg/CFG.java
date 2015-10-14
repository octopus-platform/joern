package cfg;

import java.util.LinkedList;
import java.util.List;

import cfg.nodes.CFGEntryNode;
import cfg.nodes.CFGErrorNode;
import cfg.nodes.CFGExitNode;
import cfg.nodes.CFGNode;
import graphutils.IncidenceListGraph;

/**
 * Control Flow Graph. Consider this to be the target format of CFGFactories.
 * Please place language specific attributes of the CFG into a sub-class.
 */

public class CFG extends IncidenceListGraph<CFGNode, CFGEdge>
{
	private CFGNode entry;
	private CFGNode exit;
	private CFGNode error;
	private List<CFGNode> parameters;

	public CFG()
	{
		this(new CFGEntryNode(), new CFGExitNode());
	}

	public CFG(CFGNode entry, CFGNode exit)
	{
		this.entry = entry;
		this.exit = exit;
		addVertex(this.entry);
		addVertex(this.exit);
		parameters = new LinkedList<CFGNode>();
	}

	@Override
	public boolean isEmpty()
	{
		// do not count entry and exit node, since they do not provide any
		// additional information.
		return size() == 2;
	}

	public CFGNode getExitNode()
	{
		return exit;
	}

	public CFGNode getEntryNode()
	{
		return entry;
	}

	public CFGNode getErrorNode()
	{
		if (error == null)
		{
			error = new CFGErrorNode();
			addVertex(error);
		}
		return error;
	}

	public void registerParameter(CFGNode parameter)
	{
		parameters.add(parameter);
	}

	public List<CFGNode> getParameters()
	{
		return parameters;
	}

	public void addCFG(CFG otherCFG)
	{
		addVertices(otherCFG);
		addEdges(otherCFG);
	}

	public void appendCFG(CFG otherCFG)
	{
		addCFG(otherCFG);
		if (!otherCFG.isEmpty())
		{
			for (CFGEdge edge1 : incomingEdges(getExitNode()))
			{
				for (CFGEdge edge2 : otherCFG
						.outgoingEdges(otherCFG.getEntryNode()))
				{
					addEdge(edge1.getSource(), edge2.getDestination(),
							edge1.getLabel());
				}
			}
			removeEdgesTo(getExitNode());
			for (CFGEdge edge : otherCFG.incomingEdges(otherCFG.getExitNode()))
			{
				addEdge(edge.getSource(), getExitNode(), edge.getLabel());
			}
		}
	}

	public void mountCFG(CFGNode branchNode, CFGNode mergeNode, CFG cfg,
			String label)
	{
		if (!cfg.isEmpty())
		{
			addCFG(cfg);
			for (CFGEdge edge : cfg.outgoingEdges(cfg.getEntryNode()))
			{
				addEdge(branchNode, edge.getDestination(), label);
			}
			for (CFGEdge edge : cfg.incomingEdges(cfg.getExitNode()))
			{
				addEdge(edge.getSource(), mergeNode, edge.getLabel());
			}
		}
		else
		{
			addEdge(branchNode, mergeNode, label);
		}
	}

	private void addVertices(CFG cfg)
	{
		for (CFGNode vertex : cfg.getVertices())
		{
			// do not add entry and exit node
			if (!(vertex.equals(cfg.getEntryNode())
					|| vertex.equals(cfg.getExitNode())))
			{
				addVertex(vertex);
			}
		}
	}

	private void addEdges(CFG cfg)
	{
		for (CFGNode vertex : cfg.getVertices())
		{
			for (CFGEdge edge : cfg.outgoingEdges(vertex))
			{
				if (!(edge.getSource().equals(cfg.getEntryNode())
						|| edge.getDestination().equals(cfg.getExitNode())))
				{
					addEdge(edge);
				}
			}
		}
	}

	public void addEdge(CFGNode srcBlock, CFGNode dstBlock)
	{
		addEdge(srcBlock, dstBlock, CFGEdge.EMPTY_LABEL);
	}

	public void addEdge(CFGNode srcBlock, CFGNode dstBlock, String label)
	{
		CFGEdge edge = new CFGEdge(srcBlock, dstBlock, label);
		addEdge(edge);
	}

	public CFG reverse()
	{
		CFG reverseGraph = new CFG(getExitNode(), getEntryNode());
		for (CFGNode node : getVertices())
		{
			if (!node.equals(getEntryNode()) && !node.equals(getExitNode()))
			{
				reverseGraph.addVertex(node);
			}
		}
		for (CFGEdge edge : getEdges())
		{
			reverseGraph.addEdge(edge.reverse());
		}
		reverseGraph.parameters = parameters;
		return reverseGraph;
	}

}
