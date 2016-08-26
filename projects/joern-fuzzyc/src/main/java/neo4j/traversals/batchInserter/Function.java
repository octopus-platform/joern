package neo4j.traversals.batchInserter;

import org.neo4j.graphdb.index.IndexHits;

import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;
import neo4j.batchInserter.Neo4JBatchInserter;

public class Function
{

	public static IndexHits<Long> getFunctionsByName(String functionName)
	{
		return Neo4JBatchInserter
				.queryIndex(NodeKeys.CODE + ":" + functionName);
	}

	public static long getCFGForFunction(Long funcId)
	{
		return Elementary.getFirstChildWithEdgeType(funcId,
				EdgeTypes.IS_FUNCTION_OF_CFG);
	}

}
