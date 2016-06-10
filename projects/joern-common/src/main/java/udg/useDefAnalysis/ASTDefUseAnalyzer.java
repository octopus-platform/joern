package udg.useDefAnalysis;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefGraph.UseOrDef;

/**
 * The ASTDefUseAnalyzer determines symbol uses and definitions performed in a
 * given AST. It is currently run on statement ASTs as the core step in the
 * construction of the symbol graph (UDG).
 */
public abstract class ASTDefUseAnalyzer
{
	protected Stack<UseDefEnvironment> environmentStack = new Stack<UseDefEnvironment>();
	protected HashSet<UseOrDef> useDefsOfBlock = new HashSet<UseOrDef>();

	/**
	 * Analyze an AST to determine the symbols used and defined by each AST
	 * node.
	 */
	public Collection<UseOrDef> analyzeAST(ASTProvider astProvider)
	{
		environmentStack.clear();
		useDefsOfBlock.clear();
		traverseAST(astProvider);
		return useDefsOfBlock;
	}

	public void reset()
	{
		environmentStack.clear();
		useDefsOfBlock.clear();
	}

	/**
	 * Recurses through the given AST and emit uses or defs symbols.
	 */
	protected void traverseAST(ASTProvider astProvider)
	{
		UseDefEnvironment env = createUseDefEnvironment(astProvider);
		env.setASTProvider(astProvider);

		int numChildren = astProvider.getChildCount();

		environmentStack.push(env);
		for (int i = 0; i < numChildren; i++)
		{
			ASTProvider childProvider = astProvider.getChild(i);
			if( env.shouldTraverse(childProvider))
				traverseAST(childProvider);

			useDefsOfBlock.addAll(env.useOrDefsFromSymbols(childProvider));
		}
		environmentStack.pop();

		reportUpstream(env);
	}

	/**
	 * Creates a UseDefEnvironment for a given AST node.
	 * This is language-specific and should be implemented by inheriting classes.
	 */
	protected abstract UseDefEnvironment createUseDefEnvironment(ASTProvider astProvider);

	/**
	 * Gets upstream symbols from environment and passes them to
	 * parent-environment by calling addChildSymbols on the parent. Asks
	 * parent-environment to generate useOrDefs and emit them.
	 */
	private void reportUpstream(UseDefEnvironment env)
	{
		LinkedList<String> symbols = env.upstreamSymbols();
		ASTProvider astProvider = env.getASTProvider();

		try
		{
			UseDefEnvironment parentEnv = environmentStack.peek();
			parentEnv.addChildSymbols(symbols, astProvider);
		} catch (EmptyStackException ex)
		{
			// stack is empty, we've reached the root.
			// Nothing to do.
		}
	}
}
