package ast.statements;

import ast.ASTNode;

public class BlockStarter extends Statement
{
	Statement statement = null;
	Condition condition = null;

	public Statement getStatement()
	{
		return statement;
	}

	public Condition getCondition()
	{
		return condition;
	}

	protected void setStatement(Statement aStatement)
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
		if (node instanceof Condition)
			setCondition((Condition) node);
		else if (node instanceof Statement)
			setStatement((Statement) node);
		super.addChild(node);
	}

}
