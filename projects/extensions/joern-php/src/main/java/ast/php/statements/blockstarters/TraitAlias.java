package ast.php.statements.blockstarters;

import ast.expressions.StringExpression;

public class TraitAlias extends TraitAdaptationElement
{
	private StringExpression alias = null;
	
	public StringExpression getAlias()
	{
		return this.alias;
	}

	public void setAlias(StringExpression alias)
	{
		this.alias = alias;
		super.addChild(alias);
	}
}
