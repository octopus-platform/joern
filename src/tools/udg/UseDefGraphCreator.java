package tools.udg;

import java.util.Collection;
import java.util.Stack;

import org.neo4j.graphdb.index.IndexHits;

import tools.udg.environments.UseDefEnvironment;
import traversals.batchInserter.CFG;

// Create a UseDefGraph by running running an AST
// analyzer on each statement of the function
// to determine the symbols USEd and DEF'd.

public class UseDefGraphCreator
{
	
	UseDefGraph useDefGraph;
	Stack<UseDefEnvironment> useDefStack = new Stack<UseDefEnvironment>();	
	ASTDefUseAnalyzer astAnalyzer = new ASTDefUseAnalyzer();
	
	public UseDefGraph create(long functionId)
	{		
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


	public void addTaintSource(String callee, int argNum)
	{
		astAnalyzer.addTaintSource(callee, argNum);
	}
		
}
