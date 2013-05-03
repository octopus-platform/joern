package cfg;

import java.util.List;

public class Edges extends MultiHashMap
{
	public void addEdge(BasicBlock src, BasicBlock dst)
	{
		add(src, dst);
	}

	public List<Object> getEdgesFrom(BasicBlock src)
	{
		return getListForKey(src);
	}
	
	public void addEdges(Edges otherEdges)
	{
		addMultiHashMap(otherEdges);
	}

	public void removeEdge(BasicBlock src, BasicBlock dst)
	{
		remove(src, dst);
	}
	
	public void removeAllEdgesFrom(BasicBlock src)
	{
		removeAllForKey(src);
	}
	
}
