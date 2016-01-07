package udg.useDefAnalysis;

import java.util.Collection;

import udg.ASTProvider;
import udg.useDefGraph.UseOrDef;

/**
 * The ASTDefUseAnalyzer determines symbol uses and definitions performed in a
 * given AST. It is currently run on statement ASTs as the core step in the
 * construction of the symbol graph (UDG).
 */

public abstract interface ASTDefUseAnalyzer
{
	/**
	 * Analyze an AST to determine the symbols used and defined by each AST
	 * node.
	 */
	public abstract Collection<UseOrDef> analyzeAST(ASTProvider astProvider);
}
