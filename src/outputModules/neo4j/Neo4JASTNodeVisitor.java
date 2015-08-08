package outputModules.neo4j;

import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import outputModules.ASTNodeImporter;
import outputModules.OutModASTNodeVisitor;
import outputModules.neo4j.importers.Neo4JClassDefImporter;
import outputModules.neo4j.importers.Neo4JDeclStmtImporter;
import outputModules.neo4j.importers.Neo4JFunctionImporter;
import ast.declarations.ClassDefStatement;
import ast.functionDef.FunctionDef;
import ast.statements.IdentifierDeclStatement;
import databaseNodes.EdgeTypes;

// Stays alive during the lifetime of the program

public class Neo4JASTNodeVisitor extends OutModASTNodeVisitor
{

	public void visit(FunctionDef node)
	{
		ASTNodeImporter importer = new Neo4JFunctionImporter();
		importNode(importer, node);
	}

	public void visit(ClassDefStatement node)
	{
		ASTNodeImporter importer = new Neo4JClassDefImporter();
		long classNodeId = importNode(importer, node);
		visitClassDefContent(node, classNodeId);
	}

	public void visit(IdentifierDeclStatement node)
	{
		ASTNodeImporter importer = new Neo4JDeclStmtImporter();
		importNode(importer, node);
	}

	@Override
	protected void addEdgeFromClassToFunc(long dstNodeId, Long classId)
	{
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.IS_CLASS_OF);
		Neo4JBatchInserter.addRelationship(classId, dstNodeId, rel, null);
	}

}
