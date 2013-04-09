package main.codeitems.builders;

import java.util.Stack;

import main.codeitems.CodeItemBuilder;
import main.codeitems.expressions.Identifier;
import main.codeitems.functionDef.FunctionDef;
import main.codeitems.functionDef.ParameterList;
import main.codeitems.functionDef.ReturnType;
import main.codeitems.statements.CompoundItem;

import org.antlr.v4.runtime.ParserRuleContext;

import tools.index.ParseTreeUtils;
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
		thisItem.name = new Identifier();
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

	public void setContent(CompoundItem functionContent)
	{
		thisItem.setContent(functionContent);
	}
	
}
