package cfg;

import java.util.List;

import misc.MultiHashMap;

public class Edges extends MultiHashMap
{
	public void addEdge(StatementOrCondition src, StatementOrCondition dst)
	{
		add(src, dst);
	}

	public List<Object> getEdgesFrom(StatementOrCondition src)
	{
		return getListForKey(src);
	}
	
	public void addEdges(Edges otherEdges)
	{
		addMultiHashMap(otherEdges);
	}

	public void removeEdge(StatementOrCondition src, StatementOrCondition dst)
	{
		remove(src, dst);
	}
	
	public void removeAllEdgesFrom(StatementOrCondition src)
	{
		removeAllForKey(src);
	}
	
}
