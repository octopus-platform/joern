package outputModules.csv;

import outputModules.csv.importers.CSVFunctionImporter;
import ast.declarations.ClassDefStatement;
import ast.functionDef.FunctionDef;
import ast.statements.IdentifierDeclStatement;
import ast.walking.ASTNodeVisitor;
import databaseNodes.FunctionDatabaseNode;

public class CSVASTNodeVisitor extends ASTNodeVisitor
{
	public void visit(FunctionDef node)
	{
		FunctionDatabaseNode dbNode;
		try
		{
			dbNode = new FunctionDatabaseNode();
			dbNode.initialize(node);
		}
		catch (RuntimeException ex)
		{
			System.err.println("Error adding function to database: "
					+ ((FunctionDef) node).name.getEscapedCodeStr());
			return;
		}

		CSVFunctionImporter importer = new CSVFunctionImporter();
		importer.setCurrentFile(currentFileNode);
		importer.addFunction(dbNode);

	}

	public void visit(ClassDefStatement node)
	{
		// Called for each class/struct definition
	}

	public void visit(IdentifierDeclStatement node)
	{
		// Called for each global declaration
	}

}
