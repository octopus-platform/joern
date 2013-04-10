package astwalking;

import astnodes.ASTNode;
import astnodes.declarations.ClassDef;
import astnodes.expressions.Argument;
import astnodes.expressions.AssignmentExpr;
import astnodes.expressions.CallExpression;
import astnodes.expressions.MemberAccess;
import astnodes.expressions.PrimaryExpression;
import astnodes.expressions.UnaryExpression;
import astnodes.functionDef.FunctionDef;
import astnodes.statements.Condition;
import astnodes.statements.ExprStatement;
import astnodes.statements.IdentifierDeclStatement;


public class ASTNodeVisitor
{
	public void visit(ASTNode item) { visitChildren(item); }
	
	public void visit(FunctionDef item) { defaultHandler(item); }
	public void visit(ClassDef item){ defaultHandler(item); }
	public void visit(IdentifierDeclStatement statementItem){ defaultHandler(statementItem); }
	public void visit(ExprStatement statementItem){ defaultHandler(statementItem); }
	public void visit(CallExpression expression) { defaultHandler(expression); }
	public void visit(Condition expression) { defaultHandler(expression); }
	public void visit(AssignmentExpr expression) { defaultHandler(expression); }
	
	public void visit(PrimaryExpression expression) { defaultHandler(expression); }
	public void visit(MemberAccess expression) { defaultHandler(expression); }
	public void visit(UnaryExpression expression) { defaultHandler(expression); }
	public void visit(Argument expression) { defaultHandler(expression); }
	
	
	public void defaultHandler(ASTNode item)
	{
		visit((ASTNode) item);
	}
	
	public void visitChildren(ASTNode item)
	{
		int nChildren = item.getChildCount();
		
		for(int i = 0; i < nChildren; i++){
			ASTNode child = item.getChild(i);
			child.accept(this);
		}
		
	}
	
}
