package outputModules.neo4j.exporters;

import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import ast.ASTNode;
import databaseNodes.ASTDatabaseNode;
import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;
import outputModules.common.ASTExporter;

public class Neo4JASTExporter extends ASTExporter
{
	GraphNodeStore nodeStore;

	public Neo4JASTExporter(GraphNodeStore aNodeStore)
	{
		nodeStore = aNodeStore;
	}

	public void addASTToDatabase(ASTNode node)
	{
		addASTNode(node);
		addASTChildren(node);
	}

	@Override
	protected void addASTChildren(ASTNode node)
	{
		final int nChildren = node.getChildCount();

		// HACK: not sure why, but adding AST-links backwards
		// results in the edges being returned in the
		// correct order by the database.

		for (int i = nChildren - 1; i >= 0; i--)
		{
			ASTNode child = node.getChild(i);
			addASTToDatabase(child);
			addASTLink(node, child);
		}
	}

	@Override
	protected void addASTNode(ASTNode node)
	{
		ASTDatabaseNode astDatabaseNode = new ASTDatabaseNode();
		astDatabaseNode.initialize(node);
		astDatabaseNode.setCurrentFunction(currentFunction);
		Map<String, Object> properties = astDatabaseNode.createProperties();

		properties.put(NodeKeys.FUNCTION_ID,
				nodeStore.getIdForObject(currentFunction));
		nodeStore.addNeo4jNode(node, properties);

		indexASTNode(node, properties);

	}

	private void indexASTNode(ASTNode node, Map<String, Object> properties)
	{
		nodeStore.indexNode(node, properties);
	}

	@Override
	protected void addASTLink(ASTNode parent, ASTNode child)
	{
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.IS_AST_PARENT);

		long parentId = nodeStore.getIdForObject(parent);
		long childId = nodeStore.getIdForObject(child);
		Map<String, Object> properties = null;

		Neo4JBatchInserter.addRelationship(parentId, childId, rel, properties);
	}

}
