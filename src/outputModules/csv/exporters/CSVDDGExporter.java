package outputModules.csv.exporters;

import java.util.Map;

import databaseNodes.EdgeTypes;
import ddg.DataDependenceGraph.DefUseRelation;
import outputModules.common.DDGExporter;
import outputModules.common.Writer;

public class CSVDDGExporter extends DDGExporter
{

	@Override
	protected void addDDGEdge(Map<String, Object> properties,
			DefUseRelation defUseRel)
	{
		long srcId = Writer.getIdForObject(defUseRel.src);
		long dstId = Writer.getIdForObject(defUseRel.dst);
		Writer.addEdge(srcId, dstId, properties, EdgeTypes.REACHES);
	}

}
