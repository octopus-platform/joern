package astnodes;

import org.antlr.v4.runtime.ParserRuleContext;

abstract public class ASTNodeBuilder
{
	protected ASTNode item;

	public ASTNode getItem()
	{
		complete();
		return item;
	}

	public void complete()
	{
	}

	abstract public void createNew(ParserRuleContext ctx);

}
