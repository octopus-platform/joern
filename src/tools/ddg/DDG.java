package tools.ddg;

import java.util.LinkedList;
import java.util.List;

public class DDG {

	List<DefUseRelation> defUseEdges = new LinkedList<DefUseRelation>();
	
	public List<DefUseRelation> getDefUseEdges()
	{
		return defUseEdges;
	}
	
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
	}

	public void add(long srcId, long dstId, String symbol)
	{
		DefUseRelation basicBlockPair = new DefUseRelation(srcId, dstId, symbol);
		defUseEdges.add(basicBlockPair);
	};

	

}
