package traversals.batchInserter;

import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.EdgeTypes;
import output.neo4j.batchInserter.Neo4JBatchInserter;

public class Function
{

	public static IndexHits<Long> getFunctionsByName(String functionName)
	{
		return Neo4JBatchInserter.queryIndex("functionName:" + functionName);
	}
	
	public static long getCFGForFunction(Long funcId)
	{
		long cfgNodeId = Elementary.getFirstChildWithEdgeType(funcId, EdgeTypes.IS_FUNCTION_OF_CFG);
		return Elementary.getFirstChildWithEdgeType(cfgNodeId, EdgeTypes.IS_CFG_OF_CFG_ROOT);
	}
	
}
