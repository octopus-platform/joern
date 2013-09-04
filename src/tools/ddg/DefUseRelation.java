package tools.ddg;

public class DefUseRelation{		
	public long src;
	public long dst;
	public String symbol;
	
	public DefUseRelation(Long aSrc, long aDst, String aSymbol)
	{
		src = aSrc;
		dst = aDst;
		symbol = aSymbol;
	}

	@Override
	public boolean equals(Object other) {
		DefUseRelation otherRel = (DefUseRelation) other;
		return (src == otherRel.src) &&
			   (dst == otherRel.dst) &&
			   (symbol.equals(otherRel.symbol));
	}
		
}
