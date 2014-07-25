package astnodes.statements;

import astwalking.ASTNodeVisitor;

public class WhileStatement extends BlockStarter
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
