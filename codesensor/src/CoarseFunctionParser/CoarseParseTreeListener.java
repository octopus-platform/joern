package CoarseFunctionParser;

import main.CommonParser;
import antlr.SymbolsBaseListener;


public class CoarseParseTreeListener extends SymbolsBaseListener
{
	CommonParser p;
	
	public CoarseParseTreeListener(CoarseFunctionParser aP)
	{
		p = aP;
	}
	
}
