package astnodes.statements;

import astwalking.ASTNodeVisitor;

public class Label extends Statement
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
