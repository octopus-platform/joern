package languages.php.udg.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;

public class ParameterEnvironment extends UseDefEnvironment
{

	// pass the 'code' of the parameter's second child upstream (i.e., the parameter's name)
	@Override
	public LinkedList<String> upstreamSymbols()
	{	
		// A PHPParameter has three children, and the second one is a StringExpression child
		// whose code string contains the parameter's name.
		String code = astProvider.getChild(1).getEscapedCodeStr();
		symbols.add(code);
		return symbols;
	}
	
	// we add the parameter's name to the upstream symbols in upstreamSymbols(),
	// no need to traverse any further
	@Override
	public boolean shouldTraverse(ASTProvider child)
	{
		return false;
	}
}
