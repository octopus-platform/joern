package cfg;

import java.util.List;

import misc.MultiHashMap;

public class Edges extends MultiHashMap<Object,Object>
{
	public void addEdge(Object src, Object dst)
	{
		add(src, dst);
	}

	public List<Object> getEdgesFrom(CFGNode src)
	{
		return get(src);
	}
	
	public void addEdges(Edges otherEdges)
	{
		addAll(otherEdges);
	}

	public void removeEdge(CFGNode src, CFGNode dst)
	{
		remove(src, dst);
	}
	
	public void removeAllEdgesFrom(CFGNode src)
	{
		removeAll(src);
	}
	
}
