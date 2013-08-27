package output.neo4j.importers;

import java.nio.file.Path;
import java.util.Map;
import java.util.Stack;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.EdgeTypes;
import output.neo4j.Neo4JBatchInserter;
import output.neo4j.nodes.FileDatabaseNode;

public class FileImporter
{
	Stack<FileDatabaseNode> directoryStack = new Stack<FileDatabaseNode>();
	
	public void enterDir(Path dir)
	{
		FileDatabaseNode node = new FileDatabaseNode();
		insertDirectoryNode(dir, node);
		linkWithParentDirectory(node);
		
		directoryStack.push(node);
	}

	private void linkWithParentDirectory(FileDatabaseNode node)
	{
		long srcId;
		
		if(directoryStack.size() == 0)
			srcId = 0; // link with reference node
		else
			srcId = directoryStack.peek().getId();
		
		long dstId = node.getId();
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_PARENT_DIR_OF);
		Neo4JBatchInserter.addRelationship(srcId, dstId, rel, null);
	}

	private void insertDirectoryNode(Path dir, FileDatabaseNode node)
	{
		node.initialize(dir);
		node.setType("Directory");	
		insertNode(node);
	}

	private void insertFileNode(Path dir, FileDatabaseNode node)
	{
		node.initialize(dir);
		node.setType("File");	
		insertNode(node);
	}
	
	private void insertNode(FileDatabaseNode node)
	{
		Map<String, Object> properties = node.createProperties();
		long nodeId = Neo4JBatchInserter.addNode(properties);
		node.setId(nodeId);
	
		Neo4JBatchInserter.indexNode(nodeId, properties);	
	}

	public void exitDir(Path dir)
	{
		directoryStack.pop();
	}

	public FileDatabaseNode enterFile(Path pathToFile)
	{
		FileDatabaseNode node = new FileDatabaseNode();
		insertFileNode(pathToFile, node);
		linkWithParentDirectory(node);
		return node;
	}

}
