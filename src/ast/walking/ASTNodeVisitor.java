package ast.walking;

import java.util.Stack;

import ast.ASTNode;
import ast.declarations.ClassDefStatement;
import ast.expressions.Argument;
import ast.expressions.AssignmentExpr;
import ast.expressions.CallExpression;
import ast.expressions.Identifier;
import ast.expressions.MemberAccess;
import ast.expressions.PrimaryExpression;
import ast.expressions.UnaryExpression;
import ast.functionDef.FunctionDef;
import ast.functionDef.Parameter;
import ast.functionDef.ParameterList;
import ast.statements.BreakStatement;
import ast.statements.CompoundStatement;
import ast.statements.Condition;
import ast.statements.ContinueStatement;
import ast.statements.DoStatement;
import ast.statements.ExpressionStatement;
import ast.statements.ForStatement;
import ast.statements.GotoStatement;
import ast.statements.IdentifierDeclStatement;
import ast.statements.IfStatement;
import ast.statements.Label;
import ast.statements.ReturnStatement;
import ast.statements.SwitchStatement;
import ast.statements.WhileStatement;
import databaseNodes.FileDatabaseNode;

public class ASTNodeVisitor
{
	protected FileDatabaseNode currentFileNode;
	protected Stack<Long> contextStack;

	public void handleStartOfUnit(FileDatabaseNode aCurrentFileNode)
	{
		currentFileNode = aCurrentFileNode;
		contextStack = new Stack<Long>();
	}
	
	public void visit(ASTNode item)
	{
		visitChildren(item);
	}

	public void visit(ParameterList item)
	{
		defaultHandler(item);
	}

	public void visit(Parameter item)
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
