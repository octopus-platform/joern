package outputModules.neo4j;

import java.util.Map;

import databaseNodes.*;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import cfg.CCFGFactory;
import cfg.CFG;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;
import outputModules.common.FunctionExporter;
import outputModules.neo4j.exporters.Neo4JASTExporter;
import outputModules.neo4j.exporters.Neo4JCDGExporter;
import outputModules.neo4j.exporters.Neo4JCFGExporter;
import outputModules.neo4j.exporters.Neo4JDDGExporter;
import outputModules.neo4j.exporters.Neo4JDOMExporter;
import outputModules.neo4j.exporters.Neo4JUDGExporter;
import udg.useDefAnalysis.CASTDefUseAnalyzer;

// Stays alive while importing a function into
// the database

public class Neo4JFunctionExporter extends FunctionExporter
{

	public Neo4JFunctionExporter()
	{
		astImporter = new Neo4JASTExporter(nodeStore);
		cfgImporter = new Neo4JCFGExporter(nodeStore);
		udgImporter = new Neo4JUDGExporter(nodeStore);
		ddgImporter = new Neo4JDDGExporter(nodeStore);
		cdgImporter = new Neo4JCDGExporter(nodeStore);
		domExporter = new Neo4JDOMExporter(nodeStore);
		analyzer = new CASTDefUseAnalyzer();
		cfgFactory = new CCFGFactory();
	}

	@Override
	protected void linkFunctionWithAST(FunctionDatabaseNode function)
	{
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.IS_FUNCTION_OF_AST);

		long functionId = nodeStore.getIdForObject(function);
		long astNodeId = nodeStore.getIdForObject(function.getASTRoot());

		Neo4JBatchInserter.addRelationship(functionId, astNodeId, rel, null);
	}

	@Override
	protected void linkFunctionWithCFG(FunctionDatabaseNode function, CFG cfg)
	{
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.IS_FUNCTION_OF_CFG);
		long functionId = nodeStore.getIdForObject(function);

		CFGNode firstBlock = cfg.getEntryNode();

		long cfgRootId;
		try
		{
			cfgRootId = nodeStore.getIdForObject(firstBlock);
		}
		catch (RuntimeException ex)
		{
			cfgRootId = nodeStore.getIdForObject(
					((ASTNodeContainer) firstBlock).getASTNode());
		}

		Neo4JBatchInserter.addRelationship(functionId, cfgRootId, rel, null);

	}

	@Override
	protected void linkFunctionToFileNode(FunctionDatabaseNode function,
			FileDatabaseNode fileNode)
	{
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.IS_FILE_OF);

		long fileId = fileNode.getId();
		long functionId = nodeStore.getIdForObject(function);

		Neo4JBatchInserter.addRelationship(fileId, functionId, rel, null);
	}

	// The following code can also be found in the respective
	// ClassDefImporter, DeclStmtImporter, etc. Multiple
	// inheritance would be nice.

	protected GraphNodeStore nodeStore = new GraphNodeStore();

	@Override
	protected void addMainNode(DatabaseNode dbNode)
	{
		Map<String, Object> properties = dbNode.createProperties();
		nodeStore.addNeo4jNode(dbNode, properties);

		mainNodeId = nodeStore.getIdForObject(dbNode);

		properties.remove(NodeKeys.LOCATION);
		nodeStore.indexNode(dbNode, properties);
	}

}
