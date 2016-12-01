package neo4j.traversals.batchInserter;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import databaseNodes.NodeKeys;
import neo4j.batchInserter.Neo4JBatchInserter;

public class Elementary
{
	public static boolean isIncomingEdge(Long nodeId, BatchRelationship rel)
	{
		return rel.getEndNode() == nodeId;
	}

	public static Iterable<BatchRelationship> getEdges(Long nodeId)
	{
		return Neo4JBatchInserter.getRelationships(nodeId);
	}

	// there's probably a more efficient way of doing this
	public static boolean isEdgeOfType(BatchRelationship rel, String typeStr)
	{
		return rel.getType().name().equals(typeStr);
	}

	public static String getNodeCode(Long nodeId)
	{
		return (String) Neo4JBatchInserter.getNodeProperties(nodeId)
				.get(NodeKeys.CODE);
	}

	public static String getOperatorCode(Long nodeId)
	{
		return getNodeProperty(nodeId, NodeKeys.OPERATOR);
	}

	public static String getNodeType(Long nodeId)
	{
		return getNodeProperty(nodeId, NodeKeys.NODE_TYPE);
	}

	public static String getNodeProperty(Long nodeId, String property)
	{
		try
		{
			return Neo4JBatchInserter.getNodeProperties(nodeId).get(property)
					.toString();
		} catch (RuntimeException ex)
		{
			return null;
		}
	}

	public static long getFirstChildWithEdgeType(Long nodeId, String edgeType)
	{
		Iterable<BatchRelationship> rels = getEdges(nodeId);
		for (BatchRelationship rel : rels)
		{
			if (isEdgeOfType(rel, edgeType))
				return rel.getEndNode();
		}
		return -1;
	}

	public static List<String> getCodeOfChildrenConnectedBy(long nodeId,
			String edgeType)
	{
		List<String> retval = new LinkedList<String>();

		Iterable<BatchRelationship> rels = getEdges(nodeId);
		for (BatchRelationship rel : rels)
		{
			if (!isEdgeOfType(rel, edgeType))
				continue;
			String identifierStr = getNodeCode(rel.getEndNode());
			retval.add(identifierStr);
		}
		return retval;
	}

}
