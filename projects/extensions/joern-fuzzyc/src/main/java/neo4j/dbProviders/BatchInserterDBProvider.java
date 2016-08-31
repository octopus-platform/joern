package neo4j.dbProviders;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import databaseNodes.NodeKeys;
import misc.Pair;
import neo4j.traversals.batchInserter.AST;
import neo4j.traversals.batchInserter.Elementary;

public class BatchInserterDBProvider extends DBProvider
{
	@Override
	public String getNodeType(Long nodeId)
	{
		return Elementary.getNodeType(nodeId);
	}

	@Override
	public String getCalleeFromCall(Long nodeId)
	{
		return AST.getCalleeFromCall(nodeId);
	}

	@Override
	public List<Pair<Long, Integer>> getASTChildren(Long nodeId)
	{
		Iterable<BatchRelationship> rels = Elementary.getEdges(nodeId);
		List<Pair<Long, Integer>> retval = new LinkedList<Pair<Long, Integer>>();

		for (BatchRelationship rel : rels)
		{
			if (Elementary.isIncomingEdge(nodeId, rel))
				continue;
			if (!AST.isASTEdge(rel))
				continue;

			long childId = rel.getEndNode();
			String childNumStr = Elementary.getNodeProperty(childId,
					NodeKeys.CHILD_NUMBER);
			Integer childNumber;
			if (childNumStr != null)
				childNumber = Integer.parseInt(childNumStr);
			else
				childNumber = 0;

			retval.add(new Pair<Long, Integer>(childId, childNumber));
		}
		return retval;
	}

	@Override
	public String getNodeCode(long nodeId)
	{
		return Elementary.getNodeCode(nodeId);
	}

	@Override
	public String getOperatorCode(long nodeId)
	{
		return Elementary.getOperatorCode(nodeId);
	}

	@Override
	public int getChildNumber(long nodeId)
	{
		String childNumStr = Elementary.getNodeProperty(nodeId,
				NodeKeys.CHILD_NUMBER);
		if (childNumStr == null)
			return 0;
		return Integer.parseInt(childNumStr);
	}
}
