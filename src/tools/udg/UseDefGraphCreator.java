package tools.udg;

import java.util.Collection;
import java.util.Stack;

import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.batchInserter.QueryUtils;
import tools.udg.environments.UseDefEnvironment;

// Create a UseDefGraph by running running a basic
// block analyzer on each basic block of the function
// to determine the symbols USEs and DEFs 

public class UseDefGraphCreator
{
	
	UseDefGraph useDefGraph;
	Stack<UseDefEnvironment> useDefStack = new Stack<UseDefEnvironment>();	
	ASTDefUseAnalyzer astAnalyzer = new ASTDefUseAnalyzer();
	
	
	public UseDefGraph create(long functionId)
	{		
		useDefGraph = new UseDefGraph();
		
 		IndexHits<Long> statements = QueryUtils.getStatementsFromIndex(functionId);
		
		for(Long statementId : statements){
			
			Long astRoot = QueryUtils.getASTForStatement(statementId);
			if(astRoot == -1) // perfectly normal, e.g., empty blocks.	
				continue;
						
			Collection<UseOrDef> usesAndDefs = astAnalyzer.analyzeAST(astRoot);
			addToUseDefGraph(usesAndDefs, statementId);
		}
	
		return useDefGraph;
	}


	private void addToUseDefGraph(Collection<UseOrDef> usesAndDefs, Long statementId)
	{
		for(UseOrDef useOrDef : usesAndDefs){
			
			if(useOrDef.isDef){
				useDefGraph.addDefinition(useOrDef.symbol, statementId);
				if(useOrDef.nodeId != 0)
					useDefGraph.addDefinition(useOrDef.symbol, useOrDef.nodeId);
			}else{
				useDefGraph.addUse(useOrDef.symbol, statementId);
				if(useOrDef.nodeId != 0)
					useDefGraph.addUse(useOrDef.symbol, useOrDef.nodeId);
			}
		}
	}


	public void addTaintSource(String callee, int argNum)
	{
		astAnalyzer.addTaintSource(callee, argNum);
	}
		
}
