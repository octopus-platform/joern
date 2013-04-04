package main.codeitems.functionContent;

import java.util.LinkedList;
import java.util.List;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.declarations.IdentifierDecl;

public class IdentifierDeclStatement extends CodeItem
{
	public List<IdentifierDecl> identifierDeclList = new LinkedList<IdentifierDecl>();
	
	public void addDeclaration(IdentifierDecl decl)
	{
		identifierDeclList.add(decl);
	}

	public void addChild(CodeItem item)
	{ 
		addDeclaration((IdentifierDecl) item);
	}
	
	public int getChildCount() { return identifierDeclList.size(); }
	public CodeItem getChild(int i){ return identifierDeclList.get(i); }
	
	
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
	
}
