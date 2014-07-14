package udg.useDefGraph;

import astnodes.ASTNode;

public class UseOrDefRecord
{
	public ASTNode astNode;
	public boolean isDef;

	public UseOrDefRecord(ASTNode anASTNode, boolean aIsDef)
	{
		astNode = anASTNode;
		isDef = aIsDef;
	}

};
