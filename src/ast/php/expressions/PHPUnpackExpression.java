package ast.php.expressions;

import ast.ASTNode;
import ast.expressions.Expression;

public class PHPUnpackExpression extends Expression
{
	private ASTNode unpackExpression = null; // TODO change type to Expression once mapping is finished

	public ASTNode getUnpackExpression()
	{
		return this.unpackExpression;
	}

	public void setUnpackExpression(ASTNode unpackExpression)
	{
		this.unpackExpression = unpackExpression;
		super.addChild(unpackExpression);
	}
}
