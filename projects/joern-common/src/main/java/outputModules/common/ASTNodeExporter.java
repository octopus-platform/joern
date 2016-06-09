package outputModules.common;

import ast.ASTNode;
import databaseNodes.DatabaseNode;
import databaseNodes.FileDatabaseNode;

public abstract class ASTNodeExporter
{
	protected Long mainNodeId;
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

	protected abstract void addMainNode(DatabaseNode dbNode);

}
