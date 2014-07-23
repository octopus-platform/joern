package cfg;

import astnodes.ASTNode;
import astnodes.functionDef.ParameterList;
import astnodes.statements.BreakStatement;
import astnodes.statements.CompoundStatement;
import astnodes.statements.ContinueStatement;
import astnodes.statements.DoStatement;
import astnodes.statements.ForStatement;
import astnodes.statements.GotoStatement;
import astnodes.statements.IfStatement;
import astnodes.statements.Label;
import astnodes.statements.ReturnStatement;
import astnodes.statements.SwitchStatement;
import astnodes.statements.WhileStatement;
import astwalking.ASTNodeVisitor;

// This visitor is used to create a CFG from an AST
// while considering only structured control flow statements,
// e.g., for, while, do.

// Once the CFG has been created using this Visitor, the
// JumpStatementVisitor is used to account for unstructured
// control flow statements, e.g., return, goto, continue, break.

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
