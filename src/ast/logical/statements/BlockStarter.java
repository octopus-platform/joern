package ast.logical.statements;

import ast.ASTNode;
import ast.expressions.Expression;
import ast.statements.ExpressionStatement;

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
	
	// Expressions can be used as statements. For instance, in the code 'if(true) foo();',
	// - foo() is an expression
	// - foo(); is an expression statement
	// In this case, we need to create an ExpressionStatement that holds the given Expression.
	public void setStatement(Expression expression)
	{
		ExpressionStatement expressionStatement = new ExpressionStatement();
		expressionStatement.setExpression(expression);
		
		setStatement(expressionStatement);
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
