package astnodes.declarations;

import java.util.LinkedList;

import astnodes.ASTNode;
import astnodes.ASTNodeVisitor;
import astnodes.DummyName;
import astnodes.expressions.Identifier;
import astnodes.statements.CompoundItem;


public class ClassDef extends ASTNode
{
	
	public Identifier name = new DummyName();
	public CompoundItem content = new CompoundItem();
	
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
