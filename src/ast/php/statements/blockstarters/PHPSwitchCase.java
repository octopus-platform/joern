package ast.php.statements.blockstarters;

import ast.ASTNode;
import ast.logical.statements.BlockStarter;

public class PHPSwitchCase extends BlockStarter
{
	private ASTNode value = null;
	
	public ASTNode getValue()
	{
		return this.value;
	}

	public void setValue(ASTNode value)
	{
		this.value = value;
		super.addChild(value);
	}

}
