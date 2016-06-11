package ast.php.expressions;

import ast.ASTNodeProperties;
import ast.expressions.CallExpression;
import ast.expressions.Expression;

public class MethodCallExpression extends CallExpression
{
	private Expression targetObject = null;
	
	public Expression getTargetObject()
	{
		return this.targetObject;
	}
	
	public void setTargetObject(Expression targetObject)
	{
		this.targetObject = targetObject;
		super.addChild(targetObject);
	}
	
	public String getEnclosingClass() {
		return getProperty(ASTNodeProperties.CLASSNAME);
	}
	
	public void setEnclosingClass(String classname) {
		setProperty(ASTNodeProperties.CLASSNAME, classname);
	}
}
