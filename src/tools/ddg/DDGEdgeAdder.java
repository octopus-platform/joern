package tools.ddg;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.QueryUtils;

public class DDGEdgeAdder {

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
			
			if(QueryUtils.isIncomingEdge(nodeId, rel)) continue;
			if(!QueryUtils.isCFGEdge(rel)) continue;
		
			long childId = rel.getEndNode();
			traverse(childId);		
		}			
	}

}
