package ast.php.statements.blockstarters;

import ast.logical.statements.BlockStarter;
import ast.logical.statements.CompoundStatement;
import ast.php.statements.ConstantDeclaration;

public class PHPDeclareStatement extends BlockStarter
{
	private ConstantDeclaration declares = null;
	private CompoundStatement content = null;

	public ConstantDeclaration getDeclares()
	{
		return this.declares;
	}

	public void setDeclares(ConstantDeclaration declares)
	{
		this.declares = declares;
		super.addChild(declares);
	}
	
	public CompoundStatement getContent()
	{
		return this.content;
	}

	public void setContent(CompoundStatement content)
	{
		this.content = content;
		super.addChild(content);
	}
}
