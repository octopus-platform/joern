package ast.logical.statements;

import ast.ASTNode;

public class BlockStarter extends Statement
{
	protected ASTNode condition = null; // TODO change type back to Expression (or Condition)
	protected Statement statement = null;

	public ASTNode getCondition()
	{
		return this.condition;
	}

	public void setCondition(ASTNode expression)
	{
		this.condition = expression;
		super.addChild(expression);
	}
	
	public Statement getStatement()
	{
		return this.statement;
	}
	
	public void setStatement(Statement statement)
	{
		this.statement = statement;
		super.addChild(statement);
	}

	@Override
	public void addChild(ASTNode node)
	{
		if (node instanceof Condition)
			setCondition((Condition) node);
		else if (node instanceof Statement)
			setStatement((Statement) node);
		else
			super.addChild(node);
	}

}
