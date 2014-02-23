package output.neo4j.importers;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.EdgeTypes;
import output.neo4j.batchInserter.GraphNodeStore;
import output.neo4j.batchInserter.Neo4JBatchInserter;
import output.neo4j.nodes.StmtOrCndDatabaseNode;
import output.neo4j.nodes.FunctionDatabaseNode;
import astnodes.ASTNode;
import cfg.StatementOrCondition;
import cfg.CFG;
import cfg.Edges;
import cfg.EmptyStatement;

public class CFGImporter
{
	GraphNodeStore nodeStore;
	
	private FunctionDatabaseNode currentFunction;
	
	public CFGImporter(GraphNodeStore aNodeStore)
	{
		nodeStore = aNodeStore;
	}
	
	public void setCurrentFunction(FunctionDatabaseNode func)
	{
		currentFunction = func;
	}	
	
	public void addCFGToDatabase(CFG cfg)
	{
		if(cfg == null) return;
		
		addCFGStatements(cfg);
		addCFGEdges(cfg);
	}

	private void addCFGStatements(CFG cfg)
	{
		Vector<StatementOrCondition> statemens = cfg.getStatements();
		Iterator<StatementOrCondition> it = statemens.iterator();
		while(it.hasNext()){
			StatementOrCondition block = it.next();
			
			StmtOrCndDatabaseNode bbDatabaseNode = new StmtOrCndDatabaseNode();
			bbDatabaseNode.initialize(block);
			Map<String, Object> properties = bbDatabaseNode.createProperties();
						
			properties.put("functionId", nodeStore.getIdForObject(currentFunction));
			
			nodeStore.addNeo4jNode(block, properties);
			nodeStore.indexNode(block, properties);
			addLinkFromStatementToAST(block);					
		
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
				addFlowToLink((StatementOrCondition)sourceBlock, (StatementOrCondition)dstBlock);
			}
		}
	}

	private void addFlowToLink(StatementOrCondition srcBlock, StatementOrCondition dstBlock)
	{
		long srcId = nodeStore.getIdForObject(srcBlock);
		long dstId = nodeStore.getIdForObject(dstBlock);
		
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.FLOWS_TO);
		Map<String, Object> properties = null;
		Neo4JBatchInserter.addRelationship(srcId, dstId, rel, properties);
	}

	private void addLinkFromStatementToAST(StatementOrCondition block)
	{
		
		if(block instanceof EmptyStatement)
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
