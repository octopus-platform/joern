package ast.statements.blockstarters;

import ast.logical.statements.BlockStarter;
import ast.logical.statements.CompoundStatement;
import ast.walking.ASTNodeVisitor;

public class TryStatement extends BlockStarter
{
	private CompoundStatement content = null;
	private CatchList catchList = new CatchList();
	private CompoundStatement finallyContent = null;
	
	public CompoundStatement getContent()
	{
		return this.content;
	}
	
	public void setContent(CompoundStatement content)
	{
		this.content = content;
		super.addChild(content);
	}
	
	public CatchList getCatchList()
	{
		return this.catchList;
	}
	
	public void setCatchList(CatchList catchList)
	{
		this.catchList = catchList;
		super.addChild(catchList);
	}
	
	public CompoundStatement getFinallyContent()
	{
		return this.finallyContent;
	}
	
	public void setFinallyContent(CompoundStatement finallyContent)
	{
		this.finallyContent = finallyContent;
		super.addChild(finallyContent);
	}
	
	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
