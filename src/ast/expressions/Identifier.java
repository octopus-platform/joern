package ast.expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.walking.ASTNodeVisitor;

public class Identifier extends Expression
{

	public Identifier()
	{
	}

	public Identifier(Identifier name)
	{
		super(name);
	}

	public ParserRuleContext getParseTreeNodeContext()
	{
		return parseTreeNodeContext;
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

}
