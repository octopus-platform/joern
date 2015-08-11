package outputModules.csv.exporters;

import java.util.Map;

import outputModules.common.FunctionExporter;
import outputModules.csv.CSVWriter;
import cfg.CFG;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import databaseNodes.DatabaseNode;
import databaseNodes.EdgeTypes;
import databaseNodes.FileDatabaseNode;
import databaseNodes.FunctionDatabaseNode;

public class CSVFunctionExporter extends FunctionExporter
{

	public CSVFunctionExporter()
	{
		astImporter = new CSVASTExporter();
		cfgImporter = new CSVCFGExporter();
		udgImporter = new CSVUDGExporter();
		ddgImporter = new CSVDDGExporter();
		cdgImporter = new CSVCDGExporter();
	}

	@Override
	protected void linkFunctionWithAST(FunctionDatabaseNode function)
	{
		long functionId = CSVWriter.getIdForObject(function);
		long astNodeId = CSVWriter.getIdForObject(function.getASTRoot());

		CSVWriter.addEdge(functionId, astNodeId, null,
				EdgeTypes.IS_FUNCTION_OF_AST);
	}

	@Override
	protected void linkFunctionWithCFG(FunctionDatabaseNode function, CFG cfg)
	{

		long functionId = CSVWriter.getIdForObject(function);
		CFGNode firstBlock = cfg.getEntryNode();

		long cfgRootId;
		try
		{
			cfgRootId = CSVWriter.getIdForObject(firstBlock);
		}
		catch (RuntimeException ex)
		{
			cfgRootId = CSVWriter
					.getIdForObject(((ASTNodeContainer) firstBlock)
							.getASTNode());
		}

		CSVWriter.addEdge(functionId, cfgRootId, null,
				EdgeTypes.IS_FUNCTION_OF_CFG);

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
		mainNodeId = CSVWriter.getIdForObject(dbNode);
	}

}
