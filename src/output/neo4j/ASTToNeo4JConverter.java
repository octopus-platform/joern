package output.neo4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import astnodes.ASTNode;
import astnodes.functionDef.FunctionDef;
import astwalking.ASTNodeVisitor;
import cfg.BasicBlock;
import cfg.CFG;
import cfg.Edges;
import cfg.EmptyBasicBlock;

public class ASTToNeo4JConverter extends ASTNodeVisitor
{
	GraphNodeStore nodeStore;
	String filename;
	
	public void setIndexDirectoryName(String dirName)
	{
		Neo4JDatabase.setIndexDirectoryName(dirName);
	}
	
	public void visit(FunctionDef node)
	{
		nodeStore =  new GraphNodeStore();
		addFunctionToDatabaseSafe(node);
	}

	private void addFunctionToDatabaseSafe(FunctionDef node)
	{
		try{
			Function function = new Function(node);
			function.setFilename(filename);
			addFunctionToDatabase(function);	
		}catch(RuntimeException ex)
		{
			// ex.printStackTrace();
			System.err.println("Error indexing function: " + node.name.getEscapedCodeStr());
			return;
		}
	}

	private void addFunctionToDatabase(Function function)
	{
		addASTToDatabase(function.getASTRoot());
		addCFGToDatabase(function.getCFG());
		addFunctionNode(function);
	}

	private void addASTToDatabase(ASTNode node)
	{
		addASTNode(node);
		
		final int nChildren = node.getChildCount();
		
		// not sure why, but adding AST-links backwards
		// results in the edges being returned in the
		// correct order by the database.
		
		for(int i = nChildren -1; i >=0; i--){
			ASTNode child = node.getChild(i);
			addASTToDatabase(child);
			addASTLink(node.id, child.id, child);
		}
	}

	private void addASTNode(ASTNode node)
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		
		String typeString = node.getTypeAsString();
		properties.put("type", typeString);
		properties.put("code", node.getEscapedCodeStr());
		
		long thisId = nodeStore.addNeo4jNode(node, properties);
		node.id = thisId;
	
		// index, but do not index code
		properties.remove("code");
		nodeStore.indexNode(thisId, properties);
	
	}

	private void addASTLink(long srcId, long dstId, ASTNode child)
	{
		RelationshipType rel = DynamicRelationshipType.withName("AST_CHILD");
		Map<String, Object> properties = new HashMap<String, Object>();
		String childStr = new Integer(child.getChildNumber()).toString();
		properties.put("n", childStr);
		
		Neo4JDatabase.addRelationship(srcId, dstId, rel, properties);
	}

	private void addCFGToDatabase(CFG cfg)
	{
		addCFGBasicBlocks(cfg);
		addCFGEdges(cfg);
	}

	private void addCFGBasicBlocks(CFG cfg)
	{
		Vector<BasicBlock> basicBlocks = cfg.getBasicBlocks();
		Iterator<BasicBlock> it = basicBlocks.iterator();
		while(it.hasNext()){
			BasicBlock block = it.next();
			
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("code", block.getEscapedCodeStr());
			properties.put("type", block.getType());
			
			block.id = nodeStore.addNeo4jNode(block, properties);
			addLinkFromBasicBlockToAST(block);
		
			// index, but do not index code
			properties.remove("code");
			nodeStore.indexNode(block.id, properties);
		}
	}
	
	private void addCFGEdges(CFG cfg)
	{
		
		Edges edges = cfg.getEdges();
		Iterator<Entry<Object, List<Object>>> it = edges.getEntrySetIterator();
		while(it.hasNext())
		{
			Entry<Object, List<Object>> entry = it.next();
			Object sourceBlock = entry.getKey();
			List<Object> dstBlockList = entry.getValue();
			for(Object dstBlock: dstBlockList){
				addFlowToLink((BasicBlock)sourceBlock, (BasicBlock)dstBlock);
			}
		}
	}

	private void addFlowToLink(BasicBlock srcBlock, BasicBlock dstBlock)
	{
		long srcId = srcBlock.id;
		long dstId = dstBlock.id;
		
		RelationshipType rel = DynamicRelationshipType.withName("FLOW_TO");
		Map<String, Object> properties = null;
		Neo4JDatabase.addRelationship(srcId, dstId, rel, properties);
	}

	private void addLinkFromBasicBlockToAST(BasicBlock block)
	{
		
		if(block instanceof EmptyBasicBlock)
			return;
		
		if(block.getStatements().size() == 0)
			return;
		
		ASTNode astNode = block.getStatements().get(0);
		
		if(astNode == null)
			return;
		
		long idForASTNode = astNode.id;
		long idForCFGNode = block.id;
		
		RelationshipType rel = DynamicRelationshipType.withName("IS_BASIC_BLOCK_OF");
		Map<String, Object> properties = null;
		Neo4JDatabase.addRelationship(idForCFGNode, idForASTNode, rel, properties);
		
	}

	private void addFunctionNode(Function function)
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("type", "Function");
		properties.put("filename", function.getFilename());
		properties.put("signature", function.getSignature());
		properties.put("location", function.getLocation());
		properties.put("functionName", function.getName());
		
		long thisId = nodeStore.addNeo4jNode(function, properties);
		
		// index, but do not index location
		properties.remove("location");
		nodeStore.indexNode(thisId, properties);
		
		linkFunctionWithRootASTNode(thisId, function.getASTRoot());
		linkFunctionWithAllASTNodes(thisId, function.getASTRoot());
		linkFunctionWithAllCFGNodes(thisId, function.getCFG());
	}
	
	private void linkFunctionWithRootASTNode(long thisId, ASTNode astRoot)
	{

		RelationshipType rel = DynamicRelationshipType.withName("AST_ROOT");
		long dstId = astRoot.id;
		Neo4JDatabase.addRelationship(thisId, dstId, rel, null);
	}

	private void linkFunctionWithAllASTNodes(long thisId, ASTNode node)
	{
		linkParentWithASTNode(thisId, node);
		
		final int nChildren = node.getChildCount();
		for(int i = 0; i < nChildren; i++){
			ASTNode child = node.getChild(i);
			linkFunctionWithAllASTNodes(thisId, child);
		}
	}

	private void linkFunctionWithAllCFGNodes(long thisId, CFG cfg)
	{
		Vector<BasicBlock> basicBlocks = cfg.getBasicBlocks();
		Iterator<BasicBlock> it = basicBlocks.iterator();
		while(it.hasNext()){
			BasicBlock block = it.next();
			linkFunctionWithCFGNode(thisId, block);
		}
	}
	
	private void linkFunctionWithCFGNode(long functionId, BasicBlock block)
	{
		RelationshipType rel = DynamicRelationshipType.withName("BASIC_BLOCK");
		long dstId = block.id;
		Neo4JDatabase.addRelationship(functionId, dstId, rel, null);
	}

	private void linkParentWithASTNode(long thisId, ASTNode node)
	{
		RelationshipType rel = DynamicRelationshipType.withName("AST_NODE");
		long dstId = node.id;
		Neo4JDatabase.addRelationship(thisId, dstId, rel, null);
	}
	
	
	public void begin()
	{
		Neo4JDatabase.start();
	}

	public void end()
	{
		Neo4JDatabase.shutdown();
	}

	public void setFilename(String aFilename)
	{
		filename = aFilename;
	}

	
}
