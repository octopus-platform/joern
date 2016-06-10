package ast.c.functionDef;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.functionDef.Parameter;

public class CParameter extends Parameter
{
	private CParameterType type = new CParameterType();
	private Identifier identifier = new Identifier();

	public CParameterType getType()
	{
		return type;
	}

	public void setType(ASTNode type)
	{
		if( type instanceof CParameterType)
			this.type = (CParameterType)type;
		super.addChild(type);
	}
	
	@Override
	public String getName() {
		return this.getIdentifier().getEscapedCodeStr();
	}
	
	public Identifier getIdentifier()
	{
		return this.identifier;
	}

	private void setIdentifier(Identifier identifier)
	{
		this.identifier = identifier;
		super.addChild(identifier);
	}
	
	public void addChild(ASTNode node)
	{
		if (node instanceof CParameterType)
			setType((CParameterType) node);
		else if (node instanceof Identifier)
			setIdentifier((Identifier) node);
		else
			super.addChild(node);
	}
}
