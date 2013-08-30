package tools.ddg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import misc.MultiHashMap;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.QueryUtils;

public class DDGEdgeAdder {

	HashMap<Long, Boolean> edgeVisited = new HashMap<Long, Boolean>();
	MultiHashMap defStacks = new MultiHashMap();
	List<BasicBlockPair> defUseEdges = new LinkedList<BasicBlockPair>();
	
	public class BasicBlockPair{		
		public long src;
		public long dst;
		
		public BasicBlockPair(Long aSrc, long aDst)
		{
			src = aSrc;
			dst = aDst;
		}
	};
	
	public void addEdges(Long funcId)
	{
		long cfgRootId = QueryUtils.getCFGFromFunction(funcId);
		if(cfgRootId == -1){
			System.err.println("Warning: Function without CFG. Skipping.");
			return;
		}
		
		traverse(cfgRootId);
		
	}

	private void traverse(long nodeId)
	{
		updateDefUseEdges(nodeId);
		updateDefStacks(nodeId);
		traverseChildren(nodeId);
	}

	private void updateDefUseEdges(long nodeId)
	{						
		List<String> symbolsUsed =
				QueryUtils.getSymbolsUsedByBasicBlock(nodeId);
				
		for(String symbol : symbolsUsed){
			List<Object> stackForSymbol = defStacks.getListForKey(symbol);
			if(stackForSymbol == null || stackForSymbol.size() == 0)
				continue;			
		
			Long topBasicBlock = (Long) stackForSymbol.get(stackForSymbol.size() -1);
			BasicBlockPair basicBlockPair = new BasicBlockPair(topBasicBlock, nodeId);
			defUseEdges.add(basicBlockPair);
		}				
	}

	private void updateDefStacks(long nodeId)
	{
		List<String> symbolsDefined = QueryUtils.getSymbolsDefinedByBasicBlock(nodeId);		
		// for each defined symbol, add basicblock to defstack
		for(String symbol : symbolsDefined){
			defStacks.add(symbol, nodeId);
		}
	}

	private void traverseChildren(long nodeId)
	{
		Iterable<BatchRelationship> rels = QueryUtils.getEdges(nodeId);
		
		for(BatchRelationship rel : rels){
			
			long edgeId = rel.getId();
			if(hasBeenExpanded(edgeId)) continue;
			
			if(QueryUtils.isIncomingEdge(nodeId, rel)) continue;
			if(!QueryUtils.isCFGEdge(rel)) continue;
		
			markAsExpanded(edgeId);
			
			long childId = rel.getEndNode();
			traverse(childId);		
		}			
	}

	private void markAsExpanded(long edgeId)
	{
		edgeVisited.put(edgeId, true);
	}

	private boolean hasBeenExpanded(long edgeId)
	{
		return edgeVisited.containsKey(edgeId);
	}

}
