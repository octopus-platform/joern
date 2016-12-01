package udg.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.CUseDefExpression;
import udg.useDefAnalysis.environments.EmitUseEnvironment;

public class ArrayIndexingEnvironment extends EmitUseEnvironment
{

	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{

		LinkedList<String> derefedChildren = new LinkedList<String>();
		for (String c : childSymbols)
		{
			derefedChildren.add(CUseDefExpression.simplify("* " + c));
		}

		symbols.addAll(derefedChildren);

		useSymbols.addAll(childSymbols);
	}

}
