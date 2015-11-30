package ast.statements.blockstarters;

import ast.ASTNode;
import ast.logical.statements.BlockStarter;
import ast.logical.statements.CompoundStatement;

public class NamespaceStatement extends BlockStarter
{
	private ASTNode name = null;
	private CompoundStatement content = null;

	public ASTNode getName()
	{
		return this.name;
	}
	
	public void setName(ASTNode name)
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
