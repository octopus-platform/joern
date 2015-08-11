package outputModules.common;

import java.util.Iterator;
import java.util.List;

import ast.ASTNode;
import ast.statements.IdentifierDeclStatement;
import databaseNodes.DeclStmtDatabaseNode;

public abstract class DeclStmtExporter extends ASTNodeExporter
{

	protected ASTNodeExporter declImporter;

	protected abstract void addLinkFromStmtToDecl(long mainNodeId, long declId);

	public void addToDatabaseSafe(ASTNode node)
	{
		DeclStmtDatabaseNode dbNode = new DeclStmtDatabaseNode();
		dbNode.initialize(node);
		addMainNode(dbNode);

		addDeclarations(node);
	}

	private void addDeclarations(ASTNode node)
	{
		IdentifierDeclStatement stmt = (IdentifierDeclStatement) node;
		List<ASTNode> identifierDeclList = stmt.getIdentifierDeclList();
		Iterator<ASTNode> it = identifierDeclList.iterator();
		while (it.hasNext())
		{
			ASTNode decl = it.next();
			declImporter.addToDatabaseSafe(decl);
			long declId = declImporter.getMainNodeId();
			addLinkFromStmtToDecl(mainNodeId, declId);
		}
	}

}
