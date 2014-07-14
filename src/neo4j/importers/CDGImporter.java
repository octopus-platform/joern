package neo4j.importers;

import neo4j.EdgeTypes;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import cdg.CDG;
import cdg.CDGEdge;
import cdg.DominatorTree;
import cfg.CFGNode;

public class CDGImporter
{

	GraphNodeStore nodeStore;

	public CDGImporter(GraphNodeStore nodeStore)
	{
		this.nodeStore = nodeStore;
	}

	public void addCDGToDatabase(CDG cdg)
	{

		RelationshipType rel;

		// Add post dominator edges
		DominatorTree<CFGNode> dominatorTree = cdg.getDominatorTree();
		rel = DynamicRelationshipType.withName(EdgeTypes.POST_DOM);
		for (CFGNode vertex : dominatorTree.getVertices())
		{
			CFGNode dominator = dominatorTree.getDominator(vertex);
			long srcId = nodeStore
					.getIdForObject(dominator.astNode != null ? dominator.astNode
							: dominator);
			long dstId = nodeStore
					.getIdForObject(vertex.astNode != null ? vertex.astNode
							: vertex);

			Neo4JBatchInserter.addRelationship(srcId, dstId, rel, null);
		}
		// Add control edges
		rel = DynamicRelationshipType.withName(EdgeTypes.CONTROLS);
		for (CFGNode src : cdg.getVertices())
		{
			if (cdg.outDegree(src) > 0)
			{
				for (CDGEdge edge : cdg.outgoingEdges(src))
				{
					CFGNode dst = edge.getDestination();
					if (src.equals(dst))
					{
						continue;
					}
					long srcId = nodeStore
							.getIdForObject(src.astNode != null ? src.astNode
									: src);
					long dstId = nodeStore
							.getIdForObject(dst.astNode != null ? dst.astNode
									: dst);

					Neo4JBatchInserter.addRelationship(srcId, dstId, rel, null);
				}
			}
		}
	}

}
