package cfg;

import graphutils.AbstractTwoWayGraph;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import misc.MultiHashMap;

// The first node added is the entry node
// The last node added is the exitNode
// For nodes with two outgoing edges,
// the first edge is the one taken if
// condition evaluates to true.

public class CFG extends AbstractTwoWayGraph<CFGNode, CFGEdge>
{

	List<CFGNode> jumpStatements;
	HashMap<String, CFGNode> labels;
	HashMap<CFGNode, CFGNode> loopStart;
	MultiHashMap<CFGNode, CFGNode> switchLabels;

	public CFG()
	{
		jumpStatements = new LinkedList<CFGNode>();
		labels = new HashMap<String, CFGNode>();
		loopStart = new HashMap<CFGNode, CFGNode>();
		switchLabels = new MultiHashMap<CFGNode, CFGNode>();
	}

	public void appendCFG(CFG otherCFG)
	{
		CFGNode src = getLastStatement();
		CFGNode dst = otherCFG.getFirstStatement();
		addCFG(otherCFG);
		if (src != null && dst != null)
		{
			addEdge(src, dst);
		}
	}

	public void addCFG(CFG otherCFG)
	{
		if (otherCFG.isEmpty())
		{
			return;
		}
		for (CFGNode statement : otherCFG.getVertices())
		{
			addVertex(statement);
		}
		for (CFGNode statement : otherCFG.getVertices())
		{
			for (CFGEdge edge : otherCFG.outgoingEdges(statement))
			{
				addEdge(edge);
			}
		}
		switchLabels.addAll(otherCFG.getSwitchLabels());
		jumpStatements.addAll(otherCFG.getJumpStatements());
		labels.putAll(otherCFG.getLabels());
		loopStart.putAll(otherCFG.loopStart);
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

	public CFGNode getLastStatement()
	{
		try
		{
			return getVertices().get(size() - 1);
		}
		catch (RuntimeException ex)
		{
			return null;
		}
	}

	public CFGNode getFirstStatement()
	{
		try
		{
			return getVertices().get(0);
		}
		catch (RuntimeException ex)
		{
			return null;
		}
	}

	public CFGNode getBlockByLabel(String label)
	{
		return labels.get(label);
	}

	public void addSwitchLabel(CFGNode surroundingSwitch, CFGNode labeledBlock)
	{
		switchLabels.add(surroundingSwitch, labeledBlock);
	}

	public CFGNode getOuterLoop(CFGNode thisStatement)
	{
		return loopStart.get(thisStatement);
	}

	public MultiHashMap<CFGNode, CFGNode> getSwitchLabels()
	{
		return switchLabels;
	}

	public void labelBlock(String label, CFGNode block)
	{
		labels.put(label, block);
	}

	public Collection<? extends CFGNode> getJumpStatements()
	{
		return jumpStatements;
	}

	public HashMap<String, CFGNode> getLabels()
	{
		return labels;
	}

	public void addJumpStatement(CFGNode block)
	{
		this.jumpStatements.add(block);
	}

}
