package astnodes.expressions;

import astwalking.ASTNodeVisitor;

public class CallExpression extends PostfixExpression
{

	public Expression getTarget()
	{
		if (children == null)
			return null;
		return (Expression) children.get(0);
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

}
