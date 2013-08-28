package tools.ddg;

import java.util.Map;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.EdgeTypes;
import output.neo4j.Neo4JBatchInserter;
import misc.MultiHashMap;

public class DDGEdgeAdder {

	long functionId;
	MultiHashMap UseDict = new MultiHashMap();
	MultiHashMap DefDict = new MultiHashMap();
	
	
	public void addEdgesToFunction(Long funcId)
	{
		functionId = funcId;
		preprocessCFG();
	}

	private void preprocessCFG()
	{
		IndexHits<Long> identifiers = getIdentifierASTNodes();	
		updateUseDefDicts(identifiers);
	}

	private IndexHits<Long> getIdentifierASTNodes()
	{
		String query = "type:\"Identifier\" AND functionId:\"" + functionId + "\"";
		return Neo4JBatchInserter.queryIndex(query);
	}
	
	private void updateUseDefDicts(IndexHits<Long> identifiersInFunc)
	{
		for(Long id : identifiersInFunc){				
			updateUseDefDictsVisit(id);												
		}
	}
	
	
	private void updateUseDefDictsVisit(Long id)
	{		
		if(parentIsBasicBlock(id))
			return;
		
		Map<String, Object> properties = Neo4JBatchInserter.getNodeProperties(id);
		String type = (String) properties.get("type");
		if(type != null){
			// Continue here, check for different types of nodes
			// to determine whether this is USE or DEF.
		}
		
		// visit parents
		Iterable<BatchRelationship> rels = Neo4JBatchInserter.getRelationships(id);							
		for(BatchRelationship rel : rels){
			long startNode = rel.getStartNode();
			if(startNode == id) continue;
		
			if(rel.getType().equals(EdgeTypes.IS_AST_PARENT))
				updateUseDefDictsVisit(startNode);
		}
		
	}

	private boolean parentIsBasicBlock(Long id)
	{
		Iterable<BatchRelationship> rels = Neo4JBatchInserter.getRelationships(id);							
		for(BatchRelationship rel : rels){
			long startNode = rel.getStartNode();
			if(startNode == id) continue;
			
			if(rel.getType().equals(EdgeTypes.IS_BASIC_BLOCK_OF))
				return true;
		}		
		return false;
	}


		
		


	

}
