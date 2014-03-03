package tools.udg.useDefAnalysis;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import neo4j.dbProviders.BatchInserterDBProvider;
import neo4j.dbProviders.DBProvider;
import misc.Pair;
import tools.udg.useDefAnalysis.environments.ArgumentEnvironment;
import tools.udg.useDefAnalysis.environments.ArrayIndexingEnvironment;
import tools.udg.useDefAnalysis.environments.AssignmentEnvironment;
import tools.udg.useDefAnalysis.environments.CallEnvironment;
import tools.udg.useDefAnalysis.environments.DeclEnvironment;
import tools.udg.useDefAnalysis.environments.IdentifierEnvironment;
import tools.udg.useDefAnalysis.environments.MemberAccessEnvironment;
import tools.udg.useDefAnalysis.environments.UseDefEnvironment;
import tools.udg.useDefAnalysis.environments.UseEnvironment;
import tools.udg.useDefGraph.UseOrDef;

public class ASTDefUseAnalyzer {

	Stack<UseDefEnvironment> environmentStack = new Stack<UseDefEnvironment>();
	HashSet<UseOrDef> useDefsOfBlock = new HashSet<UseOrDef>();
	DBProvider dbProvider = new BatchInserterDBProvider();
	
	TaintSources taintSources = new TaintSources();
	
	public Collection<UseOrDef> analyzeAST(long astRoot)
	{
		reset();
		traverseAST(astRoot);
		return useDefsOfBlock;
	}

	public void addTaintSource(String callee, int argNum)
	{
		taintSources.add(callee, argNum);
	}
	
	public void setDBProvider(DBProvider dbProvider)
	{
		this.dbProvider = dbProvider;
	}
	
	private void reset()
	{
		environmentStack.clear();
		useDefsOfBlock.clear();
	}

	private void traverseAST(Long nodeId)
	{		
		UseDefEnvironment env = createUseDefEnvironment(nodeId);
		env.setDBProvider(dbProvider);
		env.setNodeId(nodeId);
		
		traverseASTChildren(nodeId, env);		
	}
	
	private UseDefEnvironment createUseDefEnvironment(Long nodeId)
	{
		String nodeType = dbProvider.getNodeType(nodeId);
		
		switch(nodeType){
		case "AssignmentExpr":
			return new AssignmentEnvironment();
		case "IdentifierDecl":
		case "Parameter":
			return new DeclEnvironment();
		
		case "CallExpression":
			return createCallEnvironment(nodeId);
			
		case "Argument":
			return createArgumentEnvironment();
			
		case "PtrMemberAccess":
		case "MemberAccess":
			return new MemberAccessEnvironment();
			
		case "Condition":
		case "ReturnStatement":
			return new UseEnvironment();
		
		case "ArrayIndexing":
			return new ArrayIndexingEnvironment();
			
		case "Identifier":
			return new IdentifierEnvironment();
			
		default:
			return new UseDefEnvironment();
		}
	}

	private UseDefEnvironment createCallEnvironment(Long nodeId)
	{
		CallEnvironment callEnv = new CallEnvironment();
		// inform calls of any arguments it might taint
		String callee = dbProvider.getCalleeFromCall(nodeId);
		if(taintSources.isTaintSource(callee)){
			List<Integer> taintedArgs = taintSources.getTaintedArgsForCallee(callee);
			callEnv.setTaintedArgs(taintedArgs);
		}	
		return callEnv;
	}

	private ArgumentEnvironment createArgumentEnvironment()
	{
		ArgumentEnvironment argEnv = new ArgumentEnvironment();
		UseDefEnvironment argListEnv = environmentStack.peek();
		CallEnvironment callEnv =
				(CallEnvironment) environmentStack.get(environmentStack.size() - 2);
		
		if(callEnv.isArgumentTainted(argListEnv.getChildNum()))
			argEnv.setIsTainted();
		
		return argEnv;
	}
	
	private void traverseASTChildren(Long nodeId, UseDefEnvironment env)
	{

		List<misc.Pair<Long, Integer>> children = dbProvider.getASTChildren(nodeId);
		
		int nChildren = 0;
		
		// childId, childNumber -> index
		
		for(Pair<Long, Integer> child : children){
			
			long childId = child.getL() ;
			int childNumber = child.getR();

			configureEnvironmentForChild(env, childId, childNumber);
			if(!env.shouldTraverse()) continue;
			
			
			environmentStack.push(env);
			traverseAST(childId);
			environmentStack.pop();
			reportUpstream(env);
		
			nChildren++;
		}

		if(nChildren == 0){
			reportUpstream(env);
		}
		
	}
	
	private void configureEnvironmentForChild(UseDefEnvironment env, long childId, int childNumber)
	{
		String childType = dbProvider.getNodeType(childId);
		env.setChild(childType, childNumber);
	}
	
	
	private void reportUpstream(UseDefEnvironment childEnv) {
		
		Collection<String> symbols = childEnv.upstreamSymbols();
		try{
			UseDefEnvironment parentEnv = environmentStack.peek();
			parentEnv.addChildSymbols(symbols);
			Collection<UseOrDef> toEmit = parentEnv.useOrDefsFromChildSymbols();
			emitUseOrDefs(toEmit);
		}catch(EmptyStackException ex)
		{
			// stack is empty, we've reached the root.
			// Now emit anything that propagated this far
			LinkedList<UseOrDef> toEmit = childEnv.createUsesForAllSymbols(symbols);
			emitUseOrDefs(toEmit);
		}
	}

	private void emitUseOrDefs(Collection<UseOrDef> toEmit)
	{
		for (UseOrDef useOrDef : toEmit)
			useDefsOfBlock.add(useOrDef);
	}
	
}
