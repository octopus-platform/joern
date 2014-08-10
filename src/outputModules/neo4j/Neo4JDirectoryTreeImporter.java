package outputModules.neo4j;


import java.util.Map;

import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import outputModules.neo4j.importers.DirectoryTreeImporter;
import databaseNodes.EdgeTypes;
import databaseNodes.FileDatabaseNode;

public class Neo4JDirectoryTreeImporter extends DirectoryTreeImporter
{

	protected void linkWithParentDirectory(FileDatabaseNode node)
	{
		long srcId = getSourceIdFromStack();
		long dstId = node.getId();
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.IS_PARENT_DIR_OF);
		Neo4JBatchInserter.addRelationship(srcId, dstId, rel, null);
	}	

	protected void insertNode(FileDatabaseNode node)
	{
		Map<String, Object> properties = node.createProperties();
		long nodeId = Neo4JBatchInserter.addNode(properties);
		node.setId(nodeId);

		Neo4JBatchInserter.indexNode(nodeId, properties);
	}

}
