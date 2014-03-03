package udg.useDefGraph;

import astnodes.ASTNode;
import cfg.CFGNode;

public class UseOrDefRecord{
	public ASTNode astNode;
	public boolean isDef;

	public UseOrDefRecord(ASTNode anASTNode, boolean aIsDef)
	{
		astNode = anASTNode; isDef = aIsDef;
	}

};
