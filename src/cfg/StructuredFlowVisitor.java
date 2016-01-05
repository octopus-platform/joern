package cfg;

import ast.walking.ASTNodeVisitor;

public class StructuredFlowVisitor extends ASTNodeVisitor
{

	protected CFG returnCFG;

	public CFG getCFG()
	{
		return returnCFG;
	}

}
