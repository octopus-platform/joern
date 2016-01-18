package udg.useDefGraph;

import java.util.Objects;

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
		return Objects.hash(this.isDef, this.symbol, this.astProvider);
	}
	
	@Override
	public String toString() {
		return this.symbol + "[" + (this.isDef ? "DEF" : "USE") + "]{" + this.astProvider.getTypeAsString() + "}";
	}

}
