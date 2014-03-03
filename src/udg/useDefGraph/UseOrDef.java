package udg.useDefGraph;

import astnodes.ASTNode;

public class UseOrDef {
	public boolean isDef;
	public String symbol;
	public ASTNode astNode;

	@Override
	public boolean equals(Object o) {
		UseOrDef other = (UseOrDef) o;       

		return (isDef == other.isDef) &&
				(symbol.equals(other.symbol)) &&
				(astNode == other.astNode);
	}

	@Override
	public int hashCode()
	{
		return symbol.hashCode();
	}


}
