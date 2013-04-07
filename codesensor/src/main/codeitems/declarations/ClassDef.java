package main.codeitems.declarations;

import java.util.LinkedList;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.DummyName;
import main.codeitems.Identifier;
import main.codeitems.statements.CompoundItem;

public class ClassDef extends CodeItem
{
	
	public Identifier name = new DummyName();
	public CompoundItem content = new CompoundItem();
	
	public ClassDef()
	{
		setNodeTypeName("class");
		codeStr = "";
	}
		
	public Identifier getName()
	{
		return name;
	}

	public void addChild(CodeItem expression)
	{ 
		if(expression instanceof Identifier)
			name = (Identifier) expression;
		super.addChild(expression);
	}
	
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
	
}
