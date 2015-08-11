package outputModules.csv.exporters;

import java.util.Map;

import outputModules.common.CFGExporter;
import outputModules.csv.CSVWriter;
import cfg.nodes.CFGNode;
import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;

public class CSVCFGExporter extends CFGExporter
{

	@Override
	protected void writeCFGNode(CFGNode statement,
			Map<String, Object> properties)
	{
		properties.put(NodeKeys.FUNCTION_ID,
				String.format("%d", CSVWriter.getIdForObject(currentFunction)));
		CSVWriter.addNode(statement, properties);
	}

	@Override
	protected void addFlowToLink(Object srcBlock, Object dstBlock,
			Map<String, Object> properties)
	{

		long srcId = CSVWriter.getIdForObject(srcBlock);
		long dstId = CSVWriter.getIdForObject(dstBlock);
		CSVWriter.addEdge(srcId, dstId, properties, EdgeTypes.FLOWS_TO);

	}

}
