package ast;

import org.antlr.v4.runtime.ParserRuleContext;

abstract public class ASTNodeBuilder
{
	protected ASTNode item;
	public ASTNode getItem() { return item; }

	abstract public void createNew(ParserRuleContext ctx);

}
