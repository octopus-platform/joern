package udg.useDefAnalysis.environments;

import java.util.Collection;




public class ArrayIndexingEnvironment extends EmitUseEnvironment {

	public void addChildSymbols(Collection<String> childSymbols)
	{
		if(childNum != 0)
			useSymbols.addAll(childSymbols);
		else	
			symbolsForUpstream.addAll(childSymbols);
	}
	
}
