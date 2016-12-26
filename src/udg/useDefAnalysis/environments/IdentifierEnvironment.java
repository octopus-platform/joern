package udg.useDefAnalysis.environments;

import java.util.LinkedList;

public class IdentifierEnvironment extends UseDefEnvironment
{

	// pass the 'code' of the identifier up-stream

	public LinkedList<String> upstreamSymbols()
	{
		String code = astProvider.getEscapedCodeStr();
		LinkedList<String> retval = new LinkedList<String>();
		retval.add(code);
		return retval;
	}
}
