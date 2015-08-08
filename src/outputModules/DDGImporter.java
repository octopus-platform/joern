package outputModules;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ddg.DataDependenceGraph.DDG;
import ddg.DataDependenceGraph.DefUseRelation;

public abstract class DDGImporter
{
	public void addDDGToDatabase(DDG ddg)
	{

		Map<String, Object> properties = new HashMap<String, Object>();
		Set<DefUseRelation> defUseEdges = ddg.getDefUseEdges();

		if (defUseEdges == null)
			return;

		for (DefUseRelation defUseRel : defUseEdges)
		{
			properties.put("var", defUseRel.symbol);
			addDDGEdge(properties, defUseRel);
		}
	}

	protected abstract void addDDGEdge(Map<String, Object> properties,
			DefUseRelation defUseRel);
}
