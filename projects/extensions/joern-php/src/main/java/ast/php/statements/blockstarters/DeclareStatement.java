package ast.php.statements.blockstarters;

import ast.logical.statements.BlockStarter;
import ast.php.statements.ConstantDeclaration;

public class DeclareStatement extends BlockStarter
{
	private ConstantDeclaration declares = null;

	public ConstantDeclaration getDeclares()
	{
		return this.declares;
	}

	public void setDeclares(ConstantDeclaration declares)
	{
		this.declares = declares;
		super.addChild(declares);
	}
}
