package output.neo4j.importers;

import java.util.Iterator;
import java.util.List;

import output.neo4j.nodes.DeclStmtDatabaseNode;
import astnodes.ASTNode;
import astnodes.statements.IdentifierDeclStatement;

public class DeclStmtImporter extends Importer {
	
	DeclImporter declImporter = new DeclImporter();
	
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
		while(it.hasNext()){
			ASTNode decl = it.next();
			declImporter.addToDatabaseSafe(decl);
		}
	}
	
}
