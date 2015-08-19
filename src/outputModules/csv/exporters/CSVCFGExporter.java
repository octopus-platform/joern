package outputModules.csv.exporters;

import java.util.Map;

import outputModules.common.CFGExporter;
import outputModules.common.Writer;
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
				String.format("%d", Writer.getIdForObject(currentFunction)));
		Writer.addNode(statement, properties);
	}

	@Override
	protected void addFlowToLink(Object srcBlock, Object dstBlock,
			Map<String, Object> properties)
	{

		long srcId = Writer.getIdForObject(srcBlock);
		long dstId = Writer.getIdForObject(dstBlock);
		Writer.addEdge(srcId, dstId, properties, EdgeTypes.FLOWS_TO);

	}

}
