package neo4j.dbProviders;

import java.util.List;

import misc.Pair;

public abstract class DBProvider
{

	public abstract String getNodeType(Long nodeId);

	public abstract String getCalleeFromCall(Long nodeId);

	public abstract List<Pair<Long, Integer>> getASTChildren(Long nodeId);

	public abstract String getNodeCode(long nodeId);

	public abstract String getOperatorCode(long nodeId);

	public abstract int getChildNumber(long nodeId);

}
