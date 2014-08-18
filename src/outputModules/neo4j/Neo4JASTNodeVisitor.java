package outputModules.neo4j;

import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import outputModules.neo4j.importers.ASTNodeImporter;
import outputModules.neo4j.importers.ClassDefImporter;
import outputModules.neo4j.importers.DeclStmtImporter;
import outputModules.neo4j.importers.FunctionImporter;
import ast.ASTNode;
import ast.declarations.ClassDefStatement;
import ast.functionDef.FunctionDef;
import ast.statements.IdentifierDeclStatement;
import ast.walking.ASTNodeVisitor;
import databaseNodes.EdgeTypes;

// Stays alive during the lifetime of the program

public class Neo4JASTNodeVisitor extends ASTNodeVisitor
{

	public void visit(FunctionDef node)
	{
		ASTNodeImporter importer = new FunctionImporter();
		importNode(importer, node);
	}

	public void visit(ClassDefStatement node)
	{
		ASTNodeImporter importer = new ClassDefImporter();
		long classNodeId = importNode(importer, node);
		visitClassDefContent(node, classNodeId);
	}

	public void visit(IdentifierDeclStatement node)
	{
		ASTNodeImporter importer = new DeclStmtImporter();
		importNode(importer, node);
	}

	private long importNode(ASTNodeImporter importer, ASTNode node)
	{
		importer.setCurrentFile(currentFileNode);
		importer.addToDatabaseSafe(node);
		long mainNodeId = importer.getMainNodeId();
		addLinkToClassDef(mainNodeId);
		importer = null;
		return mainNodeId;
	}

	private void addLinkToClassDef(long dstNodeId)
	{
		if (contextStack.size() == 0)
			return;
		Long classId = contextStack.peek();
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.IS_CLASS_OF);
		Neo4JBatchInserter.addRelationship(classId, dstNodeId, rel, null);
	}

	private void visitClassDefContent(ClassDefStatement node, long classNodeId)
	{
		// visit compound statement, it might contain
		// functions, declarations or other class definitions
		contextStack.push(classNodeId);
		visit(node.content);
		contextStack.pop();
	}

}
