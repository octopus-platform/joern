package astnodes.statements;

import astnodes.ASTNode;
import astnodes.expressions.Expression;


public class BlockStarter extends Statement
{
	Statement statement = null;
	Condition condition = null;
	
	public BlockStarter()
	{
		super();
		condition = new Condition();
		condition.addChild(new Expression());
	}
	
	public Statement getStatement()
	{
		return statement;
	}
	
	public Condition getCondition()
	{
		return condition;
	}
	
	private void setStatement(Statement aStatement)
	{
		statement = aStatement;
	}

	public void setCondition(Condition expression)
	{
		condition = expression;
	}

	@Override
	public void addChild(ASTNode node)
	{
		if(node instanceof Condition)
			setCondition((Condition) node);
		if(node instanceof Statement)
			setStatement((Statement)node);
		super.addChild(node);			
	}
	
	@Override
	public int getChildCount()
	{
		if(condition == null || statement == null)
			throw new RuntimeException("Invalid Blockstarter");
		
		return 2;
	}
	
	@Override
	public ASTNode getChild(int i)
	{
		if(i == 0) return condition;
		if(i == 1) return statement;
		throw new RuntimeException("Invalid Blockstarter");
	}
	
}
