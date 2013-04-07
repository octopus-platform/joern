package main.codeitems.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;

public class IdentifierDeclStatement extends Statement
{
	
	ParserRuleContext typeNameContext;
	
	public List<CodeItem> getIdentifierDeclList()
	{
		return children;
	}
	
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }

	public ParserRuleContext getTypeNameContext()
	{
		return typeNameContext;
	}
	
	public void setTypeNameContext(ParserRuleContext ctx)
	{
		typeNameContext = ctx;
	}

}
