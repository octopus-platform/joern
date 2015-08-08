package outputModules.neo4j.importers;

import java.util.Map;

import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import outputModules.ClassDefImporter;
import databaseNodes.ClassDefDatabaseNode;
import databaseNodes.DatabaseNode;
import databaseNodes.EdgeTypes;
import databaseNodes.FileDatabaseNode;

public class Neo4JClassDefImporter extends ClassDefImporter
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
		properties.remove("location");
		nodeStore.indexNode(dbNode, properties);
	}

}
