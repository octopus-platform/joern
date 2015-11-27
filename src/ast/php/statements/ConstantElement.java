package ast.php.statements;

import ast.ASTNode;
import ast.logical.statements.Statement;

public class ConstantElement extends Statement
{
	private ASTNode name = null;
	private ASTNode value = null;

	public ASTNode getNameChild()
	{
		return this.name;
	}
	
	public void setNameChild(ASTNode name)
	{
		this.name = name;
		super.addChild(name);
	}
	
	public ASTNode getValue()
	{
		return this.value;
	}
	
	public void setValue(ASTNode value)
	{
		this.value = value;
		super.addChild(value);
	}
}
