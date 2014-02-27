package output.neo4j.importers;

import java.util.Map;

import output.neo4j.batchInserter.GraphNodeStore;
import output.neo4j.nodes.DatabaseNode;
import output.neo4j.nodes.FileDatabaseNode;
import astnodes.ASTNode;

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
		
		nodeStore.setNodeProperty(dbNode, "functionId", String.format("%d", mainNodeId));
		
		// index, but do not index location
		properties.remove("location");
		nodeStore.indexNode(dbNode, properties);
	
	}
	
}
