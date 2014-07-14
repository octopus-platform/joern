package astnodes.statements;

import astwalking.ASTNodeVisitor;

public class DoStatement extends BlockStarter
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
