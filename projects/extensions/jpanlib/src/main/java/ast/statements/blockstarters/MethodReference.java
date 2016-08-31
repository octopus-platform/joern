package ast.statements.blockstarters;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.expressions.StringExpression;

public class MethodReference extends ASTNode
{
	private Identifier classIdentifier = null;
	private StringExpression methodName = null;
	
	public Identifier getClassIdentifier()
	{
		return this.classIdentifier;
	}

	public void setClassIdentifier(Identifier classIdentifier)
	{
		this.classIdentifier = classIdentifier;
		super.addChild(classIdentifier);
	}
	
	public StringExpression getMethodName()
	{
		return this.methodName;
	}

	public void setMethodName(StringExpression methodName)
	{
		this.methodName = methodName;
		super.addChild(methodName);
	}
}
