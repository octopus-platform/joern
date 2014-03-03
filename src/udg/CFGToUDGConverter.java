package udg;

import java.util.Collection;
import java.util.Vector;

import astnodes.ASTNode;
import udg.useDefAnalysis.ASTDefUseAnalyzer;
import udg.useDefGraph.UseDefGraph;
import udg.useDefGraph.UseOrDef;
import cfg.CFG;
import cfg.CFGNode;

public class CFGToUDGConverter {

	ASTDefUseAnalyzer astAnalyzer = new ASTDefUseAnalyzer();
	
	public void addTaintSource(String callee, int argNum)
	{
		astAnalyzer.addTaintSource(callee, argNum);
	}
	
	public UseDefGraph convert(CFG cfg)
	{
		// Incrementally create a UseDefGraph by generating
		// UseOrDefs for each statement separately and adding those
		// to the UseDefGraph
				
		UseDefGraph useDefGraph = new UseDefGraph();
		
		Vector<CFGNode> statements = cfg.getStatements();
						
		for(CFGNode cfgNode : statements){	
			
			ASTNode astNode = cfgNode.getASTNode();
			
			// skip empty blocks
			if(astNode == null)
				continue;
			
			Collection<UseOrDef> usesAndDefs = astAnalyzer.analyzeAST(astNode);
			addToUseDefGraph(useDefGraph, usesAndDefs, astNode);
		}
			
		return useDefGraph;
	}
	
	private void addToUseDefGraph(UseDefGraph useDefGraph, Collection<UseOrDef> usesAndDefs, ASTNode astNode)
	{
		for(UseOrDef useOrDef : usesAndDefs){
			
			if(useOrDef.isDef){
				useDefGraph.addDefinition(useOrDef.symbol, astNode);
				if(useOrDef.astNode != null && useOrDef.astNode != astNode)
					useDefGraph.addDefinition(useOrDef.symbol, useOrDef.astNode);
			}else{
				useDefGraph.addUse(useOrDef.symbol, astNode);
				if(useOrDef.astNode != null && useOrDef.astNode != astNode)
					useDefGraph.addUse(useOrDef.symbol, useOrDef.astNode);
			}
		}
	}
	
}
