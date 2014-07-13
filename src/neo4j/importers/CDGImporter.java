package neo4j.importers;

import neo4j.EdgeTypes;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import cdg.CDG;
import cdg.DominatorTree;

public class CDGImporter
{

	GraphNodeStore nodeStore;

	public CDGImporter(GraphNodeStore nodeStore)
	{
		this.nodeStore = nodeStore;
	}

	public void addCDGToDatabase(CDG<Object> cdg)
	{

		RelationshipType rel;

		// Add post dominator edges
		DominatorTree<Object> dominatorTree = cdg.getDominatorTree();
		rel = DynamicRelationshipType.withName(EdgeTypes.POST_DOM);
		for (Object vertex : dominatorTree)
		{

			// System.out.println(dom.getDominator(vertex) + " --|POST_DOM|--> "
			// + vertex);
			long srcId = nodeStore.getIdForObject(dominatorTree
					.getDominator(vertex));
			long dstId = nodeStore.getIdForObject(vertex);

			Neo4JBatchInserter.addRelationship(srcId, dstId, rel, null);
		}
		// Add control edges
		rel = DynamicRelationshipType.withName(EdgeTypes.CONTROLS);
		for (Object src : cdg)
		{
			if (cdg.outDegree(src) > 0)
			{
				for (Object dst : cdg.outNeighborhood(src))
				{
					if (src.equals(dst))
					{
						continue;
					}
					// System.out.println(src + " --|CONTROLS|--> " + dst);
					long srcId = nodeStore.getIdForObject(src);
					long dstId = nodeStore.getIdForObject(dst);

					Neo4JBatchInserter.addRelationship(srcId, dstId, rel, null);
				}
			}
		}
	}

}
