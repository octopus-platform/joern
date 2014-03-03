package tools.udg.dbProviders;

import java.util.List;

import output.neo4j.batchInserter.GraphNodeStore;
import misc.Pair;

public class GraphNodeStoreDBProvider extends DBProvider {

	GraphNodeStore store;
	
	public GraphNodeStoreDBProvider(GraphNodeStore aStore)
	{
		super();
		store = aStore;
	}
	
	@Override
	public String getNodeType(Long nodeId)
	{		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCalleeFromCall(Long nodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pair<Long, Integer>> getASTChildren(Long nodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNodeCode(long nodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOperatorCode(long nodeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
