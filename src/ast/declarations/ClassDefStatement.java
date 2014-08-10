package ast.declarations;

import ast.ASTNode;
import ast.DummyNameNode;
import ast.expressions.Identifier;
import ast.statements.CompoundStatement;
import ast.statements.Statement;
import ast.walking.ASTNodeVisitor;

public class ClassDefStatement extends Statement
{

	public Identifier name = new DummyNameNode();
	public CompoundStatement content = new CompoundStatement();

	public void addChild(ASTNode expression)
	{
		if (expression instanceof Identifier)
			name = (Identifier) expression;
		else
			super.addChild(expression);
	}

	public Identifier getName()
	{
		return name;
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

}
