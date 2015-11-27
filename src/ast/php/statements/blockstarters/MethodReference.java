package ast.php.statements.blockstarters;

import ast.ASTNode;
import ast.expressions.Identifier;

public class MethodReference extends ASTNode
{
	private Identifier classIdentifier = null;
	private ASTNode methodName = null;
	
	public Identifier getClassIdentifier()
	{
		return this.classIdentifier;
	}

	public void setClassIdentifier(Identifier classIdentifier)
	{
		this.classIdentifier = classIdentifier;
		super.addChild(classIdentifier);
	}
	
	public ASTNode getMethodName()
	{
		return this.methodName;
	}

	public void setMethodName(ASTNode methodName)
	{
		this.methodName = methodName;
		super.addChild(methodName);
	}
}
