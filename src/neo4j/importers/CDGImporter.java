package neo4j.importers;

import neo4j.EdgeTypes;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import cdg.CDG;
import cdg.DominatorTree;

public class CDGImporter {

    GraphNodeStore nodeStore;


    public CDGImporter(GraphNodeStore nodeStore) {
	this.nodeStore = nodeStore;
    }


    public void addCDGToDatabase(CDG cdg) {

	// Add post dominator edges
	DominatorTree<Object> dom = cdg.getDominatorTree();
	RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.POST_DOM);
	for (Object vertex : dom.getVertices()) {

	    long srcId = nodeStore.getIdForObject(dom.getDominator(vertex));
	    long dstId = nodeStore.getIdForObject(vertex);

	    Neo4JBatchInserter.addRelationship(srcId, dstId, rel, null);
	}
    }

}
