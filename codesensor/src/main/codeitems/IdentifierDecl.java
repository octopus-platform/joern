package main.codeitems;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

public class IdentifierDecl extends NamedCodeItem
{
	public IdentifierDeclType type;
	
	public void create(ParserRuleContext ctx, Stack<CodeItem> itemStack)
	{
		nodeTypeName = "DECL";
		super.create(ctx, itemStack);
	}
	
	public void setType(String baseType, String completeType)
	{
		type = new IdentifierDeclType();
		type.baseType = baseType;
		type.completeType = completeType;
	}
	
}
