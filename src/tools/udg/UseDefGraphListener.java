package tools.udg;

import tools.ImportedNodeListener;

public class UseDefGraphListener extends ImportedNodeListener {

	@Override
	public void visitNode(Long funcId)
	{
		UseDefGraphEdgeAdder edgeAdder = new UseDefGraphEdgeAdder();
		edgeAdder.addEdgesToFunction(funcId);		
	}

}
