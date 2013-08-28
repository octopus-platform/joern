package tools.callGraph;

import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.EdgeTypes;
import output.neo4j.Neo4JBatchInserter;
import tools.CallResolver;
import tools.ImportedNodeListener;

public class CallGraphListener extends ImportedNodeListener {

	CallResolver resolver = new CallResolver();
	
	public void visitNode(Long funcId)
	{
		createOutgoingCallGraphEdges(funcId);
	}

	private void createOutgoingCallGraphEdges(Long funcId)
	{
		IndexHits<Long> calls = getOutgoingCallsFromIndex(funcId);
		for(long callId : calls){
			IndexHits<Long> dstIds = resolver.resolveByCallId(callId);
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
	
	private void createCallGraphEdges(Long funcId, IndexHits<Long> dstIds, Long callId)
	{
		
		for(long dstId : dstIds){
			RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.IS_CALLER);
			Neo4JBatchInserter.addRelationship(funcId, dstId, rel, null);
			Neo4JBatchInserter.addRelationship(callId, dstId, rel, null);
		}
	}
	
}
