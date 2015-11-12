package ast.logical.statements;

import ast.ASTNode;

public class BlockStarter extends Statement
{
	protected ASTNode condition = null;
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
	
	// for C, getStatement() and setStatement()
	public Statement getStatement()
	{
		return this.statement;
	}
	
	public void setStatement(Statement statement)
	{
		this.statement = statement;
		super.addChild(statement);
	}
	
	// for PHP, getContent() and setContent()
	public CompoundStatement getContent()
	{
		return (CompoundStatement)this.statement;
	}
	
	public void setContent(CompoundStatement content)
	{
		this.statement = content;
		super.addChild(content);
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
