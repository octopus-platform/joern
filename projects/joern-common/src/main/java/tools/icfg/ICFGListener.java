package tools.icfg;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import databaseNodes.EdgeTypes;
import neo4j.batchInserter.ImportedNodeListener;
import neo4j.batchInserter.Neo4JBatchInserter;

public class ICFGListener extends ImportedNodeListener
{

	CallResolver resolver = new CallResolver();

	@Override
	public void visitNode(Long callNodeId)
	{
		List<Long> arguments = getArgumentsByCallId(callNodeId);
		if (arguments == null)
			return;

		IndexHits<Long> dstIds = resolver.resolveByCallId(callNodeId);
		if (dstIds == null)
			return;

		connectArgumentsToDestinations(callNodeId, arguments, dstIds);
	}

	private List<Long> getArgumentsByCallId(Long callNodeId)
	{
		long argumentListId = getArgumentListByCallId(callNodeId);
		if (argumentListId == -1)
			return null;

		return getArgsFromArgList(argumentListId);
	}

	private void connectArgumentsToDestinations(Long callNodeId,
			List<Long> arguments, IndexHits<Long> dstIds)
	{
		for (Long dst : dstIds)
		{
			List<Long> parameters = getParametersByFunctionId(dst);
			if (parameters == null)
				continue;
			addArgParamEdges(callNodeId, arguments, parameters);
		}
	}

	private List<Long> getParametersByFunctionId(Long dst)
	{

		String query = "type:\"ParameterList\" AND functionId:\"" + dst + "\"";
		IndexHits<Long> hits = Neo4JBatchInserter.queryIndex(query);

		if (hits == null)
			return null;

		if (hits.size() != 1)
			throw (new RuntimeException(
					"Warning: Parameterlist not found or more than one."));

		Long parameterListId = hits.next();
		List<Long> params = getParametersFromList(parameterListId);
		return getIdentifiersFromParams(params);
	}

	private void addArgParamEdges(Long callNodeId, List<Long> arguments,
			List<Long> parameters)
	{
		if (parameters.size() != arguments.size())
			return;

		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.IS_ARG);
		for (int i = 0; i < arguments.size(); i++)
			Neo4JBatchInserter.addRelationship(arguments.get(i),
					parameters.get(i), rel, null);

	}

	private List<Long> getArgsFromArgList(long argumentListId)
	{
		return getChildrenByNodeId(argumentListId);
	}

	private long getArgumentListByCallId(Long callNodeId)
	{
		Iterable<BatchRelationship> rels = Neo4JBatchInserter
				.getRelationships(callNodeId);
		for (BatchRelationship rel : rels)
		{
			long childId = rel.getEndNode();

			if (childId == callNodeId)
				continue;

			String childType = (String) Neo4JBatchInserter
					.getNodeProperties(childId).get("type");

			if (childType.equals("ArgumentList"))
				return childId;
		}

		return -1;
	}

	private List<Long> getIdentifiersFromParams(List<Long> params)
	{
		List<Long> retval = new LinkedList<Long>();

		for (Long paramId : params)
		{
			Iterable<BatchRelationship> rels = Neo4JBatchInserter
					.getRelationships(paramId);
			for (BatchRelationship rel : rels)
			{
				if (rel.getEndNode() == paramId)
					continue;

				long identifierNode = rel.getEndNode();
				Object type = Neo4JBatchInserter
						.getNodeProperties(identifierNode).get("type");
				if (type.equals("Identifier"))
				{
					retval.add(identifierNode);
					break;
				}
			}
		}

		return retval;
	}

	private List<Long> getParametersFromList(Long parameterListId)
	{
		return getChildrenByNodeId(parameterListId);
	}

	private List<Long> getChildrenByNodeId(Long nodeId)
	{
		List<Long> retval = new LinkedList<Long>();
		Iterable<BatchRelationship> rels = Neo4JBatchInserter
				.getRelationships(nodeId);

		for (BatchRelationship rel : rels)
		{
			if (rel.getEndNode() == nodeId)
				continue;
			long childId = rel.getEndNode();
			retval.add(childId);
		}
		return retval;
	}

}
