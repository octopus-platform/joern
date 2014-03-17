package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.useDefGraph.UseOrDef;

public class MemberAccessEnvironment extends UseDefEnvironment {

	boolean emitted = false;
	
	public LinkedList<String> upstreamSymbols()
	{
		if(emitted) return emptySymbolList;
		
		// emit the entire symbol
		emitted = true;
		LinkedList<String> retval = new LinkedList<String>();
		
		// emit the left-most symbol
		retval.addAll(symbolsForUpstream);	
		
		String codeStr = astProvider.getEscapedCodeStr();
		
		retval.add(codeStr);		
				
		return retval; 
	}

	public void addChildSymbols(LinkedList<String> childSymbols)
	{
		if(childNum != 0) return;

		super.addChildSymbols(childSymbols);
	}
	
	public Collection<UseOrDef> useOrDefsFromChildSymbols()
	{	
		if(childNum != 0)
			return emptyUseOrDef;
		
		return createUsesForAllSymbols(symbolsForUpstream);
	}
		
}
