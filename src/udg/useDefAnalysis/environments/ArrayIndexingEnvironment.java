package udg.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;

public class ArrayIndexingEnvironment extends EmitUseEnvironment
{

	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		int childNum = child.getChildNumber();

		if (childNum == 0)
			symbols.addAll(childSymbols);
		else
			useSymbols.addAll(childSymbols);
	}

}
