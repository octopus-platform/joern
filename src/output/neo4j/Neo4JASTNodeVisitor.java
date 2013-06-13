package output.neo4j;

import java.util.Stack;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.classImport.ClassDefImporter;
import output.neo4j.functionImport.FunctionImporter;
import output.neo4j.nodes.FileDatabaseNode;
import astnodes.declarations.ClassDefStatement;
import astnodes.functionDef.FunctionDef;
import astwalking.ASTNodeVisitor;

// Stays alive during the lifetime of the program

public class Neo4JASTNodeVisitor extends ASTNodeVisitor
{
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
		functionImporter.addFunctionToDatabaseSafe(node, currentFileNode);
		long functionNodeId = functionImporter.getFunctionNodeId();
		
		addLinkToClassDef(functionNodeId);
		
		functionImporter = null;
	}

	private void addLinkToClassDef(long functionNodeId)
	{
		if(contextStack.size() == 0)
			return;
		Long classId = contextStack.peek();
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_CLASS_OF);
		Neo4JBatchInserter.addRelationship(classId, functionNodeId, rel, null);
	}

	public void visit(ClassDefStatement node)
	{
		classDefImporter = new ClassDefImporter();
		classDefImporter.addClassDefToDatabaseSafe(node, currentFileNode);
		long classNodeId = classDefImporter.getClassNodeId();
		classDefImporter = null;
		
		// walk compound statement, it might contain
		// functions, declarations or other class definitions
		contextStack.push(classNodeId);
		visit(node.content);
		contextStack.pop();
	}
	
}
