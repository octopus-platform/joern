package tools.icfg;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.EdgeTypes;
import output.neo4j.BatchInserter.Neo4JBatchInserter;

public class CallResolver {
	
	public IndexHits<Long> resolveByCallId(long callId)
	{
		String calleeString = getCalleeString(callId);
		IndexHits<Long> calleeIds = lookupCallee(calleeString);
		return calleeIds;
	}

	private String getCalleeString(Long callId)
	{	
		try{
			long firstChildId = getFirstChildId(callId);
			String codeStr = (String) Neo4JBatchInserter.getNodeProperties(firstChildId).get("code");
			return codeStr;			
		}catch(RuntimeException ex){
			System.err.println(ex.getMessage());
		}
		return "";
	}

	private long getFirstChildId(Long callId)
	{
		Iterable<BatchRelationship> rels = Neo4JBatchInserter.getRelationships(callId);
		long relId, endNode;
		Object nProperty;
		
		for(BatchRelationship rel : rels){
			
			// only consider outgoing nodes
			endNode = rel.getEndNode();
			
			if(endNode == callId)
				continue;
			
			// don't think we need this.
			if(!rel.getType().name().equals(EdgeTypes.IS_AST_PARENT))
				continue;
			
			relId = rel.getId();
			
			nProperty = Neo4JBatchInserter.getRelationshipProperties(relId).get("n");
			if(nProperty == null || (!nProperty.equals("0")))
				continue;
						
			return endNode;				
		}
		throw new RuntimeException("Warning: encountered CallExpression without child nodes.");
	}
	
	private IndexHits<Long> lookupCallee(String callee)
	{
		if(callee.contains(" "))
			return null;
			
		String query = "type:\"Function\" AND functionName:\"" + callee + "\"";
		
		IndexHits<Long> hits =
				Neo4JBatchInserter.queryIndex(query);
		
		return hits;
	}

}
