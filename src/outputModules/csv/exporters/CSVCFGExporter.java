package outputModules.csv.exporters;

import java.util.Map;

import cfg.CFG;
import cfg.CFGEdge;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;
import outputModules.common.CFGExporter;
import outputModules.common.Writer;

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

	/**
	 * Simple method that takes a CFG and writes out the edges.
	 */
	public void writeCFGEdges(CFG cfg) {

		for( CFGEdge cfgEdge : cfg.getEdges())	{

			CFGNode src = cfgEdge.getSource();
			CFGNode dst = cfgEdge.getDestination();
			
			// skip empty blocks
			if( src instanceof ASTNodeContainer && dst instanceof ASTNodeContainer) {

				Writer.setIdForObject(src, ((ASTNodeContainer)src).getASTNode().getNodeId());
				Writer.setIdForObject(dst, ((ASTNodeContainer)dst).getASTNode().getNodeId());
				addFlowToLink( src, dst, null);
			}
		}
		// clean up
		Writer.reset();
	}
	
}
