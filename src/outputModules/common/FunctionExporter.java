package outputModules.common;

import ast.ASTNode;
import ast.functionDef.FunctionDef;
import cfg.CFG;
import databaseNodes.FileDatabaseNode;
import databaseNodes.FunctionDatabaseNode;

public abstract class FunctionExporter extends ASTNodeExporter
{
	protected ASTExporter astImporter;
	protected CFGExporter cfgImporter;
	protected UDGExporter udgImporter;
	protected DDGExporter ddgImporter;
	protected CDGExporter cdgImporter;

	protected abstract void linkFunctionWithAST(FunctionDatabaseNode function);

	protected abstract void linkFunctionWithCFG(FunctionDatabaseNode function,
			CFG cfg);

	protected abstract void linkFunctionToFileNode(
			FunctionDatabaseNode function, FileDatabaseNode fileNode);

	public void addToDatabaseSafe(ASTNode node)
	{
		try
		{
			FunctionDatabaseNode function = new FunctionDatabaseNode();
			// this actually constructs all other representations of
			// the function.
			function.initialize(node);
			addFunctionToDatabase(function);
			linkFunctionToFileNode(function, curFile);
		}
		catch (RuntimeException ex)
		{
			ex.printStackTrace();
			System.err.println("Error adding function to database: "
					+ ((FunctionDef) node).name.getEscapedCodeStr());
			return;
		}
	}

	private void addFunctionToDatabase(FunctionDatabaseNode function)
	{

		addMainNode(function);

		astImporter.setCurrentFunction(function);
		cfgImporter.setCurrentFunction(function);
		udgImporter.setCurrentFunction(function);

		astImporter.addASTToDatabase(function.getASTRoot());
		cfgImporter.addCFGToDatabase(function.getCFG());
		udgImporter.addUDGToDatabase(function.getUDG());
		ddgImporter.addDDGToDatabase(function.getDDG());
		cdgImporter.addCDGToDatabase(function.getCDG());

		linkFunctionToASTAndCFG(function);

	}

	private void linkFunctionToASTAndCFG(FunctionDatabaseNode function)
	{

		linkFunctionWithAST(function);

		CFG cfg = function.getCFG();
		if (cfg != null)
		{
			linkFunctionWithCFG(function, cfg);
		}
	}

}
