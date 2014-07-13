package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefGraph.UseOrDef;

public class EmitDefAndUseEnvironment extends UseDefEnvironment
{

	Collection<String> defSymbols = new LinkedList<String>();
	Collection<String> useSymbols = new LinkedList<String>();

	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		if (isDef(child))
			defSymbols.addAll(childSymbols);
		if (isUse(child))
			useSymbols.addAll(childSymbols);
	}

	public Collection<UseOrDef> useOrDefsFromSymbols(ASTProvider child)
	{
		LinkedList<UseOrDef> retval = new LinkedList<UseOrDef>();

		if (isDef(child))
			retval.addAll(createDefsForAllSymbols(defSymbols));

		if (isUse(child))
			retval.addAll(createUsesForAllSymbols(useSymbols));

		return retval;
	}

	public LinkedList<String> upstreamSymbols()
	{
		return emptySymbolList;
	}

}
