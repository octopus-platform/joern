package tools.udg.environments;

import java.util.Collection;
import java.util.LinkedList;

import tools.udg.UseOrDef;

public class EmitDefEnvironment extends UseDefEnvironment {

	Collection<String> defSymbols = new LinkedList<String>();
	
	public void addChildSymbols(Collection<String> childSymbols)
	{
		if(isDef())
			defSymbols.addAll(childSymbols);
		if(isUse())
			symbolsForUpstream.addAll(childSymbols);
	}
	
	public Collection<UseOrDef> useOrDefsFromChildSymbols()
	{
		
		if(!isDef())
			return emptyUseOrDef;
	
		LinkedList<UseOrDef> retval = createDefsForAllSymbols(defSymbols);	
		return retval;
	}
	
}
