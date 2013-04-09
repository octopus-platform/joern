package main.codeitems.expressions;

import org.antlr.v4.runtime.ParserRuleContext;

public class Identifier extends Expression {

	public ParserRuleContext getParseTreeNodeContext()
	{
		return parseTreeNodeContext;
	}
}
