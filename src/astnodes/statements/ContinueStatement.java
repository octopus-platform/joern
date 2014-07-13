package astnodes.statements;

import astwalking.ASTNodeVisitor;

public class ContinueStatement extends JumpStatement
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
