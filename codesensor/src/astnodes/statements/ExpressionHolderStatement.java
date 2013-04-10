package astnodes.statements;

import astnodes.ASTNode;
import astnodes.expressions.Expression;

public class ExpressionHolderStatement extends Statement
{
	
	Expression expr;
	
	public Expression getExpression()
	{
		return expr;
	}
	
	@Override
	public void addChild(ASTNode expression)
	{ 
		expr = (Expression) expression;
		super.addChild(expression);
	}
}
