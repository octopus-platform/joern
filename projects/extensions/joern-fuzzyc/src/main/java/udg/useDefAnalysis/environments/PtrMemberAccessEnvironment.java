package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.CUseDefExpression;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefGraph.UseOrDef;

public class PtrMemberAccessEnvironment extends UseDefEnvironment
{

	public LinkedList<String> upstreamSymbols()
	{

		LinkedList<String> retval = new LinkedList<String>();

		// emit all symbols as '* symbol'

		LinkedList<String> derefedChildren = new LinkedList<String>();
		for (String c : symbols)
		{
			derefedChildren.add(CUseDefExpression.simplify("* " + c));
		}

		retval.addAll(derefedChildren);

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
