package main.codeitems.declarations;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.DummyName;
import main.codeitems.Name;
import main.codeitems.functionContent.CompoundItem;

public class ClassDef extends CodeItem
{
	
	public Name name = new DummyName();
	public CompoundItem content = new CompoundItem();
	
	public ClassDef()
	{
		setNodeTypeName("class");
		codeStr = "";
	}
	
	public Name getName()
	{
		return name;
	}

	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
	
}
