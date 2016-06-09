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
	
	// TODO probably, more methods than only getEscapedCodeStr() should "forward" the call
	// to the Closure. For instance, calls to obtain the node id, etc. Test this!
	public String getEscapedCodeStr() {
		return this.closure.getEscapedCodeStr();
	}

}
