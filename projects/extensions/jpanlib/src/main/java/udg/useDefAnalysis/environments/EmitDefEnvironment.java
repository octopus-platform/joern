package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefGraph.UseOrDef;

// emit all symbols as DEF and don't hand
// anything upstream.

public class EmitDefEnvironment extends UseDefEnvironment
{

	protected Collection<String> defSymbols = new LinkedList<String>();

	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		defSymbols.addAll(childSymbols);
	}

	public LinkedList<String> upstreamSymbols()
	{
		// empty, unless a child-class adds something
		return symbols;
	}
	
	public Collection<UseOrDef> useOrDefsFromSymbols(ASTProvider child)
	{
		LinkedList<UseOrDef> retval = createDefsForAllSymbols(defSymbols);
		return retval;
	}
}
