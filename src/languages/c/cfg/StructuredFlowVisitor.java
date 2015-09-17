package languages.c.cfg;

import ast.ASTNode;
import ast.functionDef.Parameter;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Label;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.IfStatement;
import ast.statements.blockstarters.SwitchStatement;
import ast.statements.blockstarters.TryStatement;
import ast.statements.blockstarters.WhileStatement;
import ast.statements.jump.BreakStatement;
import ast.statements.jump.ContinueStatement;
import ast.statements.jump.GotoStatement;
import ast.statements.jump.ReturnStatement;
import ast.statements.jump.ThrowStatement;
import ast.walking.ASTNodeVisitor;
import cfg.CFG;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;

class StructuredFlowVisitor extends ASTNodeVisitor
{

	private CFG returnCFG;

	CFG getCFG()
	{
		return returnCFG;
	}

	public void visit(ParameterList paramList)
	{
		returnCFG = CCFGFactory.newInstance(paramList);
	}

	public void visit(Parameter param)
	{
		returnCFG = CCFGFactory.newInstance(param);

		for (CFGNode node : returnCFG.getVertices())
		{
			if (!(node instanceof ASTNodeContainer))
				continue;
			returnCFG.registerParameter(node);
		}

	}

	public void visit(CompoundStatement content)
	{
		returnCFG = CCFGFactory.newInstance(content);
	}

	public void visit(ASTNode expression)
	{
		returnCFG = CCFGFactory.newInstance(expression);
	}

	public void visit(ReturnStatement expression)
	{
		returnCFG = CCFGFactory.newInstance(expression);
	}

	public void visit(GotoStatement expression)
	{
		returnCFG = CCFGFactory.newInstance(expression);
	}

	public void visit(IfStatement node)
	{
		returnCFG = CCFGFactory.newInstance(node);
	}

	public void visit(ForStatement node)
	{
		returnCFG = CCFGFactory.newInstance(node);
	}

	public void visit(WhileStatement node)
	{
		returnCFG = CCFGFactory.newInstance(node);
	}

	public void visit(DoStatement node)
	{
		returnCFG = CCFGFactory.newInstance(node);
	}

	public void visit(SwitchStatement node)
	{
		returnCFG = CCFGFactory.newInstance(node);
	}

	public void visit(Label node)
	{
		returnCFG = CCFGFactory.newInstance(node);
	}

	public void visit(ContinueStatement expression)
	{
		returnCFG = CCFGFactory.newInstance(expression);
	}

	public void visit(BreakStatement expression)
	{
		returnCFG = CCFGFactory.newInstance(expression);
	}

	public void visit(TryStatement node)
	{
		returnCFG = CCFGFactory.newInstance(node);
	}
	
	@Override
	public void visit(ThrowStatement node)
	{
		returnCFG = CCFGFactory.newInstance(node);
	}

}
