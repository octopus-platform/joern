package ast.php.statements.blockstarters;

import ast.expressions.IdentifierList;

public class PHPTraitPrecedence extends PHPTraitAdaptationElement
{
	private IdentifierList insteadof = null;
	
	public IdentifierList getInsteadOf()
	{
		return this.insteadof;
	}

	public void setInsteadOf(IdentifierList insteadof)
	{
		this.insteadof = insteadof;
		super.addChild(insteadof);
	}
}
