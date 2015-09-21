package ast.functionDef;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.walking.ASTNodeVisitor;

public class Parameter extends ASTNode
{
	private ParameterType type = new ParameterType();
	private Identifier name = new Identifier();

	public void addChild(ASTNode node)
	{
		if (node instanceof ParameterType)
			setType((ParameterType) node);
		else if (node instanceof Identifier)
			setName((Identifier) node);

		super.addChild(node);
	}

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

	public ParameterType getType()
	{
		return type;
	}

	private void setType(ParameterType type)
	{
		this.type = type;
	}

	public Identifier getName()
	{
		return name;
	}

	private void setName(Identifier name)
	{
		this.name = name;
	}
}
