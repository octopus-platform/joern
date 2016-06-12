package outputModules.common;

import ast.ASTNode;
import databaseNodes.FunctionDatabaseNode;

public abstract class ASTExporter
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

	protected void addASTChildren(ASTNode node)
	{

		final int nChildren = node.getChildCount();

		for (int i = 0; i < nChildren; i++)
		{
			ASTNode child = node.getChild(i);
			addASTToDatabase(child);
			addASTLink(node, child);
		}

	}

	protected abstract void addASTLink(ASTNode parent, ASTNode child);

	protected abstract void addASTNode(ASTNode node);
}