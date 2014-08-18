package outputModules.neo4j.importers;

import java.util.Iterator;
import java.util.List;

import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import ast.ASTNode;
import ast.statements.IdentifierDeclStatement;
import databaseNodes.DeclStmtDatabaseNode;
import databaseNodes.EdgeTypes;

public class DeclStmtImporter extends ASTNodeImporter
{

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
		while (it.hasNext())
		{
			ASTNode decl = it.next();
			declImporter.addToDatabaseSafe(decl);
			long declId = declImporter.getMainNodeId();
			addLinkFromStmtToDecl(mainNodeId, declId);
		}
	}

	private void addLinkFromStmtToDecl(long mainNodeId, long declId)
	{
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.DECLARES);
		Neo4JBatchInserter.addRelationship(mainNodeId, declId, rel, null);
	}

}
