package tools.ddg;

import java.util.LinkedList;
import java.util.List;

public class DDG {

	List<BasicBlockPair> defUseEdges = new LinkedList<BasicBlockPair>();
	
	public class BasicBlockPair{		
		public long src;
		public long dst;
		
		public BasicBlockPair(Long aSrc, long aDst)
		{
			src = aSrc;
			dst = aDst;
		}
	}

	public void add(long srcId, long dstId)
	{
		BasicBlockPair basicBlockPair = new BasicBlockPair(srcId, dstId);
		defUseEdges.add(basicBlockPair);
	};

	

}
