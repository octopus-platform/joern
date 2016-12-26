package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefGraph.UseOrDef;

// emit all symbols as USE and don't hand
// anything to up stream.

public class EmitUseEnvironment extends UseDefEnvironment
{

	Collection<String> useSymbols = new LinkedList<String>();

	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		useSymbols.addAll(childSymbols);
	}

	public LinkedList<String> upstreamSymbols()
	{
		// empty, unless a child-class adds something
		return symbols;
	}

	public Collection<UseOrDef> useOrDefsFromSymbols(ASTProvider child)
	{
		LinkedList<UseOrDef> retval = createUsesForAllSymbols(useSymbols);
		return retval;
	}
}
