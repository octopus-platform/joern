package outputModules.csv.importers;

import java.util.Map;

import outputModules.DDGImporter;
import outputModules.csv.CSVWriter;
import databaseNodes.EdgeTypes;
import ddg.DataDependenceGraph.DefUseRelation;

public class CSVDDGImporter extends DDGImporter
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
