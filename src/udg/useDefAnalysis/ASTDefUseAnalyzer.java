package udg.useDefAnalysis;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import udg.ASTProvider;
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
	TaintSources taintSources = new TaintSources();
	
	public Collection<UseOrDef> analyzeAST(ASTProvider astProvider)
	{
		reset();
		traverseAST(astProvider);
		return useDefsOfBlock;
	}

	public void addTaintSource(String callee, int argNum)
	{
		taintSources.add(callee, argNum);
	}
	
	private void reset()
	{
		environmentStack.clear();
		useDefsOfBlock.clear();
	}

	private void traverseAST(ASTProvider astProvider)
	{		
		UseDefEnvironment env = createUseDefEnvironment(astProvider);
		env.setASTProvider(astProvider);
		traverseASTChildren(astProvider, env);		
	}
	
	private UseDefEnvironment createUseDefEnvironment(ASTProvider astProvider)
	{
		
		String nodeType = astProvider.getTypeAsString();
		
		switch(nodeType){
		case "AssignmentExpr":
			return new AssignmentEnvironment();
		case "IdentifierDecl":
		case "Parameter":
			return new DeclEnvironment();
		
		case "CallExpression":
			return createCallEnvironment(astProvider);
			
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

	private UseDefEnvironment createCallEnvironment(ASTProvider astProvider)
	{
		CallEnvironment callEnv = new CallEnvironment();
		// inform calls of any arguments it might taint
		
		String callee = astProvider.getChild(0).getEscapedCodeStr();
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
	
	private void traverseASTChildren(ASTProvider astProvider, UseDefEnvironment env)
	{
		
		int numChildren = astProvider.getChildCount();
		
		for(int i = 0; i < numChildren; i++){
			ASTProvider childProvider = astProvider.getChild(i);
			
			configureEnvironmentForChild(env, childProvider);
			if(!env.shouldTraverse()) continue;
			
			environmentStack.push(env);
			traverseAST(childProvider);
			environmentStack.pop();
			reportUpstream(env);
		}
		
		if(numChildren == 0){
			reportUpstream(env);
		}
		
	}
	
	private void configureEnvironmentForChild(UseDefEnvironment env, ASTProvider childProvider)
	{
		String childType = childProvider.getTypeAsString();
		int childNumber = childProvider.getChildNumber();
		env.setChild(childType, childNumber);
	}
	
	
	private void reportUpstream(UseDefEnvironment childEnv) {
		
		LinkedList<String> symbols = childEnv.upstreamSymbols();
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
