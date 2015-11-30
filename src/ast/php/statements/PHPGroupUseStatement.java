package ast.php.statements;

import ast.ASTNode;
import ast.logical.statements.Statement;
import ast.statements.UseStatement;

public class PHPGroupUseStatement extends Statement
{
	private ASTNode prefix = null;
	private UseStatement uses = null;
	
	public ASTNode getPrefix()
	{
		return this.prefix;
	}

	public void setPrefix(ASTNode prefix)
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
