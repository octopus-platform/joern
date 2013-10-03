package tools.udg;

import java.util.LinkedList;
import java.util.List;

import misc.Pair;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.batchInserter.QueryUtils;

public class BatchInserterDBProvider extends DBProvider
{

	public String getNodeType(Long nodeId)
	{
		return QueryUtils.getNodeType(nodeId);
	}

	public String getCalleeFromCall(Long nodeId)
	{
		return QueryUtils.getCalleeFromCall(nodeId);
	}

	public List<Pair<Long,Integer>> getASTChildren(Long nodeId)
	{
		Iterable<BatchRelationship> rels = QueryUtils.getEdges(nodeId);
		List<Pair<Long, Integer>> retval = new LinkedList<Pair<Long, Integer>>();
		
		for(BatchRelationship rel : rels){
			if(QueryUtils.isIncomingEdge(nodeId, rel)) continue;
			if(!QueryUtils.isASTEdge(rel)) continue;
		
			long childId = rel.getEndNode();
			Integer childNumber = Integer.parseInt(QueryUtils.getChildNumber(rel));
			retval.add(new Pair<Long,Integer>(childId, childNumber));
		}
		return retval;
	}

	@Override
	public String getNodeCode(long nodeId)
	{
		return QueryUtils.getNodeCode(nodeId);
	}

	@Override
	public String getOperatorCode(long nodeId)
	{
		return QueryUtils.getOperatorCode(nodeId);
	}
}
