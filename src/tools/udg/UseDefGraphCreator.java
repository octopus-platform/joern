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
		
 		IndexHits<Long> basicBlocks = QueryUtils.getBasicBlocksFromIndex(functionId);
		
		for(Long basicBlockId : basicBlocks){
			
			Long astRoot = QueryUtils.getASTForBasicBlock(basicBlockId);
			if(astRoot == -1) // perfectly normal, e.g., empty blocks.	
				continue;
						
			Collection<UseOrDef> usesAndDefs = astAnalyzer.analyzeAST(astRoot);
			addToUseDefGraph(usesAndDefs, basicBlockId);
		}
	
		return useDefGraph;
	}


	private void addToUseDefGraph(Collection<UseOrDef> usesAndDefs, Long basicBlockId)
	{
		for(UseOrDef useOrDef : usesAndDefs){
			
			if(useOrDef.isDef)
				useDefGraph.addDefinition(useOrDef.symbol, basicBlockId);
			else
				useDefGraph.addUse(useOrDef.symbol, basicBlockId);
		}
	}


	public void addTaintSource(String callee, int argNum)
	{
		astAnalyzer.addTaintSource(callee, argNum);
	}
		
}
