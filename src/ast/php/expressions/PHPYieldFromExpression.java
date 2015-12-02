package ast.php.expressions;

import ast.ASTNode;
import ast.expressions.Expression;

public class PHPYieldFromExpression extends Expression
{
	private ASTNode fromExpression = null; // TODO change type to Expression once mapping is finished

	public ASTNode getFromExpression()
	{
		return this.fromExpression;
	}

	public void setFromExpression(ASTNode fromExpression)
	{
		this.fromExpression = fromExpression;
		super.addChild(fromExpression);
	}
}
