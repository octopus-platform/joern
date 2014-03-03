package udg.useDefAnalysis;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import astnodes.ASTNode;
import neo4j.dbProviders.BatchInserterDBProvider;
import neo4j.dbProviders.DBProvider;
import misc.Pair;
import udg.useDefAnalysis.environments.ArgumentEnvironment;
import udg.useDefAnalysis.environments.ArrayIndexingEnvironment;
import udg.useDefAnalysis.environments.AssignmentEnvironment;
import udg.useDefAnalysis.environments.CallEnvironment;
import udg.useDefAnalysis.environments.DeclEnvironment;
import udg.useDefAnalysis.environments.IdentifierEnvironment;
import udg.useDefAnalysis.environments.MemberAccessEnvironment;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefAnalysis.environments.UseEnvironment;
import udg.useDefGraph.UseOrDef;

public class ASTDefUseAnalyzer {

	Stack<UseDefEnvironment> environmentStack = new Stack<UseDefEnvironment>();
	HashSet<UseOrDef> useDefsOfBlock = new HashSet<UseOrDef>();
	DBProvider dbProvider = new BatchInserterDBProvider();
	
	TaintSources taintSources = new TaintSources();
	
	public Collection<UseOrDef> analyzeAST(ASTNode astNode)
	{
		reset();
		traverseAST(astNode);
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

	private void traverseAST(ASTNode astNode)
	{		
		UseDefEnvironment env = createUseDefEnvironment(astNode);
		env.setASTNode(astNode);
		
		traverseASTChildren(astNode, env);		
	}
	
	private UseDefEnvironment createUseDefEnvironment(ASTNode astNode)
	{
		
		String nodeType = astNode.getTypeAsString();
		
		switch(nodeType){
		case "AssignmentExpr":
			return new AssignmentEnvironment();
		case "IdentifierDecl":
		case "Parameter":
			return new DeclEnvironment();
		
		case "CallExpression":
			return createCallEnvironment(astNode);
			
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

	private UseDefEnvironment createCallEnvironment(ASTNode astNode)
	{
		CallEnvironment callEnv = new CallEnvironment();
		// inform calls of any arguments it might taint
		
		String callee = astNode.getChild(0).getEscapedCodeStr();
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
	
	private void traverseASTChildren(ASTNode astNode, UseDefEnvironment env)
	{
		
		int numChildren = astNode.getChildCount();
		
		for(int i = 0; i < numChildren; i++){
			ASTNode childNode = astNode.getChild(i);
			
			configureEnvironmentForChild(env, childNode);
			if(!env.shouldTraverse()) continue;
			
			environmentStack.push(env);
			traverseAST(childNode);
			environmentStack.pop();
			reportUpstream(env);
		}
		
		if(numChildren == 0){
			reportUpstream(env);
		}
		
	}
	
	private void configureEnvironmentForChild(UseDefEnvironment env, ASTNode childNode)
	{
		String childType = childNode.getTypeAsString();
		int childNumber = childNode.getChildNumber();
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
