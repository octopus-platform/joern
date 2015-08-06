package outputModules.csv.importers;

import java.util.Map;

import outputModules.csv.CSVWriter;
import databaseNodes.FunctionDatabaseNode;

public class FunctionImporter
{

	ASTImporter astImporter = new ASTImporter();

	public void addFunction(FunctionDatabaseNode funcNode)
	{
		addMainNode(funcNode);
		astImporter.setCurrentFunction(funcNode);
		astImporter.importAST(funcNode.getASTRoot());
	}

	private void addMainNode(FunctionDatabaseNode dbNode)
	{

		Map<String, Object> properties = dbNode.createProperties();
		CSVWriter.setCurFunctionId();
		CSVWriter.addNode(dbNode, properties);

		// We are currently not adding 'functionId' to the function node
		// as that requires us to perform a lookup on the node just created
		// and thus requires us to flush.

	}

}
