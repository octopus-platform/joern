package cdg;

import cfg.CFG;
import cfg.nodes.CFGNode;

public class CDGCreator
{

	public CDG create(CFG cfg)
	{
		ReverseCFG reverseCFG;
		DominatorTree<CFGNode> dominatorTree;
		reverseCFG = ReverseCFG.newInstance(cfg);
		dominatorTree = DominatorTree.newInstance(reverseCFG,
				reverseCFG.getEntryNode());
		return CDG.newInstance(dominatorTree);
	}
}
