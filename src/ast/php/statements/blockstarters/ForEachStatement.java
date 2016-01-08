package ast.php.statements.blockstarters;

import ast.expressions.Expression;
import ast.expressions.Variable;
import ast.logical.statements.BlockStarter;
import ast.walking.ASTNodeVisitor;

public class ForEachStatement extends BlockStarter
{
	private Expression iteratedObject = null;
	private Variable key = null;
	private Expression value = null;

	@Override
	public Expression getCondition()
	{
		throw new RuntimeException("A condition does not exist for a ForEachStatement!");
	}

	@Override
	public void setCondition(Expression expression)
	{
		throw new RuntimeException("A condition does not exist for a ForEachStatement!");
	}

	public Expression getIteratedObject()
	{
		return this.iteratedObject;
	}

	public void setIteratedObject(Expression expression)
	{
		this.iteratedObject = expression;
		super.addChild(expression);
	}

	public Expression getValueExpression()
	{
		return this.value;
	}

	public void setValueExpression(Expression value)
	{
		this.value = value;
		super.addChild(value);
	}

	public Variable getKeyVariable()
	{
		return this.key;
	}

	public void setKeyVariable(Variable key)
	{
		this.key = key;
		super.addChild(key);
	}

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
