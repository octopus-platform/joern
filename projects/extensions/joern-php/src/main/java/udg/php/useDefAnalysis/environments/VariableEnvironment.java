package udg.php.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import ast.expressions.StringExpression;
import udg.ASTNodeASTProvider;
import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefGraph.UseOrDef;

public class VariableEnvironment extends UseDefEnvironment
{
	private boolean emitUse = false;
	
	// pass the 'code' of the variable upstream (i.e., the variable's name)
	@Override
	public LinkedList<String> upstreamSymbols()
	{	
		// A Variable usually has exactly one StringExpression child whose code string contains
		// the variable's name.
		if( ((ASTNodeASTProvider)astProvider.getChild(0)).getASTNode() instanceof StringExpression) {
			String code = astProvider.getChild(0).getEscapedCodeStr();
			symbols.add(code);
		}
		else {
			// otherwise, it's an expression evaluating to a variable name; not much we can
			// do statically :(
		}
		return symbols;
	}
	
	// a Variable has only one StringExpression child, and it should not be traversed
	@Override
	public boolean shouldTraverse(ASTProvider child)
	{
		// if we have a StringExpression child (see comments in upstreamSymbols()),
		// stop recursion
		if( ((ASTNodeASTProvider)astProvider.getChild(0)).getASTNode() instanceof StringExpression) {
			return false;
		}
		return true;
	}
	
	public Collection<UseOrDef> useOrDefsFromSymbols(ASTProvider child)
	{
		if( this.emitUse) {
			LinkedList<UseOrDef> retval = createUsesForAllSymbols(upstreamSymbols());
			return retval;
		}
		else
			return super.useOrDefsFromSymbols(child);
	}
	
	public void setEmitUse( boolean emitUse) {
		this.emitUse = emitUse;
	}
}
