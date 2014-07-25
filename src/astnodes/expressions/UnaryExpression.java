package astnodes.expressions;

import astwalking.ASTNodeVisitor;

public class UnaryExpression extends Expression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
