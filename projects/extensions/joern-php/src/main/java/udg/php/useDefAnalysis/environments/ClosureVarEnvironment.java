package udg.php.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;

public class ClosureVarEnvironment extends UseDefEnvironment
{

	// pass the 'code' of the closure variable upstream (i.e., the closure variable's name)
	@Override
	public LinkedList<String> upstreamSymbols()
	{	
		// A ClosureVar has exactly one StringExpression child whose code string contains
		// the variable's name.
		String code = astProvider.getChild(0).getEscapedCodeStr();
		symbols.add(code);
		return symbols;
	}
	
	// a ClosureVar has only one StringExpression child, and it should not be traversed
	@Override
	public boolean shouldTraverse(ASTProvider child)
	{
		return false;
	}
}
