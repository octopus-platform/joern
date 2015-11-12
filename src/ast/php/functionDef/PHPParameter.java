package ast.php.functionDef;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.functionDef.Parameter;

public class PHPParameter extends Parameter
{
	private Identifier type = null;
	private ASTNode name = null;
	private ASTNode defaultvalue = null;

	@Override
	public Identifier getType()
	{
		return this.type;
	}
	
	@Override
	public void setType(ASTNode type)
	{
		if( type instanceof Identifier)
			this.type = (Identifier)type;
		super.addChild(type);
	}
	
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
