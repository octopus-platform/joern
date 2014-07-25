package astnodes.expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import astwalking.ASTNodeVisitor;

public class Identifier extends Expression
{

	public ParserRuleContext getParseTreeNodeContext()
	{
		return parseTreeNodeContext;
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
