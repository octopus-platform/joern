package output.neo4j;

import java.util.Stack;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.importers.ClassDefImporter;
import output.neo4j.importers.FunctionImporter;
import output.neo4j.importers.DeclStmtImporter;
import output.neo4j.importers.Importer;
import output.neo4j.nodes.FileDatabaseNode;
import astnodes.ASTNode;
import astnodes.declarations.ClassDefStatement;
import astnodes.functionDef.FunctionDef;
import astnodes.statements.IdentifierDeclStatement;
import astwalking.ASTNodeVisitor;

// Stays alive during the lifetime of the program

public class Neo4JASTNodeVisitor extends ASTNodeVisitor
{
	FileDatabaseNode currentFileNode;
	Stack<Long> contextStack;
	
	public void handleStartOfUnit(FileDatabaseNode aCurrentFileNode)
	{
		currentFileNode = aCurrentFileNode;
		contextStack =  new Stack<Long>();
	}
	
	public void visit(FunctionDef node)
	{
		Importer importer = new FunctionImporter();
		importNode(importer, node);
	}

	public void visit(ClassDefStatement node)
	{
		Importer importer = new ClassDefImporter();		
		long classNodeId = importNode(importer, node);		
		visitClassDefContent(node, classNodeId);
	}
	
	public void visit(IdentifierDeclStatement node)
	{
		Importer importer = new DeclStmtImporter();
		importNode(importer, node);
	}
	
	private long importNode(Importer importer, ASTNode node)
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
		if(contextStack.size() == 0)
			return;
		Long classId = contextStack.peek();
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_CLASS_OF);
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
