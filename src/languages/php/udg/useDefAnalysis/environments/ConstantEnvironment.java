package languages.php.udg.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;

public class ConstantEnvironment extends UseDefEnvironment
{

	// pass the 'code' of the constant upstream (i.e., the constant's name)
	@Override
	public LinkedList<String> upstreamSymbols()
	{	
		// A Constant has exactly one Identifier child whose StringExpression child contains
		// the constant's name.
		String code = astProvider.getChild(0).getChild(0).getEscapedCodeStr();
		symbols.add(code);
		
		return symbols;
	}
	
	// a Constant has only one Identifier child which needs not be traversed
	@Override
	public boolean shouldTraverse(ASTProvider child)
	{
		return false;
	}
}
