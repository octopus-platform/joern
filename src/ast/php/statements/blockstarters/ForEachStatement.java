package ast.php.statements.blockstarters;

import ast.ASTNode;
import ast.expressions.Expression;
import ast.expressions.Variable;
import ast.logical.statements.BlockStarter;

public class ForEachStatement extends BlockStarter
{
	private ASTNode iteratedObject = null; // TODO make this an Expression sometime
	private Variable key = null;
	private Expression value = null;

	@Override
	public ASTNode getCondition()
	{
		return null;
	}

	@Override
	public void setCondition(ASTNode expression)
	{
	}
	
	public ASTNode getIteratedObject()
	{
		return this.iteratedObject;
	}

	public void setIteratedObject(ASTNode expression)
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
}
