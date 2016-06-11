package neo4j.traversals.batchInserter;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;

public class AST
{

	public static boolean isASTEdge(BatchRelationship rel)
	{
		return Elementary.isEdgeOfType(rel, EdgeTypes.IS_AST_PARENT);
	}

	public static String getCalleeFromCall(Long nodeId)
	{
		Iterable<BatchRelationship> rels = Elementary.getEdges(nodeId);
		for (BatchRelationship rel : rels)
		{
			if (Elementary.isIncomingEdge(nodeId, rel))
				continue;
			if (!isASTEdge(rel))
				continue;

			long endNode = rel.getEndNode();
			String childNum = Elementary.getNodeProperty(endNode,
					NodeKeys.CHILD_NUMBER);

			if (childNum == null || childNum.equals("0"))
				return Elementary.getNodeCode(endNode);
		}
		return "";
	}

}
