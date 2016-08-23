package ast.php.statements.blockstarters;

import ast.logical.statements.Statement;
import ast.statements.blockstarters.MethodReference;

public class TraitAdaptationElement extends Statement
{
	private MethodReference method = null;
	
	public MethodReference getMethod()
	{
		return this.method;
	}

	public void setMethod(MethodReference method)
	{
		this.method = method;
		super.addChild(method);
	}
}
