package ast.php.expressions;

import ast.ASTNode;
import ast.expressions.Expression;

public class PHPYieldExpression extends Expression
{
	private ASTNode value = null; // TODO change type to Expression once mapping is finished
	private ASTNode key = null; // TODO change type to Expression once mapping is finished

	public ASTNode getValue()
	{
		return this.value;
	}

	public void setValue(ASTNode value)
	{
		this.value = value;
		super.addChild(value);
	}
	
	public ASTNode getKey()
	{
		return this.key;
	}
	
	public void setKey(ASTNode key)
	{
		this.key = key;
		super.addChild(key);
	}
}
