package neo4j;

import java.nio.file.Path;
import java.util.Map;
import java.util.Stack;

import neo4j.batchInserter.Neo4JBatchInserter;
import neo4j.importers.DirectoryTreeImporter;
import neo4j.nodes.FileDatabaseNode;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import tools.index.IndexerState;

public class Neo4JDirectoryTreeImporter extends DirectoryTreeImporter
{

	Stack<FileDatabaseNode> directoryStack = new Stack<FileDatabaseNode>();
	Neo4JIndexerState state;

	public void setState(IndexerState aState)
	{
		state = (Neo4JIndexerState) aState;
	}

	public void enterDir(Path dir)
	{
		FileDatabaseNode node = new FileDatabaseNode();
		insertDirectoryNode(dir, node);
		linkWithParentDirectory(node);

		directoryStack.push(node);
	}

	public void exitDir(Path dir)
	{
		directoryStack.pop();
	}

	public void enterFile(Path pathToFile)
	{
		FileDatabaseNode node = new FileDatabaseNode();
		insertFileNode(pathToFile, node);
		linkWithParentDirectory(node);
		state.setCurrentFileNode(node);
	}

	private void linkWithParentDirectory(FileDatabaseNode node)
	{
		long srcId = getSourceIdFromStack();
		long dstId = node.getId();
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.IS_PARENT_DIR_OF);
		Neo4JBatchInserter.addRelationship(srcId, dstId, rel, null);
	}

	private long getSourceIdFromStack()
	{
		long srcId;
		if (directoryStack.size() == 0)
			srcId = 0; // reference node
		else
			srcId = directoryStack.peek().getId();
		return srcId;
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

}
