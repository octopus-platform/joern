package udg;

import java.util.Collection;
import java.util.HashSet;
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
			
			ASTNode statementNode = cfgNode.getASTNode();
			
			// skip empty blocks
			if(statementNode == null)
				continue;
			
			ASTNodeASTProvider provider = new ASTNodeASTProvider();
			provider.setNode(statementNode);
			Collection<UseOrDef> usesAndDefs = astAnalyzer.analyzeAST(provider);
			addToUseDefGraph(useDefGraph, usesAndDefs, statementNode);
		}
			
		return useDefGraph;
	}
	
	private void addToUseDefGraph(UseDefGraph useDefGraph, Collection<UseOrDef> usesAndDefs, ASTNode statementNode)
	{
		HashSet<String> insertedForStatementDef = new HashSet<String>();
		HashSet<String> insertedForStatementUse = new HashSet<String>();
		
		for(UseOrDef useOrDef : usesAndDefs){
			
			ASTNodeASTProvider astProvider = (ASTNodeASTProvider) useOrDef.astProvider;
			// CHECK?
			ASTNode useOrDefNode = astProvider.getASTNode();
						
			if(useOrDef.isDef){
				
				if(!insertedForStatementDef.contains(useOrDef.symbol)){
					useDefGraph.addDefinition(useOrDef.symbol, statementNode);
					insertedForStatementDef.add(useOrDef.symbol);
				}
				
				if(useOrDefNode != null && useOrDefNode  != statementNode)
					useDefGraph.addDefinition(useOrDef.symbol, useOrDefNode);
			}else{
				
				if(!insertedForStatementUse.contains(useOrDef.symbol)){
					useDefGraph.addUse(useOrDef.symbol, statementNode);
					insertedForStatementUse.add(useOrDef.symbol);
				}
				
				if(useOrDef.astProvider != null && useOrDefNode != statementNode)
					useDefGraph.addUse(useOrDef.symbol, useOrDefNode);
			}
		}
	}
	
}
