package languages.php.udg.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;

public class VariableEnvironment extends UseDefEnvironment
{

	// pass the 'code' of the variable upstream (i.e., the variable's name)
	@Override
	public LinkedList<String> upstreamSymbols()
	{
		// A Variable has exactly one child whose code string contains the variable's name.
		String code = astProvider.getChild(0).getEscapedCodeStr();
		LinkedList<String> retval = new LinkedList<String>();
		retval.add(code);
		return retval;
	}
	
	// a Variable has only one StringExpression child, and it should not be traversed
	@Override
	public boolean shouldTraverse(ASTProvider child)
	{
		return false;
	}
}
