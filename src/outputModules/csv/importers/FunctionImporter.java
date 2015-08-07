package outputModules.csv.importers;

import java.util.Map;

import outputModules.csv.CSVWriter;
import databaseNodes.EdgeTypes;
import databaseNodes.FileDatabaseNode;
import databaseNodes.FunctionDatabaseNode;

public class FunctionImporter
{

	ASTImporter astImporter = new ASTImporter();

	protected FileDatabaseNode curFile;

	public void setCurrentFile(FileDatabaseNode fileNode)
	{
		curFile = fileNode;
	}

	public void addFunction(FunctionDatabaseNode funcNode)
	{
		addMainNode(funcNode);
		astImporter.setCurrentFunction(funcNode);
		astImporter.importAST(funcNode.getASTRoot());

		linkFunctionToFileNode(funcNode);
	}

	private void linkFunctionToFileNode(FunctionDatabaseNode funcNode)
	{
		long srcId = CSVWriter.getIdForObject(curFile);
		long dstId = CSVWriter.getIdForObject(funcNode);
		CSVWriter.addEdge(srcId, dstId, null, EdgeTypes.IS_FILE_OF);
	}

	private void addMainNode(FunctionDatabaseNode dbNode)
	{

		Map<String, Object> properties = dbNode.createProperties();
		CSVWriter.addNode(dbNode, properties);

		// We are currently not adding 'functionId' to the function node
		// as that requires us to perform a lookup on the node just created
		// and thus requires us to flush.

	}

}
