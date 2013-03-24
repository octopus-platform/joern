package main.codeitems.functionContent;

import java.util.LinkedList;
import java.util.List;

import main.codeitems.declarations.IdentifierDecl;

public class IdentifierDeclStatement extends StatementItem
{
	List<IdentifierDecl> identifierDeclList = new LinkedList<IdentifierDecl>();

	public void addDeclaration(IdentifierDecl decl)
	{
		identifierDeclList.add(decl);
	}
	
}
