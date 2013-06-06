package tools.callGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.EdgeTypes;
import output.neo4j.Neo4JBatchInserter;

public class CallGraphListener {

	public void visitFunction(Long funcId)
	{
		List<String> calleeStrings = getCalleeStrings(funcId);
		for(String callee : calleeStrings){
			IndexHits<Long> dstIds = lookupCallee(callee);
			createCallGraphEdges(funcId, dstIds);
		}
	}

	private void createCallGraphEdges(Long funcId, IndexHits<Long> dstIds)
	{
		for(long dstId : dstIds){
			RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_CALLER);
			Neo4JBatchInserter.addRelationship(funcId, dstId, rel, null);
		}
	}

	private IndexHits<Long> lookupCallee(String callee)
	{
		String query = "type:\"Function\" AND functionName:\"" + callee + "\"";
		
		IndexHits<Long> hits =
				Neo4JBatchInserter.queryIndex(query);
		
		return hits;
	}

	private List<String> getCalleeStrings(Long funcId)
	{	
		IndexHits<Long> hits = getOutgoingCallsFromIndex(funcId);
		List<String> callees = getCalleesFromCallNodes(hits);
		return callees;
	}

	private List<String> getCalleesFromCallNodes(IndexHits<Long> hits)
	{
		List<String> retList = new LinkedList<String>();
		
		for(Long callId: hits){
		
			long firstChildId = getFirstChildId(callId);
			String codeStr = (String) Neo4JBatchInserter.getNodeProperties(firstChildId).get("code");
			retList.add(codeStr);
		}
		return retList;
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
	
	private IndexHits<Long> getOutgoingCallsFromIndex(Long funcId)
	{
		String query = "type:\"CallExpression\" AND functionId:\"" + funcId + "\"";
		IndexHits<Long> hits =
				Neo4JBatchInserter.queryIndex(query);
		return hits;
	}

}
