package udg.useDefAnalysis.environments;

import java.util.LinkedList;




public class ArrayIndexingEnvironment extends EmitUseEnvironment {

	public void addChildSymbols(LinkedList<String> childSymbols)
	{
		if(childNum != 0)
			useSymbols.addAll(childSymbols);
		else	
			symbolsForUpstream.addAll(childSymbols);
	}
	
}
