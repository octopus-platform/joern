package udg.useDefAnalysis.environments;

import java.util.LinkedList;


public class IdentifierEnvironment extends UseDefEnvironment {

	public LinkedList<String> upstreamSymbols()
	{
		// pass the 'code' of the identifier up stream
		String code = astProvider.getEscapedCodeStr();
		LinkedList<String> retval = new LinkedList<String>();
		retval.add(code);
		return retval;
	}
}
