package cdg;

import cfg.CFG;
import ddg.DefUseCFG.DefUseCFG;

public class CDGCreator {

    public CDG<Object> create(CFG cfg, DefUseCFG defUseCFG) {
	Object start = cfg.getFirstStatement();
	Object exit = cfg.getLastStatement();
	ReverseCFG<Object> reverseCFG;
	DominatorTree<Object> dominatorTree;

	reverseCFG = ReverseCFG.newInstance(defUseCFG, start, exit);
	dominatorTree = DominatorTree.newInstance(reverseCFG, reverseCFG.getExitNode());
	return CDG.newInstance(dominatorTree);
    }
}
