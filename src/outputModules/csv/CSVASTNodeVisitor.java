package outputModules.csv;

import outputModules.ASTNodeImporter;
import outputModules.csv.importers.CSVFunctionImporter;
import ast.declarations.ClassDefStatement;
import ast.functionDef.FunctionDef;
import ast.statements.IdentifierDeclStatement;
import ast.walking.ASTNodeVisitor;

public class CSVASTNodeVisitor extends ASTNodeVisitor
{
	public void visit(FunctionDef node)
	{
		ASTNodeImporter importer = new CSVFunctionImporter();
		importer.setCurrentFile(currentFileNode);
		importer.addToDatabaseSafe(node);
	}

	public void visit(ClassDefStatement node)
	{

	}

	public void visit(IdentifierDeclStatement node)
	{

	}
}
