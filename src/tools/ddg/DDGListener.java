package tools.ddg;

import tools.ImportedNodeListener;

public class DDGListener extends ImportedNodeListener {
	
	@Override
	public void visitNode(Long funcId)
	{
		DDGEdgeAdder ddgEdgeAdder = new DDGEdgeAdder();
		ddgEdgeAdder.addEdges(funcId);
		
		// get the CFG root node for the function
		// traverse the CFG
		// Keep a stack of defs for each variable
		// So, we need something that maps Ids to Stacks.
		
	}

}
