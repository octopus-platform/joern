package outputModules.csv;

import outputModules.ASTNodeImporter;
import outputModules.OutModASTNodeVisitor;
import outputModules.csv.importers.CSVClassDefImporter;
import outputModules.csv.importers.CSVFunctionImporter;
import ast.declarations.ClassDefStatement;
import ast.functionDef.FunctionDef;

public class CSVASTNodeVisitor extends OutModASTNodeVisitor
{
	public void visit(FunctionDef node)
	{
		ASTNodeImporter importer = new CSVFunctionImporter();
		importNode(importer, node);
	}

	public void visit(ClassDefStatement node)
	{

		ASTNodeImporter importer = new CSVClassDefImporter();
		long classNodeId = importNode(importer, node);
		visitClassDefContent(node, classNodeId);
	}

	@Override
	protected void addEdgeFromClassToFunc(long dstNodeId, Long classId)
	{
		// TODO Auto-generated method stub
	}

}
