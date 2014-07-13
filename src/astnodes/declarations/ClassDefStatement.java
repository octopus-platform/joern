package astnodes.declarations;

import astnodes.ASTNode;
import astnodes.DummyNameNode;
import astnodes.expressions.Identifier;
import astnodes.statements.CompoundStatement;
import astnodes.statements.Statement;
import astwalking.ASTNodeVisitor;

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
