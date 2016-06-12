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
			setName((Identifier) node);
		else if (node instanceof IdentifierDeclType)
			setType((IdentifierDeclType) node);

		super.addChild(node);
	}

	private void setName(Identifier name)
	{
		this.name = name;
	}

	private void setType(IdentifierDeclType type)
	{
		this.type = type;
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
