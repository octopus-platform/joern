package ddg;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import ast.ASTNode;
import misc.MultiHashMap;
import udg.useDefGraph.UseDefGraph;
import udg.useDefGraph.UseOrDefRecord;
import cfg.CFG;
import cfg.CFGEdge;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import ddg.DefUseCFG.DefUseCFG;

public class CFGAndUDGToDefUseCFG
{

	public DefUseCFG convert(CFG cfg, UseDefGraph udg)
	{
		DefUseCFG defUseCFG = new DefUseCFG();

		initializeStatements(cfg, defUseCFG);
		initializeDefUses(udg, defUseCFG);
		
		LinkedList<String> parameters = new LinkedList<String>();
		for (CFGNode parameterCFGNode : cfg.getParameters())
		{
			ASTNode astNode = ((ASTNodeContainer) parameterCFGNode).getASTNode();
			String symbol = astNode.getChild(1).getEscapedCodeStr();
			parameters.add(symbol);
		}
		
		defUseCFG.setExitNode(cfg.getExitNode());
		defUseCFG.setParameters(parameters);
		
		defUseCFG.addUsesForExitNode();
		initializeParentsAndChildren(cfg, defUseCFG);

		return defUseCFG;
	}

	private void initializeStatements(CFG cfg, DefUseCFG defUseCFG)
	{
		for (Object statement : cfg.getVertices())
		{
			if (statement instanceof ASTNodeContainer)
				statement = ((ASTNodeContainer) statement).getASTNode();
			defUseCFG.addStatement(statement);
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

				if (!record.getAstNode().isInCFG())
					continue;

				if (record.isDef())
					defUseCFG.addSymbolDefined(record.getAstNode(), symbol);
				else
					defUseCFG.addSymbolUsed(record.getAstNode(), symbol);
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

		Object src;
		Object dst;
		for (CFGEdge edge : cfg.getEdges())
		{
			src = edge.getSource();
			dst = edge.getDestination();
			if (src instanceof ASTNodeContainer)
				src = ((ASTNodeContainer) src).getASTNode();
			if (dst instanceof ASTNodeContainer)
				dst = ((ASTNodeContainer) dst).getASTNode();
			defUseCFG.addChildBlock(src, dst);
			defUseCFG.addParentBlock(dst, src);
		}
	}

}
