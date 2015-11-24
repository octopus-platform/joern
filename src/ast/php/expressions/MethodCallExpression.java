package ast.php.expressions;

import ast.ASTNode;
import ast.expressions.CallExpression;
import ast.expressions.Identifier;

public class MethodCallExpression extends CallExpression
{
	private ASTNode targetObject = null; // TODO make this an Expression once mapping is finished
	
	public ASTNode getTargetObject() // TODO return Expression
	{
		return this.targetObject;
	}
	
	public void setTargetObject(ASTNode targetObject) // TODO take Expression
	{
		this.targetObject = targetObject;
		super.addChild(targetObject);
	}
}
