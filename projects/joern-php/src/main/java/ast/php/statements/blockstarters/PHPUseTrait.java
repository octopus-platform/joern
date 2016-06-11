package ast.php.statements.blockstarters;

import ast.expressions.IdentifierList;
import ast.logical.statements.BlockStarter;

public class PHPUseTrait extends BlockStarter
{
	private IdentifierList traits = null;
	private PHPTraitAdaptations traitAdaptations = null;

	public IdentifierList getTraits()
	{
		return this.traits;
	}

	public void setTraits(IdentifierList traits)
	{
		this.traits = traits;
		super.addChild(traits);
	}
	
	public PHPTraitAdaptations getTraitAdaptations()
	{
		return this.traitAdaptations;
	}

	public void setTraitAdaptations(PHPTraitAdaptations traitAdaptations)
	{
		this.traitAdaptations = traitAdaptations;
		super.addChild(traitAdaptations);
	}
}
