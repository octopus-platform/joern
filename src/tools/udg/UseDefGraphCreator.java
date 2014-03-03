package tools.udg;

import java.util.Collection;
import java.util.Stack;

import org.neo4j.graphdb.index.IndexHits;

import tools.udg.useDefAnalysis.ASTDefUseAnalyzer;
import tools.udg.useDefAnalysis.environments.UseDefEnvironment;
import tools.udg.useDefGraph.UseDefGraph;
import tools.udg.useDefGraph.UseOrDef;
import traversals.batchInserter.CFG;

// Create a UseDefGraph by running running an AST
// analyzer on each statement of the function
// to determine the symbols USEd and DEF'd.

public class UseDefGraphCreator
{
	
	UseDefGraph useDefGraph;
	ASTDefUseAnalyzer astAnalyzer = new ASTDefUseAnalyzer();
	
	public void addTaintSource(String callee, int argNum)
	{
		astAnalyzer.addTaintSource(callee, argNum);
	}
		
	public UseDefGraph create(long functionId)
	{		
		// Incrementally create a UseDefGraph by generating
		// UseOrDefs for each statement separately and adding those
		// to the UseDefGraph
		
		useDefGraph = new UseDefGraph();
	
 		IndexHits<Long> statements = CFG.getStatementsFromIndex(functionId);
		
		for(Long statementId : statements){	
			Collection<UseOrDef> usesAndDefs = astAnalyzer.analyzeAST(statementId);
			addToUseDefGraph(usesAndDefs, statementId);
		}
	
		return useDefGraph;
	}


	private void addToUseDefGraph(Collection<UseOrDef> usesAndDefs, Long statementId)
	{
		for(UseOrDef useOrDef : usesAndDefs){
			
			if(useOrDef.isDef){
				useDefGraph.addDefinition(useOrDef.symbol, statementId);
				if(useOrDef.nodeId != 0 && useOrDef.nodeId != statementId)
					useDefGraph.addDefinition(useOrDef.symbol, useOrDef.nodeId);
			}else{
				useDefGraph.addUse(useOrDef.symbol, statementId);
				if(useOrDef.nodeId != 0 && useOrDef.nodeId != statementId)
					useDefGraph.addUse(useOrDef.symbol, useOrDef.nodeId);
			}
		}
	}
		
}
