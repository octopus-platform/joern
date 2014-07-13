package astnodes.statements;

import astwalking.ASTNodeVisitor;

public class BreakStatement extends JumpStatement
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
