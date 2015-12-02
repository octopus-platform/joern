package ast.expressions;

import ast.ASTNode;

public class NewExpression extends CallExpression
{
	private ASTNode targetClass = null; // TODO change type to Expression once the mapping is finished
	
	public ASTNode getTargetClass() // TODO change type to Expression
	{
		return this.targetClass;
	}
	
	public void setTargetClass(ASTNode targetClass) // TODO change type to Expression
	{
		this.targetClass = targetClass;
		super.addChild(targetClass);
	}
}
