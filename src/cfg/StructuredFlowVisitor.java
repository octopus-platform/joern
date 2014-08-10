package cfg;

import ast.ASTNode;
import ast.functionDef.ParameterList;
import ast.statements.BreakStatement;
import ast.statements.CompoundStatement;
import ast.statements.ContinueStatement;
import ast.statements.DoStatement;
import ast.statements.ForStatement;
import ast.statements.GotoStatement;
import ast.statements.IfStatement;
import ast.statements.Label;
import ast.statements.ReturnStatement;
import ast.statements.SwitchStatement;
import ast.statements.WhileStatement;
import ast.walking.ASTNodeVisitor;


class StructuredFlowVisitor extends ASTNodeVisitor
{

	private CFG returnCFG;

	CFG getCFG()
	{
		return returnCFG;
	}

	public void visit(ParameterList paramList)
	{
		returnCFG = CFG.newInstance(paramList);
	}

	public void visit(CompoundStatement content)
	{
		returnCFG = CFG.newInstance(content);
	}

	public void visit(ASTNode expression)
	{
		returnCFG = CFG.newInstance(expression);
	}

	public void visit(ReturnStatement expression)
	{
		returnCFG = CFG.newInstance(expression);
	}

	public void visit(GotoStatement expression)
	{
		returnCFG = CFG.newInstance(expression);
	}

	public void visit(IfStatement node)
	{
		returnCFG = CFG.newInstance(node);
	}

	public void visit(ForStatement node)
	{
		returnCFG = CFG.newInstance(node);
	}

	public void visit(WhileStatement node)
	{
		returnCFG = CFG.newInstance(node);
	}

	public void visit(DoStatement node)
	{
		returnCFG = CFG.newInstance(node);
	}

	public void visit(SwitchStatement node)
	{
		returnCFG = CFG.newInstance(node);
	}

	public void visit(Label node)
	{
		returnCFG = CFG.newInstance(node);
	}

	public void visit(ContinueStatement expression)
	{
		returnCFG = CFG.newInstance(expression);
	}

	public void visit(BreakStatement expression)
	{
		returnCFG = CFG.newInstance(expression);
	}
}
