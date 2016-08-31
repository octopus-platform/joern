package neo4j.traversals.batchInserter;

import org.neo4j.graphdb.index.IndexHits;

import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;
import neo4j.batchInserter.Neo4JBatchInserter;

public class Function
{

	public static IndexHits<Long> getFunctionsByName(String functionName)
	{
		String query = String.format("%s:%s AND %s:Function", NodeKeys.CODE, functionName, NodeKeys.NODE_TYPE);
		System.out.println(query);
		return Neo4JBatchInserter
				.queryIndex(query);
	}

	public static long getCFGForFunction(Long funcId)
	{
		return Elementary.getFirstChildWithEdgeType(funcId,
				EdgeTypes.IS_FUNCTION_OF_CFG);
	}

}
