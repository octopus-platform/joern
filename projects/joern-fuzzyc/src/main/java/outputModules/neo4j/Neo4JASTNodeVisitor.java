package outputModules.neo4j;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import ast.declarations.ClassDefStatement;
import ast.functionDef.FunctionDefBase;
import ast.statements.IdentifierDeclStatement;
import databaseNodes.EdgeTypes;
import neo4j.batchInserter.Neo4JBatchInserter;
import outputModules.common.ASTNodeExporter;
import outputModules.common.OutModASTNodeVisitor;
import outputModules.neo4j.exporters.Neo4JClassDefExporter;
import outputModules.neo4j.exporters.Neo4JDeclStmtExporter;

// Stays alive during the lifetime of the program

public class Neo4JASTNodeVisitor extends OutModASTNodeVisitor
{

	public void visit(FunctionDefBase node)
	{
		ASTNodeExporter importer = new Neo4JFunctionExporter();
		importNode(importer, node);
	}

	public void visit(ClassDefStatement node)
	{
		ASTNodeExporter importer = new Neo4JClassDefExporter();
		long classNodeId = importNode(importer, node);
		visitClassDefContent(node, classNodeId);
	}

	public void visit(IdentifierDeclStatement node)
	{
		ASTNodeExporter importer = new Neo4JDeclStmtExporter();
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
