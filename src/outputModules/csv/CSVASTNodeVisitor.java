package outputModules.csv;

import outputModules.common.ASTNodeExporter;
import outputModules.common.OutModASTNodeVisitor;
import outputModules.csv.exporters.CSVClassDefExporter;
import outputModules.csv.exporters.CSVDeclStmtExporter;
import outputModules.csv.exporters.CSVFunctionExporter;
import ast.declarations.ClassDefStatement;
import ast.functionDef.FunctionDef;
import ast.statements.IdentifierDeclStatement;
import databaseNodes.EdgeTypes;

public class CSVASTNodeVisitor extends OutModASTNodeVisitor
{
	@Override
	public void visit(FunctionDef node)
	{
		ASTNodeExporter importer = new CSVFunctionExporter();
		importNode(importer, node);
	}

	@Override
	public void visit(ClassDefStatement node)
	{

		ASTNodeExporter importer = new CSVClassDefExporter();
		long classNodeId = importNode(importer, node);
		visitClassDefContent(node, classNodeId);
	}

	@Override
	public void visit(IdentifierDeclStatement node)
	{
		ASTNodeExporter importer = new CSVDeclStmtExporter();
		importNode(importer, node);
	}

	@Override
	protected void addEdgeFromClassToFunc(long dstNodeId, Long classId)
	{
		CSVWriter.addEdge(classId, dstNodeId, null, EdgeTypes.IS_CLASS_OF);
	}

}
