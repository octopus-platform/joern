package main.codeitems.declarations;

import main.codeitems.CodeItemVisitor;
import main.codeitems.Name;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.StatementItem;

public class ClassDef extends StatementItem{
	
	public Name name;
	public CompoundItem content;
	
	public ClassDef()
	{
		nodeTypeName = "class";
		codeStr = "";
	}
	
	public Name getName()
	{
		return name;
	}

	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
	
}
