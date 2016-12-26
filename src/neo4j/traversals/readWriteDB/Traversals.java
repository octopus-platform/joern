package neo4j.traversals.readWriteDB;

import java.util.LinkedList;
import java.util.List;

import misc.Pair;
import neo4j.readWriteDB.Neo4JDBInterface;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.NotFoundException;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.index.IndexHits;

import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;
import ddg.DataDependenceGraph.DDG;

public class Traversals
{

	public static IndexHits<Node> getStatementsForFunction(Node funcNode)
	{
		String query = String.format("%s:True AND %s:%d", NodeKeys.IS_CFG_NODE,
				NodeKeys.FUNCTION_ID, funcNode.getId());

		return Neo4JDBInterface.queryIndex(query);
	}

	public static List<Pair<Long, String>> getSymbolsDefinedByStatement(
			Long statementId)
	{
		Node node = Neo4JDBInterface.getNodeById(statementId);
		return getIdAndCodeOfChildrenConnectedBy(node, "DEF");
	}

	public static List<Pair<Long, String>> getSymbolsUsedByStatement(
			Long statementId)
	{
		Node node = Neo4JDBInterface.getNodeById(statementId);
		return getIdAndCodeOfChildrenConnectedBy(node, "USE");
	}

	public static List<String> getCodeOfChildrenConnectedBy(Node node,
			String edgeType)
	{
		List<String> retval = new LinkedList<String>();

		List<Node> children = getChildrenConnectedBy(node, edgeType);
		for (Node childNode : children)
		{
			String childCode = childNode.getProperty(NodeKeys.CODE).toString();
			retval.add(childCode);
		}
		return retval;
	}

	public static List<Pair<Long, String>> getIdAndCodeOfChildrenConnectedBy(
			Node node, String edgeType)
	{
		List<Pair<Long, String>> retval = new LinkedList<Pair<Long, String>>();
		List<Node> children = getChildrenConnectedBy(node, edgeType);

		for (Node childNode : children)
		{
			String childCode = childNode.getProperty(NodeKeys.CODE).toString();
			Pair<Long, String> pair = new Pair<Long, String>(childNode.getId(),
					childCode);
			retval.add(pair);
		}

		return retval;
	}

	public static List<Node> getChildrenConnectedBy(Node node, String edgeType)
	{
		List<Node> retval = new LinkedList<Node>();

		long nodeId = node.getId();

		Iterable<Relationship> rels = node.getRelationships();
		for (Relationship rel : rels)
		{
			if (!rel.getType().name().equals(edgeType))
				continue;
			Node childNode = rel.getEndNode();
			if (childNode.getId() == nodeId)
				continue;

			retval.add(childNode);
		}
		return retval;
	}

	public static List<Node> getParentsConnectedBy(Node node, String edgeType)
	{
		List<Node> retval = new LinkedList<Node>();

		long nodeId = node.getId();

		Iterable<Relationship> rels = node.getRelationships();
		for (Relationship rel : rels)
		{
			if (!rel.getType().name().equals(edgeType))
				continue;
			Node parentNode = rel.getStartNode();
			if (parentNode.getId() == nodeId)
				continue;

			retval.add(parentNode);
		}
		return retval;
	}

	public static List<Node> getCallsTo(String source)
	{
		List<Node> retval = new LinkedList<Node>();

		String query = String.format("%s:CallExpression AND %s:%s" + "*",
				NodeKeys.TYPE, NodeKeys.CODE, source);
		IndexHits<Node> hits = Neo4JDBInterface.queryIndex(query);
		for (Node n : hits)
		{
			if (n.getProperty(NodeKeys.CODE).toString()
					.startsWith(source + " "))
				retval.add(n);
		}
		return retval;
	}

	public static List<Node> getCallsToForFunction(String source,
			long functionId)
	{
		List<Node> retval = new LinkedList<Node>();

		String query = String.format("%s:CallExpression AND %s:%d AND %s:%s"
				+ "*", NodeKeys.TYPE, NodeKeys.FUNCTION_ID, functionId,
				NodeKeys.CODE, source);

		IndexHits<Node> hits = Neo4JDBInterface.queryIndex(query);
		for (Node n : hits)
		{
			if (n.getProperty(NodeKeys.CODE).toString()
					.startsWith(source + " "))
				retval.add(n);
		}
		return retval;
	}

	public static DDG getDDGForFunction(Node funcNode)
	{
		DDG retval = new DDG();
		for (Node statement : Traversals.getStatementsForFunction(funcNode))
		{
			Iterable<Relationship> rels = statement
					.getRelationships(Direction.OUTGOING);
			long srcId = statement.getId();

			for (Relationship rel : rels)
			{
				if (!rel.getType().toString().equals(EdgeTypes.REACHES))
					continue;
				long dstId = rel.getEndNode().getId();
				String symbol = rel.getProperty("var").toString();
				retval.add(srcId, dstId, symbol);
			}

		}
		return retval;
	}

	// The two following functions are somewhat disgraceful
	// but should work for now.

	public static Node getStatementForASTNode(Node node)
	{
		Node n = node;
		Node parent = node;

		while (true)
		{

			try
			{
				Object property = n.getProperty(NodeKeys.IS_CFG_NODE);
				return n;
			}
			catch (NotFoundException ex)
			{

			}

			Iterable<Relationship> rels = n
					.getRelationships(Direction.INCOMING);
			for (Relationship rel : rels)
			{
				parent = rel.getStartNode();
				break;
			}

			if (n == parent)
				return null;
			n = parent;
		}
	}

	public static String getNthArgCodeOfCall(Node callNode, int n)
	{
		String nStr = String.format("%d", n);

		Iterable<Relationship> rels = callNode
				.getRelationships(Direction.OUTGOING);
		for (Relationship rel : rels)
		{

			if (!rel.getType().toString().equals(EdgeTypes.IS_AST_PARENT))
				continue;

			Node endNode = rel.getEndNode();
			String childNum;

			try
			{
				childNum = (String) endNode.getProperty(NodeKeys.CHILD_NUMBER);
			}
			catch (RuntimeException ex)
			{
				childNum = "0";
			}

			if (childNum.equals("1"))
			{
				// found argument list
				Node argList = rel.getEndNode();
				Iterable<Relationship> rels2 = argList
						.getRelationships(Direction.OUTGOING);
				for (Relationship rel2 : rels2)
				{
					if (!rel2.getType().toString()
							.equals(EdgeTypes.IS_AST_PARENT))
						continue;

					String childNum2;
					try
					{
						childNum2 = (String) rel2.getEndNode().getProperty(
								NodeKeys.CHILD_NUMBER);
					}
					catch (RuntimeException ex)
					{
						childNum2 = "0";
					}

					if (childNum2.equals(nStr))
						return rel2.getEndNode().getProperty(NodeKeys.CODE)
								.toString();
				}
			}
		}
		return null;
	}

	public static Long getFunctionIdFromASTNode(Node astNode)
	{
		return Long.valueOf(astNode.getProperty(NodeKeys.FUNCTION_ID)
				.toString());
	}

	public static IndexHits<Node> getFunctionsByName(String functionName)
	{
		return Neo4JDBInterface.queryIndex(NodeKeys.NAME + ":" + functionName);
	}

	public static Node getASTForStatement(Node statement)
	{
		return statement;
	}

	public static String getNodeType(Long nodeId)
	{
		Node node = Neo4JDBInterface.getNodeById(nodeId);
		return node.getProperty(NodeKeys.TYPE).toString();

	}

	public static String getCalleeFromCall(Long nodeId)
	{
		Node node = Neo4JDBInterface.getNodeById(nodeId);
		Iterable<Relationship> rels = node.getRelationships();
		for (Relationship rel : rels)
		{
			if (!rel.getType().name().equals(EdgeTypes.IS_AST_PARENT))
				continue;

			Node endNode = rel.getEndNode();

			if (endNode.getId() == node.getId())
				continue;

			try
			{
				String childNumStr = (String) endNode
						.getProperty(NodeKeys.CHILD_NUMBER);
				if (childNumStr.equals("0"))
					return endNode.getProperty(NodeKeys.CODE).toString();
			}
			catch (RuntimeException ex)
			{
				return endNode.getProperty(NodeKeys.CODE).toString();
			}
		}
		return "";
	}

	public static String getNodeCode(long nodeId)
	{
		Node node = Neo4JDBInterface.getNodeById(nodeId);
		return node.getProperty(NodeKeys.CODE).toString();
	}

	public static String getOperatorCode(long nodeId)
	{
		Node node = Neo4JDBInterface.getNodeById(nodeId);
		return node.getProperty(NodeKeys.OPERATOR).toString();
	}

	public static int getNodeChildNum(long nodeId)
	{
		Node node = Neo4JDBInterface.getNodeById(nodeId);
		String childNumStr = (String) node.getProperty(NodeKeys.CHILD_NUMBER,
				null);
		if (childNumStr == null)
			return 0;
		return Integer.parseInt(childNumStr);
	}

}
