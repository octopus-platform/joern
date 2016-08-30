package ast.php.statements.blockstarters;

import ast.expressions.Expression;
import ast.logical.statements.BlockStarter;

public class SwitchCase extends BlockStarter
{
	private Expression value = null;
	
	public Expression getValue()
	{
		return this.value;
	}

	public void setValue(Expression value)
	{
		this.value = value;
		super.addChild(value);
	}

}
