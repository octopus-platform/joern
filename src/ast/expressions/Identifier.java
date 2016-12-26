package ast.expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.walking.ASTNodeVisitor;

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
