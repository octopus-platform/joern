package ast.functionDef;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.walking.ASTNodeVisitor;

public class Parameter extends ASTNode
{
	private ParameterType type = new ParameterType();
	private Identifier identifier = new Identifier();

	public void addChild(ASTNode node)
	{
		// Note: 2 children for C ASTs: ParameterType and Identifier.
		if (node instanceof ParameterType)
			setType((ParameterType) node);
		else if (node instanceof Identifier)
			setIdentifier((Identifier) node);
		else
			super.addChild(node);
	}

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

	// for C ASTs, this returns a ParameterType
	// for PHP ASTs, this returns an Identifier
	public ASTNode getType()
	{
		return type;
	}

	public void setType(ASTNode type)
	{
		if( type instanceof ParameterType)
			this.type = (ParameterType)type;
		super.addChild(type);
	}

	// for C ASTs, returns the name
	// for PHP ASTs, undefined: we use getNameChild() instead, see PHPParameter class
	public Identifier getIdentifier()
	{
		return identifier;
	}

	private void setIdentifier(Identifier identifier)
	{
		this.identifier = identifier;
		super.addChild(identifier);
	}
}
