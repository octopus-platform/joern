package main.codeitems.function;

import java.util.Stack;

import main.ParseTreeUtils;
import main.FunctionParser.FunctionParser;
import main.codeitems.CodeItemBuilder;
import main.codeitems.Name;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import antlr.CodeSensorParser;
import antlr.CodeSensorParser.Compound_statementContext;
import antlr.CodeSensorParser.Function_nameContext;
import antlr.CodeSensorParser.Function_param_listContext;
import antlr.CodeSensorParser.Parameter_declContext;
import antlr.CodeSensorParser.Return_typeContext;

public class FunctionDefBuilder extends CodeItemBuilder {

	FunctionDef thisItem;
	ParameterListBuilder paramListBuilder = new ParameterListBuilder();
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new FunctionDef();
		item.initializeFromContext(ctx);
		thisItem = (FunctionDef) item;
	}

	public void setName(Function_nameContext ctx,
			Stack<CodeItemBuilder> itemStack)
	{
		thisItem.name = new Name();
		thisItem.name.initializeFromContext(ctx);
	}
	
	public void setReturnType(Return_typeContext ctx,
			Stack<CodeItemBuilder> itemStack)
	{
		thisItem.returnType = new ReturnType();
		ReturnType returnType = thisItem.returnType;
		
		returnType.initializeFromContext(ctx);
		returnType.setBaseType(ParseTreeUtils.childTokenString(ctx.type_name()));
		returnType.setCompleteType(ParseTreeUtils.childTokenString(ctx));
	}

	public void setParameterList(Function_param_listContext ctx,
								 Stack<CodeItemBuilder> itemStack)
	{
		paramListBuilder.createNew(ctx);
		thisItem.parameterList = (ParameterList) paramListBuilder.getItem();
	}

	public void addParameter(Parameter_declContext ctx,
							 Stack<CodeItemBuilder> itemStack)
	{
		paramListBuilder.addParameter(ctx, itemStack);
	}
	
	public void parseFunctionContents(CodeSensorParser.Function_defContext ctx)
	{
		String text = getCompoundStmtAsString(ctx);
		FunctionParser functionParser = new FunctionParser();
		functionParser.parseAndWalk(text);	
	}

	private String getCompoundStmtAsString(
			CodeSensorParser.Function_defContext ctx)
	{
		Compound_statementContext compound_statement = ctx.compound_statement();
		
		CharStream inputStream = compound_statement.start.getInputStream();
		int startIndex = compound_statement.start.getStopIndex();
		int stopIndex = compound_statement.stop.getStopIndex();
		return inputStream.getText(new Interval(startIndex+1, stopIndex-1));
	}
	
}
