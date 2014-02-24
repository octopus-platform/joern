package tools.udg;

import java.util.LinkedList;
import java.util.List;

import misc.Pair;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import output.neo4j.EdgeTypes;
import output.neo4j.readWriteDB.Neo4JDBInterface;
import output.neo4j.readWriteDB.QueryUtils;

public class ReadWriteDBProvider extends DBProvider {

	@Override
	public String getNodeType(Long nodeId)
	{
		return QueryUtils.getNodeType(nodeId);
	}

	@Override
	public String getCalleeFromCall(Long nodeId)
	{
		return QueryUtils.getCalleeFromCall(nodeId);
	}

	@Override
	public List<Pair<Long, Integer>> getASTChildren(Long nodeId)
	{
		List<Pair<Long, Integer>> retval = new LinkedList<Pair<Long, Integer>>();
		Node node = Neo4JDBInterface.getNodeById(nodeId);
		
		Iterable<Relationship> rels = node.getRelationships();
		for(Relationship rel : rels){
			if(!rel.getType().name().equals(EdgeTypes.IS_AST_PARENT)) continue;
			if(rel.getEndNode().getId() == node.getId()) continue;
			
			long childId = rel.getEndNode().getId();
			int childNumber = Integer.parseInt(rel.getProperty("n").toString());
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
