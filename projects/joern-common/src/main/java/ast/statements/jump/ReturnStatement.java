package ast.statements.jump;

import ast.expressions.Expression;
import ast.logical.statements.JumpStatement;
import ast.walking.ASTNodeVisitor;

public class ReturnStatement extends JumpStatement
{
	private Expression returnExpression = null;
	
	public Expression getReturnExpression()
	{
		return this.returnExpression;
	}

	public void setReturnExpression(Expression expression)
	{
		this.returnExpression = expression;
		super.addChild(expression);
	}
	
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
