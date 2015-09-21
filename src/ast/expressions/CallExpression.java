package ast.expressions;

public class CallExpression extends PostfixExpression
{

	public Expression getTarget()
	{
		if (children == null)
			return null;
		return (Expression) children.get(0);
	}

}
