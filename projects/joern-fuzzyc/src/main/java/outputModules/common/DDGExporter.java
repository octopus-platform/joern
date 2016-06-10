package outputModules.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import databaseNodes.EdgeKeys;
import ddg.DataDependenceGraph.DDG;
import ddg.DataDependenceGraph.DefUseRelation;

public abstract class DDGExporter
{
	public void addDDGToDatabase(DDG ddg)
	{

		Map<String, Object> properties = new HashMap<String, Object>();
		Set<DefUseRelation> defUseEdges = ddg.getDefUseEdges();

		if (defUseEdges == null)
			return;

		for (DefUseRelation defUseRel : defUseEdges)
		{
			properties.put( EdgeKeys.VAR, defUseRel.symbol);
			addDDGEdge(defUseRel, properties);
		}
	}

	protected abstract void addDDGEdge(DefUseRelation defUseRel, Map<String, Object> properties);
}
