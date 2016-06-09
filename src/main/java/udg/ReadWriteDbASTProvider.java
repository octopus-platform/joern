package udg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import misc.Pair;
import neo4j.dbProviders.ReadWriteDBProvider;
import udg.ASTProvider;

public class ReadWriteDbASTProvider extends ASTProvider
{

	ReadWriteDBProvider dbProvider = new ReadWriteDBProvider();

	long nodeId;
	boolean childrenLookupDone = false;

	ArrayList<Long> children = new ArrayList<Long>();

	public long getNodeId()
	{
		return nodeId;
	}

	public void setNodeId(long aNodeId)
	{
		nodeId = aNodeId;
	}

	@Override
	public String getTypeAsString()
	{
		return dbProvider.getNodeType(nodeId);
	}

	@Override
	public ASTProvider getChild(int i)
	{
		if (!childrenLookupDone)
			lookupChildren();
		ReadWriteDbASTProvider retval = new ReadWriteDbASTProvider();
		retval.setNodeId(children.get(i));
		return retval;
	}

	private void lookupChildren()
	{
		List<Pair<Long, Integer>> pairs = dbProvider.getASTChildren(nodeId);
		Iterator<Pair<Long, Integer>> it = pairs.iterator();
		while (it.hasNext())
		{
			Pair<Long, Integer> next = it.next();
			Long childId = next.getL();
			children.add(childId);
		}

		childrenLookupDone = true;
	}

	@Override
	public int getChildCount()
	{
		if (!childrenLookupDone)
			lookupChildren();

		return children.size();
	}

	@Override
	public String getEscapedCodeStr()
	{
		return dbProvider.getNodeCode(nodeId);
	}

	@Override
	public int getChildNumber()
	{
		return dbProvider.getChildNumber(nodeId);
	}

	@Override
	public String getOperatorCode()
	{
		return dbProvider.getOperatorCode(nodeId);
	}

}
