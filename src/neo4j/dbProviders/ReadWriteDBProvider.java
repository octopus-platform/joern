package neo4j.dbProviders;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;
import misc.Pair;
import neo4j.readWriteDB.Neo4JDBInterface;
import neo4j.traversals.readWriteDB.Traversals;

public class ReadWriteDBProvider extends DBProvider
{

	@Override
	public String getNodeType(Long nodeId)
	{
		return Traversals.getNodeType(nodeId);
	}

	@Override
	public String getCalleeFromCall(Long nodeId)
	{
		return Traversals.getCalleeFromCall(nodeId);
	}

	@Override
	public List<Pair<Long, Integer>> getASTChildren(Long nodeId)
	{
		List<Pair<Long, Integer>> retval = new LinkedList<Pair<Long, Integer>>();
		Node node = Neo4JDBInterface.getNodeById(nodeId);

		Iterable<Relationship> rels = node.getRelationships();

		for (Relationship rel : rels)
		{
			Node endNode = rel.getEndNode();
			int childNumber;

			if (endNode.getId() == node.getId())
				continue;
			if (!rel.getType().name().equals(EdgeTypes.IS_AST_PARENT))
				continue;

			long childId = endNode.getId();

			String childNum = null;
			try
			{
				childNum = (String) endNode.getProperty(NodeKeys.CHILD_NUMBER);
			} catch (RuntimeException ex)
			{
			}

			if (childNum == null)
				childNumber = 0;
			else
				childNumber = Integer.parseInt(childNum);

			retval.add(new Pair<Long, Integer>(childId, childNumber));
		}

		return retval;
	}

	@Override
	public String getNodeCode(long nodeId)
	{
		return Traversals.getNodeCode(nodeId);
	}

	@Override
	public String getOperatorCode(long nodeId)
	{
		return Traversals.getOperatorCode(nodeId);
	}

	@Override
	public int getChildNumber(long nodeId)
	{
		return Traversals.getNodeChildNum(nodeId);
	}

}
