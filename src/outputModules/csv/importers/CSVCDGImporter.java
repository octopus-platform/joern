package outputModules.csv.importers;

import outputModules.CDGImporter;
import outputModules.csv.CSVWriter;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import databaseNodes.EdgeTypes;

public class CSVCDGImporter extends CDGImporter
{

	@Override
	protected void addControlsEdge(CFGNode src, CFGNode dst)
	{
		long srcId = getId(src);
		long dstId = getId(dst);
		CSVWriter.addEdge(srcId, dstId, null, EdgeTypes.CONTROLS);
	}

	@Override
	protected void addPostDomEdge(CFGNode vertex, CFGNode dominator)
	{
		long srcId = getId(dominator);
		long dstId = getId(vertex);
		CSVWriter.addEdge(srcId, dstId, null, EdgeTypes.POST_DOM);
	}

	private long getId(CFGNode node)
	{
		if (node instanceof ASTNodeContainer)
		{
			return CSVWriter.getIdForObject(((ASTNodeContainer) node)
					.getASTNode());
		}
		else
		{
			return CSVWriter.getIdForObject(node);
		}
	}

}
