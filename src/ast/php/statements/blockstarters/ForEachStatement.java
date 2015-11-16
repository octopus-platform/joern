package ast.php.statements.blockstarters;

import ast.ASTNode;
import ast.expressions.Variable;
import ast.logical.statements.BlockStarter;

public class ForEachStatement extends BlockStarter
{
	private ASTNode iteratedObject = null; // TODO make this an Expression sometime
	private Variable key = null;
	private Variable value = null;

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

	public ASTNode getValueVar()
	{
		return this.value;
	}

	public void setValueVar(Variable value)
	{
		this.value = value;
		super.addChild(value);
	}
	
	public ASTNode getKeyVar()
	{
		return this.key;
	}

	public void setKeyVar(ASTNode key)
	{
		if (key instanceof Variable)
			this.key = (Variable)key;
		super.addChild(key);
	}
}
