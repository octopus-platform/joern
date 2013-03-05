package main.codeitems;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Init_declaratorContext;
import antlr.CodeSensorParser.Type_nameContext;

public class IdentifierDecl extends NamedCodeItem
{
	public IdentifierDeclType type;
	
	public void create(ParserRuleContext ctx, Stack<CodeItem> itemStack)
	{
		nodeTypeName = "DECL";
		super.create(ctx, itemStack);
	}
	
	public void setType(Init_declaratorContext decl_ctx, ParserRuleContext typeName)
	{
		String baseType = "";
		if(typeName != null)
			baseType = childTokenString(typeName);
		String completeType = baseType;
		if(decl_ctx.ptrs() != null)
			completeType += childTokenString(decl_ctx.ptrs());
		if(decl_ctx.type_suffix() != null)
			completeType += childTokenString(decl_ctx.type_suffix());
		
		type = new IdentifierDeclType();
		type.baseType = baseType;
		type.completeType = completeType;
	}
	
}
