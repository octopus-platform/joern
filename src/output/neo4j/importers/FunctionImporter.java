package output.neo4j.importers;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.EdgeTypes;
import output.neo4j.batchInserter.Neo4JBatchInserter;

import output.neo4j.nodes.FileDatabaseNode;
import output.neo4j.nodes.FunctionDatabaseNode;
import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
import cfg.CFG;
import cfg.CFGNode;

// Stays alive while importing a function into
// the database

public class FunctionImporter extends ASTNodeImporter
{
	ASTImporter astImporter = new ASTImporter(nodeStore);
	CFGImporter cfgImporter = new CFGImporter(nodeStore);
	
	public void addToDatabaseSafe(ASTNode node)
	{
		try{
			FunctionDatabaseNode function = new FunctionDatabaseNode();
			function.initialize(node);
			addFunctionToDatabase(function);
			linkFunctionToFileNode(function, curFile);
		}catch(RuntimeException ex)
		{
			ex.printStackTrace();
			System.err.println("Error adding function to database: " + ((FunctionDef) node).name.getEscapedCodeStr());
			return;
		}
	}
	
	private void addFunctionToDatabase(FunctionDatabaseNode function)
	{
		
		addMainNode(function);
		
		astImporter.setCurrentFunction(function);
		cfgImporter.setCurrentFunction(function);
		
		astImporter.addASTToDatabase(function.getASTRoot());
		cfgImporter.addCFGToDatabase(function.getCFG());	
		
		linkFunctionToASTAndCFG(function);
	
	}

	private void linkFunctionToASTAndCFG(FunctionDatabaseNode function)
	{
		
		linkFunctionWithAST(function);
		
		CFG cfg = function.getCFG();
		if(cfg != null){
			linkFunctionWithCFG(function, cfg);
		}
	}
	
	private void linkFunctionWithAST(FunctionDatabaseNode function)
	{
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_FUNCTION_OF_AST);
		
		long functionId = nodeStore.getIdForObject(function);
		long astNodeId = nodeStore.getIdForObject(function.getASTRoot());
		
		Neo4JBatchInserter.addRelationship(functionId, astNodeId, rel, null);
	
	}

	private void linkFunctionWithCFG(FunctionDatabaseNode function, CFG cfg)
	{
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_FUNCTION_OF_CFG);
		long functionId = nodeStore.getIdForObject(function);
		
		CFGNode firstBlock = cfg.getFirstStatement();
		
		long cfgRootId;
		try{
			cfgRootId = nodeStore.getIdForObject(firstBlock);
		}catch(RuntimeException ex){
			cfgRootId = nodeStore.getIdForObject(firstBlock.getASTNode());
		}
		
		Neo4JBatchInserter.addRelationship(functionId, cfgRootId, rel, null);
		
	}
	
	private void linkFunctionToFileNode(FunctionDatabaseNode function,
			FileDatabaseNode fileNode)
	{
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_FILE_OF);
		
		long fileId = fileNode.getId();
		long functionId = nodeStore.getIdForObject(function);
		
		Neo4JBatchInserter.addRelationship(fileId, functionId, rel, null);
	}
	
}
