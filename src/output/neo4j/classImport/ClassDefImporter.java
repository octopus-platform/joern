package output.neo4j.classImport;

import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.EdgeTypes;
import output.neo4j.GraphNodeStore;
import output.neo4j.Neo4JBatchInserter;
import output.neo4j.nodes.ClassDefDatabaseNode;
import output.neo4j.nodes.FileDatabaseNode;

import astnodes.declarations.ClassDefStatement;

public class ClassDefImporter
{
	GraphNodeStore nodeStore = new GraphNodeStore();

	public void addClassDefToDatabaseSafe(ClassDefStatement node,
			FileDatabaseNode currentFileNode)
	{
		try{
			ClassDefDatabaseNode classDefNode = new ClassDefDatabaseNode();
			classDefNode.initialize(node);
			addClassDefToDatabase(classDefNode);
			
			linkClassDefToFileNode(classDefNode, currentFileNode);
		}catch(RuntimeException ex)
		{
			ex.printStackTrace();
			System.err.println("Error adding class to database: " + node.name.getEscapedCodeStr());
			return;
		}
				
	}

	private void linkClassDefToFileNode(ClassDefDatabaseNode classDefNode,
			FileDatabaseNode fileNode)
	{
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_FILE_OF);
		
		long fileId = fileNode.getId();
		long functionId = nodeStore.getIdForObject(classDefNode);
		
		Neo4JBatchInserter.addRelationship(fileId, functionId, rel, null);
	}

	private void addClassDefToDatabase(ClassDefDatabaseNode classDefNode)
	{
		addClassDefNode(classDefNode);
	}
	
	private void addClassDefNode(ClassDefDatabaseNode classDefNode)
	{
		Map<String, Object> properties = classDefNode.createProperties();
		nodeStore.addNeo4jNode(classDefNode, properties);
				
		// index, but do not index location
		properties.remove("location");
		nodeStore.indexNode(classDefNode, properties);
	}
	
}
