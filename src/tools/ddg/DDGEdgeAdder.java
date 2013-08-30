package tools.ddg;

import java.util.HashMap;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.QueryUtils;

public class DDGEdgeAdder {

	HashMap<Long, Boolean> visited = new HashMap<Long, Boolean>();
	
	public void addEdges(Long funcId)
	{
		// get the CFG root node for the function
		// traverse the CFG
		// Keep a stack of defs for each variable
		// So, we need something that maps Ids to Stacks.
	
		long cfgRootId = QueryUtils.getCFGFromFunction(funcId);
		if(cfgRootId == -1){
			System.err.println("Warning: Function without CFG. Skipping.");
			return;
		}
		
		traverse(cfgRootId);
		
	}

	private void traverse(long nodeId)
	{
		traverseChildren(nodeId);
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
		visited.put(edgeId, true);
	}

	private boolean hasBeenExpanded(long edgeId)
	{
		return visited.containsKey(edgeId);
	}

}
