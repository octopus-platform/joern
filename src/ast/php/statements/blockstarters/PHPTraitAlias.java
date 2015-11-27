package ast.php.statements.blockstarters;

import ast.ASTNode;

public class PHPTraitAlias extends PHPTraitAdaptationElement
{
	private ASTNode alias = null;
	
	public ASTNode getAlias()
	{
		return this.alias;
	}

	public void setAlias(ASTNode alias)
	{
		this.alias = alias;
		super.addChild(alias);
	}
}
