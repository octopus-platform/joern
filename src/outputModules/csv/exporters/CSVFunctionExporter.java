package outputModules.csv.exporters;

import java.util.Map;

import cfg.CFG;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import databaseNodes.DatabaseNode;
import databaseNodes.EdgeTypes;
import databaseNodes.FileDatabaseNode;
import databaseNodes.FunctionDatabaseNode;
import outputModules.common.FunctionExporter;
import outputModules.common.Writer;

public class CSVFunctionExporter extends FunctionExporter
{

	public CSVFunctionExporter()
	{
		astImporter = new CSVASTExporter();
		cfgImporter = new CSVCFGExporter();
		udgImporter = new CSVUDGExporter();
		ddgImporter = new CSVDDGExporter();
		cdgImporter = new CSVCDGExporter();
		domExporter = new CSVDOMExporter();
	}

	@Override
	protected void linkFunctionWithAST(FunctionDatabaseNode function)
	{
		long functionId = Writer.getIdForObject(function);
		long astNodeId = Writer.getIdForObject(function.getASTRoot());

		Writer.addEdge(functionId, astNodeId, null,
				EdgeTypes.IS_FUNCTION_OF_AST);
	}

	@Override
	protected void linkFunctionWithCFG(FunctionDatabaseNode function, CFG cfg)
	{

		long functionId = Writer.getIdForObject(function);
		CFGNode firstBlock = cfg.getEntryNode();

		long cfgRootId;
		try
		{
			cfgRootId = Writer.getIdForObject(firstBlock);
		}
		catch (RuntimeException ex)
		{
			cfgRootId = Writer.getIdForObject(
					((ASTNodeContainer) firstBlock).getASTNode());
		}

		Writer.addEdge(functionId, cfgRootId, null,
				EdgeTypes.IS_FUNCTION_OF_CFG);

	}

	@Override
	protected void linkFunctionToFileNode(FunctionDatabaseNode function,
			FileDatabaseNode fileNode)
	{

		long srcId = Writer.getIdForObject(curFile);
		long dstId = Writer.getIdForObject(function);
		Writer.addEdge(srcId, dstId, null, EdgeTypes.IS_FILE_OF);

	}

	@Override
	protected void addMainNode(DatabaseNode dbNode)
	{
		Map<String, Object> properties = dbNode.createProperties();
		Writer.addNode(dbNode, properties);
		mainNodeId = Writer.getIdForObject(dbNode);
	}

}
