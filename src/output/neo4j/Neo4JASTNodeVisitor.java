package output.neo4j;

import java.util.Stack;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.importers.ClassDefImporter;
import output.neo4j.importers.FunctionImporter;
import output.neo4j.importers.IdentifierDeclImporter;
import output.neo4j.nodes.FileDatabaseNode;
import astnodes.declarations.ClassDefStatement;
import astnodes.functionDef.FunctionDef;
import astnodes.statements.IdentifierDeclStatement;
import astwalking.ASTNodeVisitor;

// Stays alive during the lifetime of the program

public class Neo4JASTNodeVisitor extends ASTNodeVisitor
{
	// TODO: create an Importer base class
	// for these to reduce code duplication
	
	FunctionImporter functionImporter;
	ClassDefImporter classDefImporter;
	FileDatabaseNode currentFileNode;
	
	Stack<Long> contextStack;
	
	public void handleStartOfUnit(FileDatabaseNode aCurrentFileNode)
	{
		currentFileNode = aCurrentFileNode;
		contextStack =  new Stack<Long>();
	}
	
	public void visit(FunctionDef node)
	{
		functionImporter = new FunctionImporter();
		functionImporter.setCurrentFile(currentFileNode);
		functionImporter.addToDatabaseSafe(node);
		long functionNodeId = functionImporter.getMainNodeId();
		
		addLinkToClassDef(functionNodeId);
		
		functionImporter = null;
	}

	private void addLinkToClassDef(long dstNodeId)
	{
		if(contextStack.size() == 0)
			return;
		Long classId = contextStack.peek();
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_CLASS_OF);
		Neo4JBatchInserter.addRelationship(classId, dstNodeId, rel, null);
	}

	public void visit(ClassDefStatement node)
	{
		classDefImporter = new ClassDefImporter();
		classDefImporter.setCurrentFile(currentFileNode);
		classDefImporter.addToDatabaseSafe(node);
		long classNodeId = classDefImporter.getMainNodeId();
		classDefImporter = null;
		
		visitClassDefContent(node, classNodeId);
	}

	private void visitClassDefContent(ClassDefStatement node, long classNodeId)
	{
		// visit compound statement, it might contain
		// functions, declarations or other class definitions
		contextStack.push(classNodeId);
		visit(node.content);
		contextStack.pop();
	}
	
	public void visit(IdentifierDeclStatement node)
	{
		IdentifierDeclImporter importer = new IdentifierDeclImporter();
		importer.addToDatabaseSafe(node);
		
		long id = importer.getMainNodeId();
		addLinkToClassDef(id);
		
	}
	
}
