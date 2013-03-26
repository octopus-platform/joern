package tools.index;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.CoarseFunctionGrammarParser;
import antlr.CodeSensorParser;
import antlr.FineFunctionGrammarParser;

public class InitDeclContextWrapper
{
	CodeSensorParser.Init_declaratorContext ctxCodeSensor = null;
	CoarseFunctionGrammarParser.Init_declaratorContext ctxCoarse = null;
	FineFunctionGrammarParser.Init_declaratorContext ctxFine = null;
	int contextInUse;
	
	public InitDeclContextWrapper(CodeSensorParser.Init_declaratorContext ctx)
	{
		ctxCodeSensor = ctx;
		contextInUse = 0;
	}

	public InitDeclContextWrapper(CoarseFunctionGrammarParser.Init_declaratorContext ctx)
	{
		ctxCoarse = ctx;
		contextInUse = 1;
	}

	public InitDeclContextWrapper(FineFunctionGrammarParser.Init_declaratorContext ctx)
	{
		ctxFine = ctx;
		contextInUse = 2;
	}

	public InitDeclContextWrapper(ParseTree objToWrap)
	{
		if(objToWrap instanceof CodeSensorParser.Init_declaratorContext){
			ctxCodeSensor = (CodeSensorParser.Init_declaratorContext) objToWrap;
			contextInUse = 0;
		}else if(objToWrap instanceof CoarseFunctionGrammarParser.Init_declaratorContext){
			ctxCoarse = (CoarseFunctionGrammarParser.Init_declaratorContext) objToWrap;
			contextInUse = 1;
		}else if(objToWrap instanceof FineFunctionGrammarParser.Init_declaratorContext){
			ctxFine = (FineFunctionGrammarParser.Init_declaratorContext) objToWrap;
			contextInUse = 2;
		}
	}

	public ParserRuleContext getWrappedObject()
	{
		switch(contextInUse){
		case 0: return ctxCodeSensor;
		case 1: return ctxCoarse;
		case 2: return ctxFine;
	}
	return null;
	}
	
	public ParserRuleContext ptrs()
	{
		switch(contextInUse){
			case 0: return ctxCodeSensor.ptrs();
			case 1: return ctxCoarse.ptrs();
			case 2: return ctxFine.ptrs();
		}
		return null;
	}
	
	public ParserRuleContext type_suffix()
	{
		switch(contextInUse){
			case 0: return ctxCodeSensor.type_suffix();
			case 1: return ctxCoarse.type_suffix();
			case 2: return ctxFine.type_suffix();
		}
		return null;
	}

	public ParserRuleContext identifier()
	{
		switch(contextInUse){
		case 0: return ctxCodeSensor.identifier();
		case 1: return ctxCoarse.identifier();
		case 2: return ctxFine.identifier();
		}
	return null;
	}
	
}
