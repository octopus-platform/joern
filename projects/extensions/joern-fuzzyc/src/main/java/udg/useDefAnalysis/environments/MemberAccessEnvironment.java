package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefGraph.UseOrDef;

public class MemberAccessEnvironment extends UseDefEnvironment
{

	public LinkedList<String> upstreamSymbols()
	{

		LinkedList<String> retval = new LinkedList<String>();

		// emit all symbols
		retval.addAll(symbols);

		// emit entire code string
		String codeStr = astProvider.getEscapedCodeStr();
		retval.add(codeStr);

		return retval;
	}

	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		int childNum = child.getChildNumber();
		// Only add the left child but never the right child
		if (childNum == 0)
			super.addChildSymbols(childSymbols, child);
	}

	public Collection<UseOrDef> useOrDefsFromSymbols(ASTProvider child)
	{
		return createUsesForAllSymbols(symbols);
	}

}
