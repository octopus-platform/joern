package tools.ddg;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.Neo4JBatchInserter;
import output.neo4j.QueryUtils;

public class DDGEdgeAdder {

	public void addEdges(Long funcId)
	{
		// get the CFG root node for the function
		// traverse the CFG
		// Keep a stack of defs for each variable
		// So, we need something that maps Ids to Stacks.
	
		long cfgRootId = QueryUtils.getCFGFromFunction(funcId);
		
	}

}
