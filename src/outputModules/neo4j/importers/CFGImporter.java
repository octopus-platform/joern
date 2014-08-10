package outputModules.neo4j.importers;

import java.util.Map;

import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import cfg.CFG;
import cfg.CFGEdge;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import databaseNodes.EdgeTypes;
import databaseNodes.FunctionDatabaseNode;
import databaseNodes.NodeKeys;

public class CFGImporter
{

	GraphNodeStore nodeStore;
	private FunctionDatabaseNode currentFunction;

	public CFGImporter(GraphNodeStore aNodeStore)
	{
		nodeStore = aNodeStore;
	}

	public void setCurrentFunction(FunctionDatabaseNode func)
	{
		currentFunction = func;
	}

	public void addCFGToDatabase(CFG cfg)
	{
		if (cfg == null)
			return;

		createEmptyCFGNodes(cfg);
		addCFGEdges(cfg);
	}

	private void createEmptyCFGNodes(CFG cfg)
	{
		// This deserves some explanation:
		// Our CFG creation code currently inserts empty-blocks
		// in some places, e.g., nodes that join prior control-flows.
		// These nodes do not have to exist in theory but as long
		// as we have them in our CFG, we need to create corresponding
		// database nodes when importing the CFG. All other CFG nodes
		// are nodes of the AST and hence are already in the database.

		for (CFGNode statement : cfg.getVertices())
		{

			Map<String, Object> properties;
			if (statement instanceof ASTNodeContainer)
			{
				// nothing to do for nodes that have already
				// been imported by the ASTImporter.
				continue;
			}
			else
			{
				properties = statement.getProperties();
			}
			properties.put(NodeKeys.FUNCTION_ID,
					nodeStore.getIdForObject(currentFunction));
			nodeStore.addNeo4jNode(statement, properties);
			nodeStore.indexNode(statement, properties);
		}
	}

	private void addCFGEdges(CFG cfg)
	{
		Object src;
		Object dst;
		for (CFGEdge edge : cfg.getEdges())
		{
			src = edge.getSource();
			dst = edge.getDestination();
			if (src instanceof ASTNodeContainer)
				src = ((ASTNodeContainer) src).getASTNode();
			if (dst instanceof ASTNodeContainer)
				dst = ((ASTNodeContainer) dst).getASTNode();
			addFlowToLink(src, dst, edge.getProperties());
		}
	}

	private void addFlowToLink(Object srcBlock, Object dstBlock,
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
