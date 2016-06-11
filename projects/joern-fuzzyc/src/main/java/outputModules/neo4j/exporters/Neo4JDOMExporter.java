package outputModules.neo4j.exporters;

import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import databaseNodes.EdgeTypes;
import outputModules.common.DOMExporter;

public class Neo4JDOMExporter extends DOMExporter
{

	GraphNodeStore nodeStore;

	public Neo4JDOMExporter(GraphNodeStore nodeStore)
	{
		this.nodeStore = nodeStore;
	}

	@Override
	protected void addDomEdge(CFGNode vertex, CFGNode dominator)
	{
		if (vertex != dominator)
		{
			RelationshipType rel;
			rel = DynamicRelationshipType.withName(EdgeTypes.DOM);
			Neo4JBatchInserter.addRelationship(getId(dominator), getId(vertex),
					rel, null);
		}
	}

	@Override
	protected void addPostDomEdge(CFGNode vertex, CFGNode postDominator)
	{
		if (vertex != postDominator)
		{
			RelationshipType rel;
			rel = DynamicRelationshipType.withName(EdgeTypes.POST_DOM);
			Neo4JBatchInserter.addRelationship(getId(postDominator),
					getId(vertex), rel, null);
		}
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
