package main.codeitems.expressions;



import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CoarseFunctionGrammarParser;
import antlr.FineFunctionGrammarParser;

public class FieldOnlyWrapper
{
	CoarseFunctionGrammarParser.FieldOnlyContext ctxCoarse;
	FineFunctionGrammarParser.FieldOnlyContext ctxFine;
	int contextInUse;
	
	public FieldOnlyWrapper(ParserRuleContext objToWrap)
	{
	
		if(objToWrap instanceof CoarseFunctionGrammarParser.FieldOnlyContext){
			ctxCoarse = (CoarseFunctionGrammarParser.FieldOnlyContext) objToWrap;
			contextInUse = 0;
		}else if(objToWrap instanceof FineFunctionGrammarParser.Init_declaratorContext){
			ctxFine = (FineFunctionGrammarParser.FieldOnlyContext) objToWrap;
			contextInUse = 1;
		}
	}

	
	public String getIncDecString()
	{
		switch(contextInUse){
			case 0: return ctxCoarse.inc_dec().getText();
			case 1: return ctxFine.inc_dec().getText();
		}
		return null;
	}
	
	public String getUnaryOperatorString()
	{	
		switch(contextInUse){
		case 0: return ctxCoarse.unary_operators().getText();
		case 1: return ctxFine.unary_operators().getText();
	}
		return null;
	}
	
	public String getFieldString()
	{	
		switch(contextInUse){
		case 0: return ctxCoarse.field().getText();
		case 1: return ctxFine.field().getText();
	}
		return null;
	}
	
}
