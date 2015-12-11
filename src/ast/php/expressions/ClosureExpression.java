package ast.php.expressions;

import ast.expressions.Expression;
import ast.php.functionDef.Closure;

public class ClosureExpression extends Expression
{
	private Closure closure = null;

	public Closure getClosure()
	{
		return this.closure;
	}
	
	public void setClosure(Closure closure)
	{	
		this.closure = closure;
		super.addChild(closure);
	}
}
