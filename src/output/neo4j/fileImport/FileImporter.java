package output.neo4j.fileImport;

import java.nio.file.Path;
import java.util.Map;
import java.util.Stack;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.EdgeTypes;
import output.neo4j.Neo4JDatabase;
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
		Neo4JDatabase.addRelationship(srcId, dstId, rel, null);
	}

	private void insertDirectoryNode(Path dir, FileDatabaseNode node)
	{
		node.initialize(dir);
		node.setType("directory");	
		insertNode(node);
	}

	private void insertFileNode(Path dir, FileDatabaseNode node)
	{
		node.initialize(dir);
		node.setType("file");	
		insertNode(node);
	}
	
	private void insertNode(FileDatabaseNode node)
	{
		Map<String, Object> properties = node.createProperties();
		long nodeId = Neo4JDatabase.addNode(properties);
		node.setId(nodeId);
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
