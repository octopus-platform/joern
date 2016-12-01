package udg.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.CUseDefExpression;
import udg.useDefAnalysis.environments.EmitDefAndUseEnvironment;

public class ArgumentEnvironment extends EmitDefAndUseEnvironment
{

	boolean isTainted = false;

	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		if (isDef(child))
		{
			LinkedList<String> derefChildSymbols = new LinkedList<String>();
			for (String symbol : childSymbols)
			{
				derefChildSymbols.add(CUseDefExpression.simplify("* " + symbol));
				if (!symbol.startsWith("& "))
				{
					// !patch to see if we can detect macro-sources!
					derefChildSymbols.add(symbol);
				}
			}

			defSymbols.addAll(derefChildSymbols);
		}
		if (isUse(child))
			useSymbols.addAll(childSymbols);
	}

	public boolean isUse(ASTProvider child)
	{
		return true;
	}

	public boolean isDef(ASTProvider child)
	{
		return isTainted;
	}

	public void setIsTainted()
	{
		isTainted = true;
	}

}
