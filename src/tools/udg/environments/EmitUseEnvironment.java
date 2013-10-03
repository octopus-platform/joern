package tools.udg.environments;

import java.util.Collection;
import java.util.LinkedList;

import tools.udg.UseOrDef;

// emit all symbols as USE and don't hand
// anything to up stream.

public class EmitUseEnvironment extends UseDefEnvironment {

	Collection<String> useSymbols = new LinkedList<String>();
	
	public void addChildSymbols(Collection<String> childSymbols)
	{
		useSymbols.addAll(childSymbols);
	}
	
	public Collection<String> upstreamSymbols()
	{
		// empty, unless a child-class adds something
		return symbolsForUpstream;
	}

	public Collection<UseOrDef> useOrDefsFromChildSymbols()
	{
		LinkedList<UseOrDef> retval = createUsesForAllSymbols(useSymbols);	
		return retval;
	}
}
