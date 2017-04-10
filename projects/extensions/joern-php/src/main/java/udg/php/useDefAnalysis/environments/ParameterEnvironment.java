package udg.php.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.EmitDefEnvironment;

public class ParameterEnvironment extends EmitDefEnvironment
{
	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		// the second child of a parameter contains the symbol
		int childNum = child.getChildNumber();
		if( 1 == childNum)
			this.defSymbols.add(child.getEscapedCodeStr());
	}

	// TODO: might be nice to emit USEs for the third child, which is the default value
	// of the parameter
}
