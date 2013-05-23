package output.neo4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.nodes.FunctionDatabaseNode;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
import cfg.BasicBlock;
import cfg.CFG;

// Stays alive while importing a function into
// the database

public class FunctionImporter
{
	GraphNodeStore nodeStore = new GraphNodeStore();
	ASTImporter astImporter = new ASTImporter(nodeStore);
	CFGImporter cfgImporter = new CFGImporter(nodeStore);
	
	String filename;
	
	public void addFunctionToDatabaseSafe(FunctionDef node)
	{
		try{
			FunctionDatabaseNode function = new FunctionDatabaseNode();
			function.initialize(node);
			function.setFilename(filename);
			addFunctionToDatabase(function);
		}catch(RuntimeException ex)
		{
			// ex.printStackTrace();
			System.err.println("Error adding function to database: " + node.name.getEscapedCodeStr());
			return;
		}
	}

	private void addFunctionToDatabase(FunctionDatabaseNode function)
	{
		astImporter.addASTToDatabase(function.getASTRoot());
		cfgImporter.addCFGToDatabase(function.getCFG());
		addFunctionNode(function);
	}
	
	private void addFunctionNode(FunctionDatabaseNode function)
	{
		Map<String, Object> properties = function.createProperties();
		
		nodeStore.addNeo4jNode(function, properties);
		
		// index, but do not index location
		properties.remove("location");
		nodeStore.indexNode(function, properties);
			
		linkFunctionWithRootASTNode(function, function.getASTRoot());
		linkFunctionWithAllASTNodes(function, function.getASTRoot());
		
		CFG cfg = function.getCFG();
		if(cfg != null)
			linkFunctionWithAllCFGNodes(function, cfg);
	}

	
	private void linkFunctionWithRootASTNode(FunctionDatabaseNode function, ASTNode astRoot)
	{
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_FUNCTION_OF_AST_ROOT);
		
		long functionId = nodeStore.getIdForObject(function);
		long astRootId = nodeStore.getIdForObject(astRoot);
		
		Neo4JDatabase.addRelationship(functionId, astRootId, rel, null);
	}

	private void linkFunctionWithAllASTNodes(FunctionDatabaseNode function, ASTNode node)
	{
		linkParentWithASTNode(function, node);
		
		final int nChildren = node.getChildCount();
		for(int i = 0; i < nChildren; i++){
			ASTNode child = node.getChild(i);
			linkFunctionWithAllASTNodes(function, child);
		}
	}

	private void linkFunctionWithAllCFGNodes(FunctionDatabaseNode function, CFG cfg)
	{
		Vector<BasicBlock> basicBlocks = cfg.getBasicBlocks();
		Iterator<BasicBlock> it = basicBlocks.iterator();
		while(it.hasNext()){
			BasicBlock block = it.next();
			linkFunctionWithCFGNode(function, block);
		}
	}
	
	private void linkFunctionWithCFGNode(FunctionDatabaseNode function, BasicBlock block)
	{
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_FUNCTION_OF_BASIC_BLOCK);
		
		long functionId = nodeStore.getIdForObject(function);
		long dstId = nodeStore.getIdForObject(block);
		
		Neo4JDatabase.addRelationship(functionId, dstId, rel, null);
	}

	private void linkParentWithASTNode(Object parent, ASTNode node)
	{
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_FUNCTION_OF_AST_NODE);
		
		long parentId = nodeStore.getIdForObject(parent);
		long nodeId = nodeStore.getIdForObject(node);
		
		Neo4JDatabase.addRelationship(parentId, nodeId, rel, null);
	}

	public void setFilename(String aFilename)
	{
		filename = aFilename;
	}
}
