package astnodes.statements;

import astnodes.ASTNode;
import astnodes.DummyItem;

public class ForItem extends BlockStarterItem
{
	private ASTNode forInitStatement = new DummyItem();
	private ASTNode expression = new DummyItem();
	
	public ASTNode getForInitStatement()
	{
		return forInitStatement;
	}

	public void setForInitStatement(ASTNode forInitStatement)
	{
		this.forInitStatement = forInitStatement;
	}

	public ASTNode getExpression()
	{
		return expression;
	}

	public void setExpression(ASTNode expression)
	{
		this.expression = expression;
	}
	
	@Override
	public void addChild(ASTNode item)
	{	
		if(forInitStatement instanceof DummyItem)
			forInitStatement = item;
		else if(expression instanceof DummyItem)
			expression = item;
		super.addChild(item);
	}

}
