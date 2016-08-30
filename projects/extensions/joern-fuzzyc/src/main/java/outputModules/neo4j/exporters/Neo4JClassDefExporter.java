package outputModules.neo4j.exporters;

import java.util.Map;

import databaseNodes.*;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;
import outputModules.common.ClassDefExporter;

public class Neo4JClassDefExporter extends ClassDefExporter
{

	protected void linkClassDefToFileNode(ClassDefDatabaseNode classDefNode,
			FileDatabaseNode fileNode)
	{
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.IS_FILE_OF);

		long fileId = fileNode.getId();
		long functionId = nodeStore.getIdForObject(classDefNode);

		Neo4JBatchInserter.addRelationship(fileId, functionId, rel, null);
	}

	// The following code can also be found in the respective
	// ClassDefImporter, DeclStmtImporter, etc. Multiple
	// inheritance would be nice.

	protected GraphNodeStore nodeStore = new GraphNodeStore();

	@Override
	protected void addMainNode(DatabaseNode dbNode)
	{
		Map<String, Object> properties = dbNode.createProperties();
		nodeStore.addNeo4jNode(dbNode, properties);

		mainNodeId = nodeStore.getIdForObject(dbNode);
		properties.remove(NodeKeys.LOCATION);
		nodeStore.indexNode(dbNode, properties);
	}

}
