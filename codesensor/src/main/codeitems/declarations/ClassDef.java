package main.codeitems.declarations;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.Name;

public class ClassDef extends CodeItem{
	
	public Name name;
	
	public ClassDef()
	{
		nodeTypeName = "CLASS_DEF";
		codeStr = "";
	}
	
	public Name getName()
	{
		return name;
	}

	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
	
}
