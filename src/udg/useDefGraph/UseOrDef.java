package udg.useDefGraph;

import udg.ASTProvider;

public class UseOrDef
{
	public boolean isDef;
	public String symbol;
	public ASTProvider astProvider;

	@Override
	public boolean equals(Object o)
	{
		UseOrDef other = (UseOrDef) o;

		return (isDef == other.isDef) && (symbol.equals(other.symbol))
				&& (astProvider.equals(other.astProvider));

	}

	@Override
	public int hashCode()
	{
		return symbol.hashCode();
	}

}
