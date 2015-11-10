package ast.declarations;

import ast.ASTNode;
import ast.DummyIdentifierNode;
import ast.expressions.Identifier;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Statement;

public class ClassDefStatement extends Statement
{

	public Identifier identifier = new DummyIdentifierNode();
	public CompoundStatement content = new CompoundStatement();

	public void addChild(ASTNode expression)
	{
		if (expression instanceof Identifier)
			identifier = (Identifier) expression;
		else
			super.addChild(expression);
	}

	public Identifier getIdentifier()
	{
		return identifier;
	}
}
