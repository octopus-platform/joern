package outputModules.csv;

import outputModules.ASTNodeImporter;
import outputModules.OutModASTNodeVisitor;
import outputModules.csv.importers.CSVClassDefImporter;
import outputModules.csv.importers.CSVDeclStmtImporter;
import outputModules.csv.importers.CSVFunctionImporter;
import ast.declarations.ClassDefStatement;
import ast.functionDef.FunctionDef;
import ast.statements.IdentifierDeclStatement;
import databaseNodes.EdgeTypes;

public class CSVASTNodeVisitor extends OutModASTNodeVisitor
{
	@Override
	public void visit(FunctionDef node)
	{
		ASTNodeImporter importer = new CSVFunctionImporter();
		importNode(importer, node);
	}

	@Override
	public void visit(ClassDefStatement node)
	{

		ASTNodeImporter importer = new CSVClassDefImporter();
		long classNodeId = importNode(importer, node);
		visitClassDefContent(node, classNodeId);
	}

	@Override
	public void visit(IdentifierDeclStatement node)
	{
		ASTNodeImporter importer = new CSVDeclStmtImporter();
		importNode(importer, node);
	}

	@Override
	protected void addEdgeFromClassToFunc(long dstNodeId, Long classId)
	{
		CSVWriter.addEdge(classId, dstNodeId, null, EdgeTypes.IS_CLASS_OF);
	}

}
