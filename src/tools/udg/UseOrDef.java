package tools.udg;

public class UseOrDef {
	public boolean isDef;
	public String symbol;
	public long nodeId = 0;

	@Override
	public boolean equals(Object o) {
		UseOrDef other = (UseOrDef) o;       

		return (isDef == other.isDef) &&
				(symbol.equals(other.symbol)) &&
				(nodeId == other.nodeId);
	}

	@Override
	public int hashCode()
	{
		return symbol.hashCode();
	}


}
