package neo4j.traversals.batchInserter;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;
import neo4j.batchInserter.Neo4JBatchInserter;

public class CFG
{

	public static List<String> getSymbolsUsedByStatement(long nodeId)
	{
		return Elementary.getCodeOfChildrenConnectedBy(nodeId, EdgeTypes.USE);
	}

	public static List<String> getSymbolsDefinedByStatement(long nodeId)
	{
		return Elementary.getCodeOfChildrenConnectedBy(nodeId, EdgeTypes.DEF);
	}

	public static IndexHits<Long> getStatementsFromIndex(long functionId)
	{
		String query = String.format("%s:True AND %s:%d", NodeKeys.IS_CFG_NODE,
				NodeKeys.FUNCTION_ID, functionId);

		return Neo4JBatchInserter.queryIndex(query);
	}

	public static List<Long> getParentStatements(Long statementId)
	{
		List<Long> retval = new LinkedList<Long>();
		Iterable<BatchRelationship> rels = Elementary.getEdges(statementId);

		for (BatchRelationship rel : rels)
		{
			if (!Elementary.isEdgeOfType(rel, EdgeTypes.FLOWS_TO))
				continue;
			if (rel.getStartNode() == statementId)
				continue;
			retval.add(rel.getStartNode());
		}
		return retval;
	}

	public static List<Long> getChildStatements(Long statementId)
	{
		List<Long> retval = new LinkedList<Long>();
		Iterable<BatchRelationship> rels = Elementary.getEdges(statementId);
		for (BatchRelationship rel : rels)
		{
			if (!Elementary.isEdgeOfType(rel, EdgeTypes.FLOWS_TO))
				continue;
			if (rel.getEndNode() == statementId)
				continue;
			retval.add(rel.getEndNode());
		}
		return retval;
	}

}
