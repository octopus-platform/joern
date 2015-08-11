package outputModules.csv.exporters;

import java.util.Map;

import outputModules.common.DDGExporter;
import outputModules.csv.CSVWriter;
import databaseNodes.EdgeTypes;
import ddg.DataDependenceGraph.DefUseRelation;

public class CSVDDGExporter extends DDGExporter
{

	@Override
	protected void addDDGEdge(Map<String, Object> properties,
			DefUseRelation defUseRel)
	{
		long srcId = CSVWriter.getIdForObject(defUseRel.src);
		long dstId = CSVWriter.getIdForObject(defUseRel.dst);
		CSVWriter.addEdge(srcId, dstId, properties, EdgeTypes.REACHES);
	}

}
