package ast.declarations;

import ast.ASTNode;
import ast.expressions.Identifier;

public class IdentifierDecl extends ASTNode
{
	private IdentifierDeclType type;
	private Identifier name;

	public void addChild(ASTNode node)
	{
		if (node instanceof Identifier)
		{
			setName((Identifier) node);
			return;
		}
		super.addChild(node);
	}

	public void setName(Identifier name)
	{
		this.name = name;
		super.addChild(name);
	}

	public void setType(IdentifierDeclType type)
	{
		this.type = type;
		super.addChild(type);
	}

	public Identifier getName()
	{
		return name;
	}

	public IdentifierDeclType getType()
	{
		return type;
	}

}
