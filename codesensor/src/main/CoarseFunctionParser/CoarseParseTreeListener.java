package main.CoarseFunctionParser;

import main.CommonParser;
import antlr.CoarseFunctionGrammarBaseListener;


public class CoarseParseTreeListener extends CoarseFunctionGrammarBaseListener
{
	CommonParser p;
	
	public CoarseParseTreeListener(CoarseFunctionParser aP)
	{
		p = aP;
	}

	
	
}
