package ast.expressions;

import ast.ASTNode;
import ast.walking.ASTNodeVisitor;

public class UnaryExpression extends Expression
{
	ASTNode expression = null; // TODO make this an Expression once PHP mapping is finished
	
	public ASTNode getExpression() // TODO return Expression
	{
		return this.expression;
	}

	public void setExpression(ASTNode expression) // TODO take Expression
	{
		this.expression = expression;
		super.addChild(expression);
	}
	
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
