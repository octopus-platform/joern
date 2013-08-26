package output.neo4j.importers;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.EdgeTypes;
import output.neo4j.GraphNodeStore;
import output.neo4j.Neo4JBatchInserter;
import output.neo4j.nodes.BasicBlockDatabaseNode;

import astnodes.ASTNode;
import cfg.BasicBlock;
import cfg.CFG;
import cfg.Edges;
import cfg.EmptyBasicBlock;

public class CFGImporter
{
	GraphNodeStore nodeStore;
	
	public CFGImporter(GraphNodeStore aNodeStore)
	{
		nodeStore = aNodeStore;
	}
	
	public void addCFGToDatabase(CFG cfg)
	{
		if(cfg == null) return;
		
		addCFGBasicBlocks(cfg);
		addCFGEdges(cfg);
	}

	private void addCFGBasicBlocks(CFG cfg)
	{
		Vector<BasicBlock> basicBlocks = cfg.getBasicBlocks();
		Iterator<BasicBlock> it = basicBlocks.iterator();
		while(it.hasNext()){
			BasicBlock block = it.next();
			
			BasicBlockDatabaseNode bbDatabaseNode = new BasicBlockDatabaseNode();
			bbDatabaseNode.initialize(block);
			Map<String, Object> properties = bbDatabaseNode.createProperties();
			nodeStore.addNeo4jNode(block, properties);
			addLinkFromBasicBlockToAST(block);
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
		long srcId = nodeStore.getIdForObject(srcBlock);
		long dstId = nodeStore.getIdForObject(dstBlock);
		
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.FLOWS_TO);
		Map<String, Object> properties = null;
		Neo4JBatchInserter.addRelationship(srcId, dstId, rel, properties);
	}

	private void addLinkFromBasicBlockToAST(BasicBlock block)
	{
		
		if(block instanceof EmptyBasicBlock)
			return;
		
		if(block.getASTNode() == null)
			return;
		
		ASTNode astNode = block.getASTNode();
		
		if(astNode == null)
			return;
		
		long idForASTNode = nodeStore.getIdForObject(astNode);
		long idForCFGNode = nodeStore.getIdForObject(block);
		
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_BASIC_BLOCK_OF);
		Map<String, Object> properties = null;
		Neo4JBatchInserter.addRelationship(idForCFGNode, idForASTNode, rel, properties);
		
	}
}
