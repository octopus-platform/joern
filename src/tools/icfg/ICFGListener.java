package tools.icfg;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.Neo4JBatchInserter;
import tools.CallResolver;
import tools.ImportedNodeListener;

public class ICFGListener extends ImportedNodeListener {

	CallResolver resolver = new CallResolver();
	
	@Override
	public void visitNode(Long callNodeId)
	{
		IndexHits<Long> dstIds = resolver.resolveByCallId(callNodeId);
		if(dstIds == null)
			return;
		
		for(Long dst : dstIds){
			List<Long> parameters = getParametersByFunctionId(dst);
		}
	}

	private List<Long> getParametersByFunctionId(Long dst)
	{
				
		String query = "type:\"ParameterList\" AND functionId:\"" + dst + "\"";
		IndexHits<Long> hits = Neo4JBatchInserter.queryIndex(query);
		
		if(hits == null) return null;
		if(hits.size() != 1)
			throw (new RuntimeException("Warning: Parameterlist not found or more than one."));
		
		Long parameterListId = hits.next();		
		List<Long> params = getParametersFromList(parameterListId);		
		return getIdentifiersFromParams(params);		
	}

	private List<Long> getIdentifiersFromParams(List<Long> params)
	{
		List<Long> retval = new LinkedList<Long>();
		
		for (Long paramId : params){
			Iterable<BatchRelationship> rels = Neo4JBatchInserter.getRelationships(paramId);
			for(BatchRelationship rel : rels){
				if(rel.getEndNode() == paramId)
					continue;
				
				long identifierNode = rel.getEndNode();				
				retval.add(identifierNode);				
				break;
			}
		}						
		
		return retval;
	}

	private List<Long> getParametersFromList(Long parameterListId)
	{
		List<Long> retval = new LinkedList<Long>();
		Iterable<BatchRelationship> rels = Neo4JBatchInserter.getRelationships(parameterListId);
	
		for(BatchRelationship rel : rels){
			if(rel.getEndNode() == parameterListId)
				continue;
			long parameterId = rel.getEndNode();					
			retval.add(parameterId);
		}
		return retval;
	}

}
