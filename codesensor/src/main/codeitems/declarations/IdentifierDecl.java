package main.codeitems.declarations;

import main.codeitems.CodeItem;
import main.codeitems.Name;


public class IdentifierDecl extends CodeItem
{
	public IdentifierDeclType type;
	public Name name;
	
	public IdentifierDecl()
	{
		nodeTypeName = "DECL";
	}
	
	
}
