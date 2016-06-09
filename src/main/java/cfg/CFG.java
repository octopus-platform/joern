package cfg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import cfg.nodes.CFGEntryNode;
import cfg.nodes.CFGErrorNode;
import cfg.nodes.CFGExceptionNode;
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

	private List<CFGNode> breakStatements;
	private List<CFGNode> continueStatements;
	private List<CFGNode> returnStatements;
	private HashMap<CFGNode, String> gotoStatements;
	private HashMap<String, CFGNode> labels;
	private CFGExceptionNode exceptionNode;

	
	public CFG()
	{
		this(new CFGEntryNode(), new CFGExitNode());
	
		setBreakStatements(new LinkedList<CFGNode>());
		setContinueStatements(new LinkedList<CFGNode>());
		setReturnStatements(new LinkedList<CFGNode>());
		setGotoStatements(new HashMap<CFGNode, String>());
		setLabels(new HashMap<String, CFGNode>());
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
	
		getParameters().addAll(otherCFG.getParameters());
		getBreakStatements().addAll(otherCFG.getBreakStatements());
		getContinueStatements().addAll(otherCFG.getContinueStatements());
		getReturnStatements().addAll(otherCFG.getReturnStatements());
		getGotoStatements().putAll(otherCFG.getGotoStatements());
		getLabels().putAll(otherCFG.getLabels());
		if (this.hasExceptionNode() && otherCFG.hasExceptionNode())
		{
			CFGExceptionNode oldExceptionNode = getExceptionNode();
			CFGExceptionNode newExceptionNode = new CFGExceptionNode();
			setExceptionNode(newExceptionNode);
			addEdge(oldExceptionNode, newExceptionNode,
					CFGEdge.UNHANDLED_EXCEPT_LABEL);
			addEdge(otherCFG.getExceptionNode(), newExceptionNode,
					CFGEdge.UNHANDLED_EXCEPT_LABEL);
		} else if (otherCFG.hasExceptionNode())
		{
			setExceptionNode(otherCFG.getExceptionNode());
		}
	
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
	
	public void setExceptionNode(CFGExceptionNode node)
	{
		this.exceptionNode = node;
		addVertex(node);
	}

	public List<CFGNode> getBreakStatements()
	{
		return breakStatements;
	}

	public void setBreakStatements(List<CFGNode> breakStatements)
	{
		this.breakStatements = breakStatements;
	}

	public List<CFGNode> getContinueStatements()
	{
		return continueStatements;
	}

	public void setContinueStatements(List<CFGNode> continueStatements)
	{
		this.continueStatements = continueStatements;
	}

	public HashMap<String, CFGNode> getLabels()
	{
		return labels;
	}

	public void setLabels(HashMap<String, CFGNode> labels)
	{
		this.labels = labels;
	}

	public HashMap<CFGNode, String> getGotoStatements()
	{
		return gotoStatements;
	}

	public void setGotoStatements(HashMap<CFGNode, String> gotoStatements)
	{
		this.gotoStatements = gotoStatements;
	}

	public List<CFGNode> getReturnStatements()
	{
		return returnStatements;
	}

	public void setReturnStatements(List<CFGNode> returnStatements)
	{
		this.returnStatements = returnStatements;
	}

	public void addBlockLabel(String label, CFGNode block)
	{
		getLabels().put(label, block);
	}

	public void addBreakStatement(CFGNode statement)
	{
		getBreakStatements().add(statement);
	}

	public void addContinueStatement(CFGNode statement)
	{
		getContinueStatements().add(statement);
	}

	public void addGotoStatement(CFGNode gotoStatement, String gotoTarget)
	{
		getGotoStatements().put(gotoStatement, gotoTarget);
	}

	public void addReturnStatement(CFGNode returnStatement)
	{
		getReturnStatements().add(returnStatement);
	}

	public CFGNode getBlockByLabel(String label)
	{
		CFGNode block = getLabels().get(label);
		if (block == null)
		{
			System.err
					.println("warning : can not find block for label " + label);
			return getErrorNode();
		}
		return block;
	}

	public CFGExceptionNode getExceptionNode()
	{
		return this.exceptionNode;
	}

	public boolean hasExceptionNode()
	{
		return this.exceptionNode != null;
	}
	

}
