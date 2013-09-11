package output.neo4j.importers;

import java.util.Map;

import astnodes.ASTNode;
import output.neo4j.batchInserter.GraphNodeStore;
import output.neo4j.nodes.DatabaseNode;
import output.neo4j.nodes.FileDatabaseNode;

public abstract class ASTNodeImporter {

	protected Long mainNodeId;
	protected GraphNodeStore nodeStore = new GraphNodeStore();
	protected FileDatabaseNode curFile;
	
	
	public void setCurrentFile(FileDatabaseNode fileNode)
	{
		curFile = fileNode;
	}
	
	public long getMainNodeId()
	{
		return mainNodeId;
	}
	
	public abstract void addToDatabaseSafe(ASTNode node);
	
	protected void addMainNode(DatabaseNode dbNode)
	{
		Map<String, Object> properties = dbNode.createProperties();
		nodeStore.addNeo4jNode(dbNode, properties);
		
		mainNodeId = nodeStore.getIdForObject(dbNode);
		
		// index, but do not index location
		properties.remove("location");
		nodeStore.indexNode(dbNode, properties);
	
	}
	
}
