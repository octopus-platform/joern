package ast.declarations;

import ast.ASTNode;
import ast.DummyIdentifierNode;
import ast.expressions.Identifier;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Statement;
import ast.walking.ASTNodeVisitor;

public class ClassDefStatement extends Statement
{

	public Identifier identifier = new DummyIdentifierNode();
	public CompoundStatement content = new CompoundStatement();

	public void addChild(ASTNode expression)
	{
		if (expression instanceof Identifier)
			identifier = (Identifier) expression;

		super.addChild(expression);
	}

	public Identifier getIdentifier()
	{
		return identifier;
	}
	
	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
