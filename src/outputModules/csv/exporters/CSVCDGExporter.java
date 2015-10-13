package outputModules.csv.exporters;

import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import databaseNodes.EdgeTypes;
import outputModules.common.CDGExporter;
import outputModules.common.Writer;

public class CSVCDGExporter extends CDGExporter
{

	@Override
	protected void addControlsEdge(CFGNode src, CFGNode dst)
	{
		long srcId = getId(src);
		long dstId = getId(dst);
		Writer.addEdge(srcId, dstId, null, EdgeTypes.CONTROLS);
	}

	private long getId(CFGNode node)
	{
		if (node instanceof ASTNodeContainer)
		{
			return Writer
					.getIdForObject(((ASTNodeContainer) node).getASTNode());
		}
		else
		{
			return Writer.getIdForObject(node);
		}
	}

}
