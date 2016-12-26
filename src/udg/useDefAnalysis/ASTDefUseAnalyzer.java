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
import udg.useDefAnalysis.environments.IncDecEnvironment;
import udg.useDefAnalysis.environments.MemberAccessEnvironment;
import udg.useDefAnalysis.environments.PtrMemberAccessEnvironment;
import udg.useDefAnalysis.environments.UnaryOpEnvironment;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefAnalysis.environments.UseEnvironment;
import udg.useDefGraph.UseOrDef;

/**
 * The ASTDefUseAnalyzer determines symbol uses and definitions performed in a
 * given AST. It is currently run on statement ASTs as the core step in the
 * construction of the symbol graph (UDG).
 * */

public class ASTDefUseAnalyzer
{

	Stack<UseDefEnvironment> environmentStack = new Stack<UseDefEnvironment>();
	HashSet<UseOrDef> useDefsOfBlock = new HashSet<UseOrDef>();
	TaintSources taintSources = new TaintSources();

	/**
	 * Analyze an AST to determine the symbols used and defined by each AST
	 * node.
	 * 
	 * */

	public Collection<UseOrDef> analyzeAST(ASTProvider astProvider)
	{
		reset();
		traverseAST(astProvider);
		return useDefsOfBlock;
	}

	/**
	 * Inform the ASTAnalyzer about (callee, argNum)-pairs that define their
	 * arguments. For example, 'recv' defines its first argument.
	 * */

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

	private void traverseASTChildren(ASTProvider astProvider,
			UseDefEnvironment env)
	{

		int numChildren = astProvider.getChildCount();

		environmentStack.push(env);
		for (int i = 0; i < numChildren; i++)
		{
			ASTProvider childProvider = astProvider.getChild(i);
			traverseAST(childProvider);

			Collection<UseOrDef> toEmit = env
					.useOrDefsFromSymbols(childProvider);
			emitUseOrDefs(toEmit);
		}
		environmentStack.pop();

		reportUpstream(env);
	}

	/**
	 * Creates a UseDefEnvironment for a given AST node.
	 * */

	private UseDefEnvironment createUseDefEnvironment(ASTProvider astProvider)
	{

		String nodeType = astProvider.getTypeAsString();

		switch (nodeType)
		{
			case "AssignmentExpr":
				return new AssignmentEnvironment();
			case "IncDecOp":
				return new IncDecEnvironment();
			case "IdentifierDecl":
			case "Parameter":
				return new DeclEnvironment();

			case "CallExpression":
				return createCallEnvironment(astProvider);

			case "Argument":
				return createArgumentEnvironment(astProvider);

			case "PtrMemberAccess":
				return new PtrMemberAccessEnvironment();

			case "MemberAccess":
				return new MemberAccessEnvironment();

			case "Condition":
			case "ReturnStatement":
				return new UseEnvironment();

			case "ArrayIndexing":
				return new ArrayIndexingEnvironment();

			case "UnaryOp":
				return new UnaryOpEnvironment();
				
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
		if (taintSources.isTaintSource(callee))
		{
			List<Integer> taintedArgs = taintSources
					.getTaintedArgsForCallee(callee);
			callEnv.setTaintedArgs(taintedArgs);
		}
		return callEnv;
	}

	private ArgumentEnvironment createArgumentEnvironment(
			ASTProvider astProvider)
	{
		ArgumentEnvironment argEnv = new ArgumentEnvironment();
		CallEnvironment callEnv = (CallEnvironment) environmentStack
				.get(environmentStack.size() - 2);

		if (callEnv.isArgumentTainted(astProvider.getChildNumber()))
			argEnv.setIsTainted();

		return argEnv;
	}

	/**
	 * Gets upstream symbols from environment and passes them to
	 * parent-environment by calling addChildSymbols on the parent. Asks
	 * parent-environment to generate useOrDefs and emit them.
	 * */

	private void reportUpstream(UseDefEnvironment env)
	{

		LinkedList<String> symbols = env.upstreamSymbols();
		ASTProvider astProvider = env.getASTProvider();

		try
		{
			UseDefEnvironment parentEnv = environmentStack.peek();
			parentEnv.addChildSymbols(symbols, astProvider);
		}
		catch (EmptyStackException ex)
		{
			// stack is empty, we've reached the root.
			// Nothing to do.
		}
	}

	private void emitUseOrDefs(Collection<UseOrDef> toEmit)
	{
		for (UseOrDef useOrDef : toEmit)
			useDefsOfBlock.add(useOrDef);
	}

}
