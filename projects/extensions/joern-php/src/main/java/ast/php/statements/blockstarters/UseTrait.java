package ast.php.statements.blockstarters;

import ast.expressions.IdentifierList;
import ast.logical.statements.BlockStarter;

public class UseTrait extends BlockStarter
{
	private IdentifierList traits = null;
	private TraitAdaptations traitAdaptations = null;

	public IdentifierList getTraits()
	{
		return this.traits;
	}

	public void setTraits(IdentifierList traits)
	{
		this.traits = traits;
		super.addChild(traits);
	}
	
	public TraitAdaptations getTraitAdaptations()
	{
		return this.traitAdaptations;
	}

	public void setTraitAdaptations(TraitAdaptations traitAdaptations)
	{
		this.traitAdaptations = traitAdaptations;
		super.addChild(traitAdaptations);
	}
}
