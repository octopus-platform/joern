package outputModules.csv.exporters;

import java.util.Map;

import ast.ASTNode;
import databaseNodes.EdgeTypes;
import ddg.DataDependenceGraph.DDG;
import ddg.DataDependenceGraph.DefUseRelation;
import outputModules.common.DDGExporter;
import outputModules.common.Writer;

public class CSVDDGExporter extends DDGExporter
{

	@Override
	protected void addDDGEdge(DefUseRelation defUseRel, Map<String, Object> properties)
	{
		long srcId = Writer.getIdForObject(defUseRel.src);
		long dstId = Writer.getIdForObject(defUseRel.dst);
		Writer.addEdge(srcId, dstId, properties, EdgeTypes.REACHES);
	}

	/**
	 * Simple method that takes a DDG and writes out the edges.
	 */
	public void writeDDGEdges(DDG ddg) {
	
		for( DefUseRelation ddgEdge : ddg.getDefUseEdges())	{
		
			// should always be instances of ASTNode
			if( ddgEdge.src instanceof ASTNode && ddgEdge.dst instanceof ASTNode) {
				
				Writer.setIdForObject(ddgEdge.src, ((ASTNode)ddgEdge.src).getNodeId());
				Writer.setIdForObject(ddgEdge.dst, ((ASTNode)ddgEdge.dst).getNodeId());
				addDDGEdge( ddgEdge, null);
			}
		}
		// clean up
		Writer.reset();
	}
}
