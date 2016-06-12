package ast.statements.blockstarters;

import ast.expressions.Expression;
import ast.logical.statements.BlockStarterWithStmtAndCnd;
import ast.walking.ASTNodeVisitor;

public class ForEachStatement extends BlockStarterWithStmtAndCnd
{
	// a ForEachStatement has four children: three in its predicate, and a statement list
	// the three children in its predicate are saved in a ForEachCondition container for technical reasons
	// (for CFG generation, such that we can treat ForEachStatement's exactly as we treat WhileStatement's)
	private ForEachCondition condition = new ForEachCondition();

	@Override
	public ForEachCondition getCondition()
	{
		return this.condition;
	}

	@Override
	public void setCondition(Expression expression)
	{
		if( ! (expression instanceof ForEachCondition))
			throw new RuntimeException("The condition of a ForEachStatement must be a ForEachCondition!");
		else {
			this.condition = (ForEachCondition)expression;
		}
	}

	public Expression getIteratedObject()
	{
		return this.condition.getIteratedObject();
	}

	public void setIteratedObject(Expression expression)
	{
		this.condition.setIteratedObject(expression);
		super.addChild(expression);
	}

	public Expression getValueExpression()
	{
		return this.condition.getValueExpression();
	}

	public void setValueExpression(Expression value)
	{
		this.condition.setValueExpression(value);
		super.addChild(value);
	}

	public Expression getKeyExpression()
	{
		return this.condition.getKeyExpression();
	}

	public void setKeyExpression(Expression key)
	{
		this.condition.setKeyExpression(key);
		super.addChild(key);
	}

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
