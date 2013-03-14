package main.codeitems.declarations;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.IdentifierContext;
import antlr.CodeSensorParser.Init_declaratorContext;

import main.ParseTreeUtils;
import main.codeitems.CodeItemBuilder;
import main.codeitems.Name;

public class IdentifierDeclBuilder extends CodeItemBuilder
{
	IdentifierDecl thisItem;
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new IdentifierDecl();
		thisItem = (IdentifierDecl) item;
		item.initializeFromContext(ctx);
	}

	public void setType(Init_declaratorContext decl_ctx,
						ParserRuleContext typeName)
	{
		String baseType = "";
		if(typeName != null)
			baseType = ParseTreeUtils.childTokenString(typeName);
		String completeType = baseType;
		if(decl_ctx.ptrs() != null)
			completeType += ParseTreeUtils.childTokenString(decl_ctx.ptrs());
		if(decl_ctx.type_suffix() != null)
			completeType += ParseTreeUtils.childTokenString(decl_ctx.type_suffix());
		
		thisItem.type = new IdentifierDeclType();
		thisItem.type.baseType = baseType;
		thisItem.type.completeType = completeType;
	}

	public void setName(Init_declaratorContext decl_ctx)
	{
		IdentifierContext identifier = decl_ctx.identifier();
		thisItem.name = new Name();
		thisItem.name.initializeFromContext(identifier);
	}
	
}
