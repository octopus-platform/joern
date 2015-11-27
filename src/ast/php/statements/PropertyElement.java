package ast.php.statements;

import ast.ASTNode;
import ast.logical.statements.Statement;

public class PropertyElement extends Statement
{
	private ASTNode name = null;
	private ASTNode defaultvalue = null;

	public ASTNode getNameChild()
	{
		return this.name;
	}
	
	public void setNameChild(ASTNode name)
	{
		this.name = name;
		super.addChild(name);
	}
	
	public ASTNode getDefault()
	{
		return this.defaultvalue;
	}
	
	public void setDefault(ASTNode defaultvalue)
	{
		this.defaultvalue = defaultvalue;
		super.addChild(defaultvalue);
	}
}
