package outputModules.neo4j.exporters;

import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import outputModules.common.CDGExporter;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import databaseNodes.EdgeTypes;

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

	@Override
	protected void addPostDomEdge(CFGNode vertex, CFGNode dominator)
	{
		RelationshipType rel;
		rel = DynamicRelationshipType.withName(EdgeTypes.POST_DOM);
		Neo4JBatchInserter.addRelationship(getId(dominator), getId(vertex), rel,
				null);
	}

	private long getId(CFGNode node)
	{
		if (node instanceof ASTNodeContainer)
		{
			return nodeStore
					.getIdForObject(((ASTNodeContainer) node).getASTNode());
		} else
		{
			return nodeStore.getIdForObject(node);
		}
	}

}
