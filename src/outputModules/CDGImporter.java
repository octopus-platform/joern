package outputModules;

import cdg.CDG;
import cdg.CDGEdge;
import cdg.DominatorTree;
import cfg.nodes.CFGNode;

public abstract class CDGImporter
{
	public void addCDGToDatabase(CDG cdg)
	{

		// Add post dominator edges
		DominatorTree<CFGNode> dominatorTree = cdg.getDominatorTree();

		for (CFGNode vertex : dominatorTree.getVertices())
		{
			CFGNode dominator = dominatorTree.getDominator(vertex);

			addPostDomEdge(vertex, dominator);
		}

		// Add control edges

		for (CFGNode src : cdg.getVertices())
		{
			for (CDGEdge edge : cdg.outgoingEdges(src))
			{
				CFGNode dst = edge.getDestination();
				if (!src.equals(dst))
				{
					addControlsEdge(src, dst);
				}
			}
		}
	}

	protected abstract void addControlsEdge(CFGNode src, CFGNode dst);

	protected abstract void addPostDomEdge(CFGNode vertex, CFGNode dominator);

}
