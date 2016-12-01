package udg.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.CUseDefExpression;
import udg.useDefAnalysis.environments.EmitUseEnvironment;

public class UnaryOpEnvironment extends EmitUseEnvironment
{

	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{

		String codeStr = astProvider.getEscapedCodeStr();

		if (codeStr != null && codeStr.startsWith("&"))
		{
			for (String symbol : childSymbols)
			{
				symbols.add(CUseDefExpression.simplify("& " + symbol));
			}

			return;
		}

		if (codeStr == null || !codeStr.startsWith("*"))
		{
			symbols.addAll(childSymbols);
			return;
		}

		LinkedList<String> retval = new LinkedList<String>();

		// emit all symbols as '* symbol'

		LinkedList<String> derefedChildren = new LinkedList<String>();
		for (String c : childSymbols)
		{
			derefedChildren.add(CUseDefExpression.simplify("* " + c));
		}

		retval.addAll(derefedChildren);

		// emit entire code string
		retval.add(codeStr);

		useSymbols.addAll(childSymbols);
		symbols.addAll(retval);

	}
}
