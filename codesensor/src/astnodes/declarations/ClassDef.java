package astnodes.declarations;

import java.util.LinkedList;

import astnodes.ASTNode;
import astnodes.DummyNameNode;
import astnodes.expressions.Identifier;
import astnodes.statements.CompoundStatement;
import astwalking.ASTNodeVisitor;


public class ClassDef extends ASTNode
{
	
	public Identifier name = new DummyNameNode();
	public CompoundStatement content = new CompoundStatement();
	
	public ClassDef()
	{
		setNodeTypeName("class");
		codeStr = "";
	}
	
	public void addChild(ASTNode expression)
	{ 
		if(expression instanceof Identifier)
			name = (Identifier) expression;
		else
			super.addChild(expression);
	}
	
	public Identifier getName()
	{
		return name;
	}

	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }
	
}
