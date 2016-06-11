package outputModules.neo4j.exporters;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import databaseNodes.EdgeTypes;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;
import outputModules.common.CDGExporter;

public class Neo4JCDGExporter extends CDGExporter
{

	GraphNodeStore nodeStore;

	public Neo4JCDGExporter(GraphNodeStore nodeStore)
	{
		this.nodeStore = nodeStore;
	}

	@Override
	protected void addControlsEdge(CFGNode src, CFGNode dst)
	{
		RelationshipType rel;
		rel = DynamicRelationshipType.withName(EdgeTypes.CONTROLS);
		Neo4JBatchInserter.addRelationship(getId(src), getId(dst), rel, null);
	}

	private long getId(CFGNode node)
	{
		if (node instanceof ASTNodeContainer)
		{
			return nodeStore
					.getIdForObject(((ASTNodeContainer) node).getASTNode());
		}
		else
		{
			return nodeStore.getIdForObject(node);
		}
	}

}
