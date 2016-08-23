package ast.php.statements;

import ast.expressions.StringExpression;
import ast.logical.statements.Statement;
import ast.statements.UseStatement;

public class GroupUseStatement extends Statement
{
	private StringExpression prefix = null;
	private UseStatement uses = null;
	
	public StringExpression getPrefix()
	{
		return this.prefix;
	}

	public void setPrefix(StringExpression prefix)
	{
		this.prefix = prefix;
		super.addChild(prefix);
	}
	
	public UseStatement getUses()
	{
		return this.uses;
	}

	public void setUses(UseStatement uses)
	{
		this.uses = uses;
		super.addChild(uses);
	}
}
