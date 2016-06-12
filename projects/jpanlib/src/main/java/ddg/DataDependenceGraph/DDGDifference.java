package ddg.DataDependenceGraph;

import java.util.LinkedList;
import java.util.List;

public class DDGDifference
{

	private List<DefUseRelation> relsToAdd = new LinkedList<DefUseRelation>();
	private List<DefUseRelation> relsToRemove = new LinkedList<DefUseRelation>();

	public void addRelToAdd(DefUseRelation rel)
	{
		relsToAdd.add(rel);
	}

	public void addRelToRemove(DefUseRelation rel)
	{
		relsToRemove.add(rel);
	}

	public List<DefUseRelation> getRelsToAdd()
	{
		return relsToAdd;
	}

	public List<DefUseRelation> getRelsToRemove()
	{
		return relsToRemove;
	}

}
