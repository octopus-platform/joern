package ast.php.statements;

import ast.ASTNode;
import ast.logical.statements.Statement;

public class StaticVariableDeclaration extends Statement
{
	private ASTNode name = null;
	private ASTNode defaultvalue = null; // TODO make this an Expression

	public ASTNode getNameChild()
	{
		return this.name;
	}
	
	public void setNameChild(ASTNode name)
	{
		this.name = name;
		super.addChild(name);
	}
	
	public ASTNode getDefault() // TODO make this an Expression
	{
		return this.defaultvalue;
	}
	
	public void setDefault(ASTNode defaultvalue) // TODO make this an Expression
	{
		this.defaultvalue = defaultvalue;
		super.addChild(defaultvalue);
	}
}
