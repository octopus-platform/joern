package output.neo4j;

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
	
	public void handleStartOfUnit(FileDatabaseNode aCurrentFileNode)
	{
		currentFileNode = aCurrentFileNode;
	}
	
	public void visit(FunctionDef node)
	{
		functionImporter = new FunctionImporter();
		functionImporter.addFunctionToDatabaseSafe(node, currentFileNode);
		functionImporter = null;
	}

	public void visit(ClassDefStatement node)
	{
		classDefImporter = new ClassDefImporter();
		classDefImporter.addClassDefToDatabaseSafe(node, currentFileNode);
		classDefImporter = null;
	
		// walk compound statement, it might contain
		// functions, declarations or other class definitions
		visit(node.content);
	}
	
}
