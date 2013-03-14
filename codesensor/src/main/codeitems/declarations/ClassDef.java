package main.codeitems.declarations;

import main.codeitems.CodeItem;
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
	
}
