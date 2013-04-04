package main.codeitems;

import main.codeitems.declarations.ClassDef;

import main.codeitems.function.FunctionDef;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

public abstract class CodeItemVisitor
{
	public abstract void visit(CodeItem item);
	public abstract void visit(FunctionDef item);
	public abstract void visit(ClassDef item);
	public abstract void visit(IdentifierDeclStatement statementItem);
	public abstract void visit(ExprStatementItem statementItem);
	
	
	public void visitChildren(CodeItem item)
	{
		int nChildren = item.getChildCount();
		
		for(int i = 0; i < nChildren; i++){
			CodeItem child = item.getChild(i);
			child.accept(this);
		}
		
	}
	
}
