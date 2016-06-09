package ast.expressions;

import ast.walking.ASTNodeVisitor;

public class UnaryExpression extends Expression
{
	Expression expression = null;
	
	public Expression getExpression()
	{
		return this.expression;
	}

	public void setExpression(Expression expression)
	{
		this.expression = expression;
		super.addChild(expression);
	}
	
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
