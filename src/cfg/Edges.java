package cfg;

import java.util.List;

import misc.MultiHashMap;

public class Edges extends MultiHashMap
{
	public void addEdge(Object src, Object dst)
	{
		add(src, dst);
	}

	public List<Object> getEdgesFrom(CFGNode src)
	{
		return getListForKey(src);
	}
	
	public void addEdges(Edges otherEdges)
	{
		addMultiHashMap(otherEdges);
	}

	public void removeEdge(CFGNode src, CFGNode dst)
	{
		remove(src, dst);
	}
	
	public void removeAllEdgesFrom(CFGNode src)
	{
		removeAllForKey(src);
	}
	
}
