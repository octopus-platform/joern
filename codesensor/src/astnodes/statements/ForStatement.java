package astnodes.statements;

import astnodes.ASTNode;
import astnodes.DummyNode;

public class ForStatement extends BlockStarter
{
	private ASTNode forInitStatement = new DummyNode();
	private ASTNode expression = new DummyNode();
	
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
		if(forInitStatement instanceof DummyNode)
			forInitStatement = item;
		else if(expression instanceof DummyNode && condition != null)
			expression = item;
		super.addChild(item);
	}

}
