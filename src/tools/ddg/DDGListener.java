package tools.ddg;

import tools.ImportedNodeListener;

public class DDGListener extends ImportedNodeListener {
	
	@Override
	public void visitNode(Long funcId)
	{
		DDGEdgeAdder ddgEdgeAdder = new DDGEdgeAdder();
		ddgEdgeAdder.addEdges(funcId);		
	}

}
