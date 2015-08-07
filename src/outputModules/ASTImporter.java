package outputModules;

import ast.ASTNode;
import databaseNodes.FunctionDatabaseNode;

public abstract class ASTImporter
{
	protected FunctionDatabaseNode currentFunction;

	public void addASTToDatabase(ASTNode node)
	{
		addASTNode(node);
		addASTChildren(node);
	}

	public void setCurrentFunction(FunctionDatabaseNode func)
	{
		currentFunction = func;
	}

	protected abstract void addASTChildren(ASTNode node);

	protected abstract void addASTLink(ASTNode parent, ASTNode child);

	protected abstract void addASTNode(ASTNode node);
}