package cdg;

import graphutils.Edge;
import cfg.CFG;
import cfg.nodes.CFGNode;
import dom.DominatorTree;

/**
 * This class provides static factory methods for control dependence graphs.
 */
public class CDGCreator
{
	/**
	 * Creates the control dependence graph of the function given by the control
	 * flow graph. Note that the control flow graph must not be augmented nor
	 * reversed. Note that this method creates a post-dominator tree first.
	 * 
	 * @param cfg
	 *            The control flow graph.
	 * @return The control dependence graph.
	 */
	public static CDG create(CFG cfg)
	{
		DominatorTree<CFGNode> postdominatorTree = DominatorTree
				.newPostDominatorTree(cfg);
		return create(cfg, postdominatorTree);
	}

	/**
	 * Creates the control dependence graph of the function given by the control
	 * flow graph and its post-dominator tree. Note that the control flow graph
	 * must not be augmented nor reversed. This method takes care of the
	 * augmentation without modifying the parameters.
	 * 
	 * @param cfg
	 *            The control flow graph.
	 * @param postdominatorTree
	 *            The post-dominator tree.
	 * @return The control dependence graph.
	 */
	public static CDG create(CFG cfg, DominatorTree<CFGNode> postdominatorTree)
	{
		CDG cdg = new CDG();
		for (CFGNode node : cfg.getVertices())
		{
			cdg.addVertex(node);
		}
		for (CFGNode condition : postdominatorTree.getVertices())
		{
			if (cfg.outDegree(condition) > 1)
			{
				CFGNode runner;
				for (Edge<CFGNode> edge : cfg.outgoingEdges(condition))
				{
					CFGNode destination = edge.getDestination();
					if (postdominatorTree.contains(destination))
					{
						runner = destination;
						while (!runner.equals(
								postdominatorTree.getDominator(condition)))
						{
							cdg.addEdge(condition, runner);
							runner = postdominatorTree.getDominator(runner);
						}
					}
				}
			}
			// Simulate augmentation
			else if (condition.equals(cfg.getEntryNode()))
			{
				CFGNode runner;
				for (Edge<CFGNode> edge : cfg.outgoingEdges(condition))
				{
					CFGNode destination = edge.getDestination();
					if (postdominatorTree.contains(destination))
					{
						runner = destination;
						while (!runner.equals(cfg.getExitNode()))
						{
							cdg.addEdge(condition, runner);
							runner = postdominatorTree.getDominator(runner);
						}
					}
				}
			}
		}
		return cdg;
	}
}
