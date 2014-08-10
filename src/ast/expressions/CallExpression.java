package ast.expressions;

import ast.walking.ASTNodeVisitor;

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
