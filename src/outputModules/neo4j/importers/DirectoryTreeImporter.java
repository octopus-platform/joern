package outputModules.neo4j.importers;

import java.nio.file.Path;
import java.util.Stack;

import tools.index.IndexerState;
import databaseNodes.FileDatabaseNode;

public abstract class DirectoryTreeImporter
{
	protected IndexerState state;
	protected Stack<FileDatabaseNode> directoryStack = new Stack<FileDatabaseNode>();
	
	protected abstract void linkWithParentDirectory(FileDatabaseNode node);
	protected abstract void insertNode(FileDatabaseNode node);
	
	
	public void setState(IndexerState aState)
	{
		state = aState;
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

	protected void insertDirectoryNode(Path dir, FileDatabaseNode node)
	{
		node.initialize(dir);
		node.setType("Directory");
		insertNode(node);
	}

	protected void insertFileNode(Path dir, FileDatabaseNode node)
	{
		node.initialize(dir);
		node.setType("File");
		insertNode(node);
	}
	
	protected long getSourceIdFromStack()
	{
		long srcId;
		if (directoryStack.size() == 0)
			srcId = 0; // reference node
		else
			srcId = directoryStack.peek().getId();
		return srcId;
	}
	
}
