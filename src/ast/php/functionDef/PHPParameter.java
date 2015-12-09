package ast.php.functionDef;

import ast.ASTNode;
import ast.expressions.Expression;
import ast.expressions.Identifier;
import ast.expressions.StringExpression;
import ast.functionDef.Parameter;

public class PHPParameter extends Parameter
{
	private Identifier type = null;
	private StringExpression name = null;
	private Expression defaultvalue = null;

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
	
	public StringExpression getNameChild()
	{
		return this.name;
	}
	
	public void setNameChild(StringExpression name)
	{
		this.name = name;
		super.addChild(name);
	}
	
	public Expression getDefault()
	{
		return this.defaultvalue;
	}
	
	public void setDefault(Expression defaultvalue)
	{
		this.defaultvalue = defaultvalue;
		super.addChild(defaultvalue);
	}
}
