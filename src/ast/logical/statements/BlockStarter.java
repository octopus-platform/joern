package ast.logical.statements;

import ast.ASTNode;
import ast.expressions.Expression;

public class BlockStarter extends Statement
{
	protected Expression condition = null;
	protected Statement statement = null;

	public Expression getCondition()
	{
		return this.condition;
	}

	public void setCondition(Expression expression)
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
