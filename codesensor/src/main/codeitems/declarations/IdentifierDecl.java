package main.codeitems.declarations;

import antlr.FineFunctionGrammarParser.IdentifierContext;
import main.codeitems.CodeItem;
import main.codeitems.Identifier;


public class IdentifierDecl extends CodeItem
{
	public IdentifierDeclType type;
	public Identifier name;
	
	public void addChild(CodeItem expression)
	{ 
		// TODO: implement handling of type_suffix and initializer here
		super.addChild(expression);
	}
	
	public IdentifierDecl()
	{
		setNodeTypeName("var");
	}

	public void setName(IdentifierContext ctx)
	{
		name = new Identifier();
		name.initializeFromContext(ctx);
	}
	
	
}
