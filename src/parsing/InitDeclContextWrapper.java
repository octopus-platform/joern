package parsing;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ModuleParser;
import antlr.FineFunctionGrammarParser;

public class InitDeclContextWrapper
{
	ModuleParser.DeclaratorContext ctxCodeSensor = null;
	FineFunctionGrammarParser.DeclaratorContext ctxFine = null;
	int contextInUse;
	
	public InitDeclContextWrapper(ModuleParser.DeclaratorContext ctx)
	{
		ctxCodeSensor = ctx;
		contextInUse = 0;
	}

	public InitDeclContextWrapper(FineFunctionGrammarParser.DeclaratorContext ctx)
	{
		ctxFine = ctx;
		contextInUse = 2;
	}

	public InitDeclContextWrapper(ParseTree objToWrap)
	{
		if(objToWrap instanceof ModuleParser.Init_declaratorContext){
			ctxCodeSensor = (ModuleParser.DeclaratorContext) objToWrap.getChild(0);
			contextInUse = 0;
		}else if(objToWrap instanceof FineFunctionGrammarParser.Init_declaratorContext){
			ctxFine = (FineFunctionGrammarParser.DeclaratorContext) objToWrap.getChild(0);
			contextInUse = 2;
		}
	}

	public ParserRuleContext getWrappedObject()
	{
		switch(contextInUse){
		case 0: return ctxCodeSensor;
		case 2: return ctxFine;
	}
	return null;
	}
	
	public ParserRuleContext ptrs()
	{
		switch(contextInUse){
			case 0: return ctxCodeSensor.ptrs();
			case 2: return ctxFine.ptrs();
		}
		return null;
	}
	
	public ParserRuleContext type_suffix()
	{
		switch(contextInUse){
			case 0: return ctxCodeSensor.type_suffix();
			case 2: return ctxFine.type_suffix();
		}
		return null;
	}

	public ParserRuleContext identifier()
	{
		switch(contextInUse){
		case 0: return ctxCodeSensor.identifier();
		case 2: return ctxFine.identifier();
		}
	return null;
	}
	
}
