package tools.callGraph;

import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.EdgeTypes;
import output.neo4j.Neo4JBatchInserter;
import tools.ImportedNodeListener;

public class CallGraphListener extends ImportedNodeListener {

	public void visitNode(Long funcId)
	{
		createOutgoingCallGraphEdges(funcId);
	}

	private void createOutgoingCallGraphEdges(Long funcId)
	{
		IndexHits<Long> calls = getOutgoingCallsFromIndex(funcId);
		for(long callId : calls){
			IndexHits<Long> dstIds = resolveCalledFunction(callId);
			if(dstIds == null) continue;
			createCallGraphEdges(funcId, dstIds, callId);
		}
	}

	private IndexHits<Long> getOutgoingCallsFromIndex(Long funcId)
	{
		String query = "type:\"CallExpression\" AND functionId:\"" + funcId + "\"";
		IndexHits<Long> hits =
				Neo4JBatchInserter.queryIndex(query);
		return hits;
	}
	
	private IndexHits<Long> resolveCalledFunction(long callId)
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
	
	private IndexHits<Long> lookupCallee(String callee)
	{
		if(callee.contains(" "))
			return null;
		
		String query = "type:\"Function\" AND functionName:\"" + callee + "\"";
		
		IndexHits<Long> hits =
				Neo4JBatchInserter.queryIndex(query);
		
		return hits;
	}
	
	private long getFirstChildId(Long callId)
	{
		Iterable<BatchRelationship> rels = Neo4JBatchInserter.getRelationships(callId);
		
		for(BatchRelationship rel : rels){
			
			if(!rel.getType().name().equals(EdgeTypes.IS_AST_PARENT))
				continue;
			
			long relId = rel.getId();
			Map<String, Object> relProps = Neo4JBatchInserter.getRelationshipProperties(relId);
			Object nProperty= relProps.get("n");
			if(nProperty == null) continue;
			
			if(nProperty.equals("0")){
				if(rel.getEndNode() != callId)
					return rel.getEndNode();
			}
				
		}
		throw new RuntimeException("Warning: encountered CallExpression without child nodes.");
	}

	private void createCallGraphEdges(Long funcId, IndexHits<Long> dstIds, Long callId)
	{
		
		for(long dstId : dstIds){
			RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_CALLER);
			Neo4JBatchInserter.addRelationship(funcId, dstId, rel, null);
			Neo4JBatchInserter.addRelationship(callId, dstId, rel, null);
		}
	}
	
}
