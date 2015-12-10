package ast.php.statements.blockstarters;

import ast.expressions.PrimaryExpression;
import ast.logical.statements.BlockStarter;

public class PHPSwitchCase extends BlockStarter
{
	private PrimaryExpression value = null;
	
	public PrimaryExpression getValue()
	{
		return this.value;
	}

	public void setValue(PrimaryExpression value)
	{
		this.value = value;
		super.addChild(value);
	}

}
