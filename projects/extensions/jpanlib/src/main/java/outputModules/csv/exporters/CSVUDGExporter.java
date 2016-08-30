package outputModules.csv.exporters;

import java.util.HashMap;
import java.util.Map;

import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;
import outputModules.common.UDGExporter;
import outputModules.common.Writer;
import udg.useDefGraph.UseOrDefRecord;

public class CSVUDGExporter extends UDGExporter
{

	@Override
	protected void addUseOrDefRecordToDatabase(long symbolNodeId,
			UseOrDefRecord item)
	{
		String edgeType;
		if (item.isDef())
			edgeType = EdgeTypes.DEF;
		else
			edgeType = EdgeTypes.USE;

		long nodeId = Writer.getIdForObject(item.getAstNode());
		Writer.addEdge(nodeId, symbolNodeId, null, edgeType);
	}

	@Override
	protected long createSymbolNode(String identifier)
	{
		long functionId = Writer.getIdForObject(currentFunction);

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(NodeKeys.NODE_TYPE, "Symbol");
		properties.put(NodeKeys.CODE, identifier);
		properties.put(NodeKeys.FUNCTION_ID, String.format("%d", functionId));

		long newNodeId = Writer.addNode(null, properties);
		return newNodeId;
	}
}
