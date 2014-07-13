package astnodes.builders.function;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import parsing.ParseTreeUtils;
import antlr.ModuleParser.Function_nameContext;
import antlr.ModuleParser.Function_param_listContext;
import antlr.ModuleParser.Parameter_declContext;
import antlr.ModuleParser.Return_typeContext;
import astnodes.ASTNodeBuilder;
import astnodes.expressions.Identifier;
import astnodes.functionDef.FunctionDef;
import astnodes.functionDef.ParameterList;
import astnodes.functionDef.ReturnType;
import astnodes.statements.CompoundStatement;

public class FunctionDefBuilder extends ASTNodeBuilder
{

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
			Stack<ASTNodeBuilder> itemStack)
	{
		thisItem.name = new Identifier();
		thisItem.name.initializeFromContext(ctx);
	}

	public void setReturnType(Return_typeContext ctx,
			Stack<ASTNodeBuilder> itemStack)
	{
		ReturnType returnType = new ReturnType();

		returnType.initializeFromContext(ctx);
		returnType
				.setBaseType(ParseTreeUtils.childTokenString(ctx.type_name()));
		returnType.setCompleteType(ParseTreeUtils.childTokenString(ctx));
		thisItem.setReturnType(returnType);
	}

	public void setParameterList(Function_param_listContext ctx,
			Stack<ASTNodeBuilder> itemStack)
	{
		paramListBuilder.createNew(ctx);
		thisItem.setParameterList((ParameterList) paramListBuilder.getItem());
	}

	public void addParameter(Parameter_declContext ctx,
			Stack<ASTNodeBuilder> itemStack)
	{
		paramListBuilder.addParameter(ctx, itemStack);
	}

	public void setContent(CompoundStatement functionContent)
	{
		thisItem.setContent(functionContent);
	}

}
