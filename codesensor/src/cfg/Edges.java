package cfg;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Edges {

	HashMap<BasicBlock, Collection<BasicBlock>> edges =
			new HashMap<BasicBlock, Collection<BasicBlock>>();

	void addEdge(BasicBlock src, BasicBlock dst)
	{
		Collection<BasicBlock> dstList = edges.get(src);
		if(dstList == null){
			dstList = new LinkedList<BasicBlock>();
			edges.put(src, dstList);
		}
		dstList.add(dst);
	}

	public void addEdges(Edges otherEdges)
	{
		Set<Entry<BasicBlock, Collection<BasicBlock>>> entrySet = otherEdges.edges.entrySet();
		Iterator<Entry<BasicBlock, Collection<BasicBlock>>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<BasicBlock, Collection<BasicBlock>> pair = it.next();
			Iterator<BasicBlock> it2 = pair.getValue().iterator();
			while(it2.hasNext()){
				addEdge(pair.getKey(), it2.next());
			}
		}
	}

	public void removeEdge(BasicBlock src, BasicBlock dst)
	{
		Collection<BasicBlock> dstList = edges.get(src);
		if(dstList == null)
			return;
		dstList.remove(dst);
	}
	
	public int size()
	{
		int s = 0;
		Set<Entry<BasicBlock, Collection<BasicBlock>>> entrySet = edges.entrySet();
		Iterator<Entry<BasicBlock, Collection<BasicBlock>>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<BasicBlock, Collection<BasicBlock>> pair = it.next();
			s += pair.getValue().size();
		}
		return s;
	}
	
	
	
}
