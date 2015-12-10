package ast.statements.blockstarters;

import ast.expressions.StringExpression;
import ast.logical.statements.BlockStarter;
import ast.logical.statements.CompoundStatement;

public class NamespaceStatement extends BlockStarter
{
	private StringExpression name = null;
	private CompoundStatement content = null;

	public StringExpression getName()
	{
		return this.name;
	}
	
	public void setName(StringExpression name)
	{
		this.name = name;
		super.addChild(name);
	}
	
	public CompoundStatement getContent()
	{
		return this.content;
	}
	
	public void setContent(CompoundStatement content)
	{
		this.content = content;
		super.addChild(content);
	}
}
