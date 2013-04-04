package main.codeitems;

import main.codeitems.declarations.ClassDef;

import main.codeitems.function.FunctionDef;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

public interface CodeItemVisitor
{
	public void visit(CodeItem item);
	public void visit(FunctionDef item);
	public void visit(ClassDef item);
	public void visit(IdentifierDeclStatement statementItem);
	public void visit(ExprStatementItem statementItem);
	
}
