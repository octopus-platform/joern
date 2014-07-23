package cdg;

import graphutils.AbstractGraph;

import java.util.Set;

import cfg.nodes.CFGNode;

public class CDG extends AbstractGraph<CFGNode, CDGEdge>
{

	private DominatorTree<CFGNode> dominatorTree;

	private CDG()
	{
	}

	public DominatorTree<CFGNode> getDominatorTree()
	{
		return this.dominatorTree;
	}

	public static CDG newInstance(DominatorTree<CFGNode> dominatorTree)
	{
		CDG cdg = new CDG();
		cdg.dominatorTree = dominatorTree;
		for (CFGNode vertex : dominatorTree.getVertices())
		{
			Set<CFGNode> frontier = dominatorTree.dominanceFrontier(vertex);
			if (frontier != null)
			{
				cdg.addVertex(vertex);
				for (CFGNode f : frontier)
				{
					cdg.addVertex(f);
					cdg.addEdge(new CDGEdge(f, vertex));
				}
			}
		}
		return cdg;
	}

}
