package outputModules.csv.exporters;

import outputModules.common.CDGExporter;
import outputModules.common.Writer;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import databaseNodes.EdgeTypes;

public class CSVCDGExporter extends CDGExporter
{

	@Override
	protected void addControlsEdge(CFGNode src, CFGNode dst)
	{
		long srcId = getId(src);
		long dstId = getId(dst);
		Writer.addEdge(srcId, dstId, null, EdgeTypes.CONTROLS);
	}

	@Override
	protected void addPostDomEdge(CFGNode vertex, CFGNode dominator)
	{
		long srcId = getId(dominator);
		long dstId = getId(vertex);
		Writer.addEdge(srcId, dstId, null, EdgeTypes.POST_DOM);
	}

	private long getId(CFGNode node)
	{
		if (node instanceof ASTNodeContainer)
		{
			return Writer.getIdForObject(((ASTNodeContainer) node)
					.getASTNode());
		}
		else
		{
			return Writer.getIdForObject(node);
		}
	}

}
