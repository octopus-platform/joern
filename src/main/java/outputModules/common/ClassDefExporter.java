package outputModules.common;

import ast.ASTNode;
import ast.declarations.ClassDefStatement;
import databaseNodes.ClassDefDatabaseNode;
import databaseNodes.FileDatabaseNode;

public abstract class ClassDefExporter extends ASTNodeExporter
{
	protected abstract void linkClassDefToFileNode(
			ClassDefDatabaseNode classDefNode, FileDatabaseNode curFile);

	public void addToDatabaseSafe(ASTNode node)
	{
		try
		{
			ClassDefDatabaseNode classDefNode = new ClassDefDatabaseNode();
			classDefNode.initialize(node);
			addClassDefToDatabase(classDefNode);
			linkClassDefToFileNode(classDefNode, curFile);
		} catch (RuntimeException ex)
		{
			ex.printStackTrace();
			System.err.println("Error adding class to database: "
					+ ((ClassDefStatement) node).identifier.getEscapedCodeStr());
			return;
		}

	}

	private void addClassDefToDatabase(ClassDefDatabaseNode classDefNode)
	{
		addMainNode(classDefNode);
	}

}
