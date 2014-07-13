package astnodes.statements;

import astwalking.ASTNodeVisitor;

public class ReturnStatement extends JumpStatement
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
