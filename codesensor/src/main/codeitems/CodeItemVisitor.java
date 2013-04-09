package main.codeitems;

import main.codeitems.declarations.ClassDef;
import main.codeitems.expressions.AssignmentExpr;
import main.codeitems.expressions.CallExpression;
import main.codeitems.expressions.MemberAccess;
import main.codeitems.expressions.PrimaryExpression;
import main.codeitems.expressions.UnaryExpression;

import main.codeitems.functionDef.FunctionDef;
import main.codeitems.statements.Condition;
import main.codeitems.statements.ExprStatementItem;
import main.codeitems.statements.IdentifierDeclStatement;

public class CodeItemVisitor
{
	public void visit(CodeItem item) { defaultHandler(item); }
	
	public void visit(FunctionDef item) { defaultHandler(item); }
	public void visit(ClassDef item){ defaultHandler(item); }
	public void visit(IdentifierDeclStatement statementItem){ defaultHandler(statementItem); }
	public void visit(ExprStatementItem statementItem){ defaultHandler(statementItem); }
	public void visit(CallExpression expression) { defaultHandler(expression); }
	public void visit(Condition expression) { defaultHandler(expression); }
	public void visit(AssignmentExpr expression) { defaultHandler(expression); }
	
	public void visit(PrimaryExpression expression) { defaultHandler(expression); }
	public void visit(MemberAccess expression) { defaultHandler(expression); }
	public void visit(UnaryExpression expression) { defaultHandler(expression); }
	
	
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
