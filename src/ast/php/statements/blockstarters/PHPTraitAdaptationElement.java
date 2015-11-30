package ast.php.statements.blockstarters;

import ast.logical.statements.Statement;

public class PHPTraitAdaptationElement extends Statement
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
