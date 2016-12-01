package ast.walking;

import java.util.Stack;

import ast.ASTNode;
import ast.declarations.ClassDefStatement;
import ast.expressions.Argument;
import ast.expressions.AssignmentExpression;
import ast.expressions.CallExpressionBase;
import ast.expressions.Identifier;
import ast.expressions.MemberAccess;
import ast.expressions.PrimaryExpression;
import ast.expressions.UnaryExpression;
import ast.functionDef.FunctionDefBase;
import ast.functionDef.ParameterBase;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Condition;
import ast.logical.statements.Label;
import ast.statements.ExpressionStatement;
import ast.statements.IdentifierDeclStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForEachStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.IfStatementBase;
import ast.statements.blockstarters.SwitchStatement;
import ast.statements.blockstarters.TryStatement;
import ast.statements.blockstarters.WhileStatement;
import ast.statements.jump.BreakStatement;
import ast.statements.jump.ContinueStatement;
import ast.statements.jump.GotoStatement;
import ast.statements.jump.ReturnStatement;
import ast.statements.jump.ThrowStatement;
import databaseNodes.FileDatabaseNode;

public abstract class ASTNodeVisitor
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

	public void visit(ParameterBase item)
	{
		defaultHandler(item);
	}

	public void visit(FunctionDefBase item)
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

	public void visit(CallExpressionBase expression)
	{
		defaultHandler(expression);
	}

	public void visit(Condition expression)
	{
		defaultHandler(expression);
	}

	public void visit(AssignmentExpression expression)
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

	public void visit(IfStatementBase expression)
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

	public void visit(TryStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(ThrowStatement expression)
	{
		defaultHandler(expression);
	}

	public void visit(ForEachStatement node)
	{
		defaultHandler(node);
	}

	public void defaultHandler(ASTNode item)
	{
		// by default, redirect to visit(ASTNode item)
		visit(item);
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
