package outputModules.common;

import cfg.nodes.CFGNode;
import dom.DominatorTree;

public abstract class DOMExporter
{
	public void addDominatorTreeToDatabase(DominatorTree<CFGNode> dominatorTree)
	{
		for (CFGNode vertex : dominatorTree.getVertices())
		{
			CFGNode dominator = dominatorTree.getDominator(vertex);

			addDomEdge(vertex, dominator);
		}

	}

	public void addPostDominatorTreeToDatabase(
			DominatorTree<CFGNode> dominatorTree)
	{

		for (CFGNode vertex : dominatorTree.getVertices())
		{
			CFGNode dominator = dominatorTree.getDominator(vertex);

			addPostDomEdge(vertex, dominator);
		}

	}

	protected abstract void addDomEdge(CFGNode vertex, CFGNode dominator);

	protected abstract void addPostDomEdge(CFGNode vertex, CFGNode dominator);

}