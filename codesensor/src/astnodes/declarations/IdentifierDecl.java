package astnodes.declarations;

import antlr.FineFunctionGrammarParser.IdentifierContext;
import astnodes.ASTNode;
import astnodes.expressions.Identifier;


public class IdentifierDecl extends ASTNode
{
	public IdentifierDeclType type;
	public Identifier name;
	
	public void addChild(ASTNode expression)
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
