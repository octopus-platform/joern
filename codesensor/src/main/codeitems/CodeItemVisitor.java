package main.codeitems;

import main.codeitems.declarations.ClassDef;

import main.codeitems.function.FunctionDef;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

public class CodeItemVisitor
{
	public void visit(CodeItem item) {}
	
	public void visit(FunctionDef item) { defaultHandler(item); }
	public void visit(ClassDef item){ defaultHandler(item); }
	public void visit(IdentifierDeclStatement statementItem){ defaultHandler(statementItem); }
	public void visit(ExprStatementItem statementItem){ defaultHandler(statementItem); }
	
	public void defaultHandler(CodeItem item)
	{
		visitChildren(item);
	}
	
	public void visitChildren(CodeItem item)
	{
		int nChildren = item.getChildCount();
		
		for(int i = 0; i < nChildren; i++){
			CodeItem child = item.getChild(i);
			child.accept(this);
		}
		
	}
	
}
