package ast.functionDef;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.walking.ASTNodeVisitor;

public class Parameter extends ASTNode
{
	public ParameterType type = new ParameterType();
	public Identifier name = new Identifier();

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
