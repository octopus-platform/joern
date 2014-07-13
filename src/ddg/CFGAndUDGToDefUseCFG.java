package ddg;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import misc.MultiHashMap;
import udg.useDefGraph.UseDefGraph;
import udg.useDefGraph.UseOrDefRecord;
import astnodes.ASTNode;
import cfg.CFG;
import cfg.CFGEdge;
import cfg.CFGNode;
import ddg.DefUseCFG.DefUseCFG;

public class CFGAndUDGToDefUseCFG
{

	public DefUseCFG convert(CFG cfg, UseDefGraph udg)
	{
		DefUseCFG defUseCFG = new DefUseCFG();

		initializeStatements(cfg, defUseCFG);
		initializeDefUses(udg, defUseCFG);
		initializeParentsAndChildren(cfg, defUseCFG);

		return defUseCFG;
	}

	private void initializeStatements(CFG cfg, DefUseCFG defUseCFG)
	{
		for (CFGNode statement : cfg.getStatements())
		{
			ASTNode astNode = statement.getASTNode();
			Object id = (astNode != null) ? astNode : statement;
			defUseCFG.addStatement(id);
		}
	}

	private void initializeDefUses(UseDefGraph udg, DefUseCFG defUseCFG)
	{
		MultiHashMap<String, UseOrDefRecord> useDefDict = udg.getUseDefDict();
		Iterator<Entry<String, List<UseOrDefRecord>>> it = useDefDict
				.getEntrySetIterator();

		while (it.hasNext())
		{
			Entry<String, List<UseOrDefRecord>> next = it.next();
			String symbol = (String) next.getKey();
			List<UseOrDefRecord> defUseRecords = next.getValue();

			for (UseOrDefRecord record : defUseRecords)
			{

				if (!record.astNode.isInCFG())
					continue;

				if (record.isDef)
					defUseCFG.addSymbolDefined(record.astNode, symbol);
				else
					defUseCFG.addSymbolUsed(record.astNode, symbol);
			}

		}
	}

	private void initializeParentsAndChildren(CFG cfg, DefUseCFG defUseCFG)
	{
		// Edges edges = cfg.getEdges();
		// Iterator<Entry<Object, List<Object>>> it =
		// edges.getEntrySetIterator();
		// while(it.hasNext()){
		// Entry<Object, List<Object>> next = it.next();
		// CFGNode srcNode = (CFGNode) next.getKey();
		// List<Object> dsts = next.getValue();
		//
		//
		//
		// for(Object dst : dsts){
		// CFGNode dstNode = (CFGNode) dst;
		//
		// Object srcId = (srcNode.astNode != null)? srcNode.astNode : srcNode;
		// Object dstId = (dstNode.astNode != null)? dstNode.astNode : dstNode;
		//
		// defUseCFG.addChildBlock(srcId, dstId);
		// defUseCFG.addParentBlock(dstId, srcId);
		// }
		// }
		Iterator<CFGEdge> iterator = cfg.edgeIterator();
		CFGEdge edge;
		CFGNode src;
		CFGNode dst;
		while (iterator.hasNext())
		{
			edge = iterator.next();
			src = edge.getSource();
			dst = edge.getDestination();
			Object srcId = (src.astNode != null) ? src.astNode : src;
			Object dstId = (dst.astNode != null) ? dst.astNode : dst;

			defUseCFG.addChildBlock(srcId, dstId);
			defUseCFG.addParentBlock(dstId, srcId);
		}
	}

}
