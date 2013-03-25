package main.codeitems.functionContent;

import java.util.LinkedList;
import java.util.List;

import main.codeitems.declarations.IdentifierDecl;

public class IdentifierDeclStatement extends StatementItem
{
	public List<IdentifierDecl> identifierDeclList = new LinkedList<IdentifierDecl>();
	
	public void addDeclaration(IdentifierDecl decl)
	{
		identifierDeclList.add(decl);
	}

	public void accept(StatementVisitor visitor){ visitor.visit(this); }
	
}
