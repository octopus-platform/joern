package astnodes.expressions;

import astwalking.ASTNodeVisitor;

public class PrimaryExpression extends PostfixExpression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
