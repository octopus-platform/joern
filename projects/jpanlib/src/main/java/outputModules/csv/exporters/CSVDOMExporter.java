package outputModules.csv.exporters;

import cfg.nodes.CFGNode;
import outputModules.common.DOMExporter;
import cfg.nodes.ASTNodeContainer;
import databaseNodes.EdgeTypes;
import outputModules.common.Writer;

public class CSVDOMExporter extends DOMExporter
{

	@Override
	protected void addDomEdge(CFGNode vertex, CFGNode dominator)
	{
		long srcId = getId(dominator);
		long dstId = getId(vertex);
		Writer.addEdge(srcId, dstId, null, EdgeTypes.DOM);
	}

	@Override
	protected void addPostDomEdge(CFGNode vertex, CFGNode postDominator)
	{
		long srcId = getId(postDominator);
		long dstId = getId(vertex);
		Writer.addEdge(srcId, dstId, null, EdgeTypes.POST_DOM);
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
