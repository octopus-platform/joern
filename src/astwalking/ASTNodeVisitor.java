package astwalking;

import astnodes.ASTNode;
import astnodes.declarations.ClassDefStatement;
import astnodes.expressions.Argument;
import astnodes.expressions.AssignmentExpr;
import astnodes.expressions.CallExpression;
import astnodes.expressions.Identifier;
import astnodes.expressions.MemberAccess;
import astnodes.expressions.PrimaryExpression;
import astnodes.expressions.UnaryExpression;
import astnodes.functionDef.FunctionDef;
import astnodes.functionDef.ParameterList;
import astnodes.statements.BreakStatement;
import astnodes.statements.CompoundStatement;
import astnodes.statements.Condition;
import astnodes.statements.ContinueStatement;
import astnodes.statements.DoStatement;
import astnodes.statements.ExpressionStatement;
import astnodes.statements.ForStatement;
import astnodes.statements.GotoStatement;
import astnodes.statements.IdentifierDeclStatement;
import astnodes.statements.IfStatement;
import astnodes.statements.Label;
import astnodes.statements.ReturnStatement;
import astnodes.statements.SwitchStatement;
import astnodes.statements.WhileStatement;

public class ASTNodeVisitor
{
	public void visit(ASTNode item)
	{
		visitChildren(item);
	}

	public void visit(ParameterList item)
	{
		defaultHandler(item);
	}

	public void visit(FunctionDef item)
	{
		defaultHandler(item);
	}

	public void visit(ClassDefStatement item)
	{
		defaultHandler(item);
	}

	public void visit(IdentifierDeclStatement statementItem)
	{
		defaultHandler(statementItem);
	}

	public void visit(ExpressionStatement statementItem)
	{
		defaultHandler(statementItem);
	}

	public void visit(CallExpression expression)
	{
		defaultHandler(expression);
	}

	public void visit(Condition expression)
	{
		defaultHandler(expression);
	}

	public void visit(AssignmentExpr expression)
	{
		defaultHandler(expression);
	}

	public void visit(PrimaryExpression expression)
	{
		defaultHandler(expression);
	}

	public void visit(Identifier expression)
	{
		defaultHandler(expression);
	}

	public void visit(MemberAccess expression)
	{
		defaultHandler(expression);
	}

	public void visit(UnaryExpression expression)
	{
		defaultHandler(expression);
	}

	public void visit(Argument expression)
	{
		defaultHandler(expression);
	}

	public void visit(ReturnStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(GotoStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(ContinueStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(BreakStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(CompoundStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(IfStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(ForStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(WhileStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(DoStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(Label expression)
	{
		defaultHandler(expression);
	}

	public void visit(SwitchStatement expression)
	{
		defaultHandler(expression);
	}

	public void defaultHandler(ASTNode item)
	{
		// by default, redirect to visit(ASTNode item)
		visit((ASTNode) item);
	}

	public void visitChildren(ASTNode item)
	{
		int nChildren = item.getChildCount();

		for (int i = 0; i < nChildren; i++)
		{
			ASTNode child = item.getChild(i);
			child.accept(this);
		}

	}

}
