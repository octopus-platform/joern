package outputModules.csv.importers;

import java.util.Map;

import outputModules.FunctionImporter;
import outputModules.csv.CSVWriter;
import cfg.CFG;
import databaseNodes.DatabaseNode;
import databaseNodes.EdgeTypes;
import databaseNodes.FileDatabaseNode;
import databaseNodes.FunctionDatabaseNode;

public class CSVFunctionImporter extends FunctionImporter
{

	public CSVFunctionImporter()
	{
		astImporter = new CSVASTImporter();
		cfgImporter = new CSVCFGImporter();
		udgImporter = new CSVUDGImporter();
		ddgImporter = new CSVDDGImporter();
		cdgImporter = new CSVCDGImporter();
	}

	@Override
	protected void linkFunctionWithAST(FunctionDatabaseNode function)
	{
		// TODO Auto-generated method stub
	}

	@Override
	protected void linkFunctionWithCFG(FunctionDatabaseNode function, CFG cfg)
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void linkFunctionToFileNode(FunctionDatabaseNode function,
			FileDatabaseNode fileNode)
	{

		long srcId = CSVWriter.getIdForObject(curFile);
		long dstId = CSVWriter.getIdForObject(function);
		CSVWriter.addEdge(srcId, dstId, null, EdgeTypes.IS_FILE_OF);

	}

	@Override
	protected void addMainNode(DatabaseNode dbNode)
	{
		Map<String, Object> properties = dbNode.createProperties();
		CSVWriter.addNode(dbNode, properties);
	}

}
