package tools.ddg;

import java.util.HashMap;
import java.util.List;

import misc.MultiHashMap;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.QueryUtils;

public class DDGCreator {

	HashMap<Long, Boolean> edgeVisited = new HashMap<Long, Boolean>();
	MultiHashMap defStacks = new MultiHashMap();
	DDG ddg;
	
	public DDG create(Long funcId)
	{
		ddg = new DDG();		
		
		long cfgRootId = QueryUtils.getCFGFromFunction(funcId);
		if(cfgRootId == -1){
			System.err.println("Warning: Function without CFG. Skipping.");
			return null;
		}
		
		traverse(cfgRootId);
		
		return ddg;
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
		
			Long topBasicBlockId = (Long) stackForSymbol.get(stackForSymbol.size() -1);						
			ddg.add(topBasicBlockId, nodeId, symbol);		
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
