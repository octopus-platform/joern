package outputModules.neo4j.exporters;

import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import ast.statements.ExpressionStatement;
import cfg.nodes.CFGNode;
import databaseNodes.EdgeTypes;
import databaseNodes.FunctionDatabaseNode;
import databaseNodes.NodeKeys;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;
import outputModules.common.CFGExporter;

public class Neo4JCFGExporter extends CFGExporter
{

	GraphNodeStore nodeStore;
	private FunctionDatabaseNode currentFunction;

	public Neo4JCFGExporter(GraphNodeStore aNodeStore)
	{
		nodeStore = aNodeStore;
	}

	public void setCurrentFunction(FunctionDatabaseNode func)
	{
		currentFunction = func;
	}

	@Override
	protected void writeCFGNode(CFGNode statement,
			Map<String, Object> properties)
	{
		properties.put(NodeKeys.FUNCTION_ID,
				nodeStore.getIdForObject(currentFunction));
		nodeStore.addNeo4jNode(statement, properties);
		nodeStore.indexNode(statement, properties);
	}

	@Override
	protected void addFlowToLink(Object srcBlock, Object dstBlock,
			Map<String, Object> properties)
	{
		long srcId = nodeStore.getIdForObject(srcBlock);
		long dstId = nodeStore.getIdForObject(dstBlock);

		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.FLOWS_TO);
		// Map<String, Object> properties = null;
		Neo4JBatchInserter.addRelationship(srcId, dstId, rel, properties);
	}

}
