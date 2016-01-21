package languages.php.cfg;

import ast.functionDef.Parameter;
import ast.functionDef.ParameterList;
import ast.logical.statements.Label;
import ast.php.statements.blockstarters.ForEachStatement;
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
import cfg.CFGFactory;
import cfg.StructuredFlowVisitor;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;
import languages.c.cfg.CCFGFactory;


public class PHPStructuredFlowVisitor extends StructuredFlowVisitor  {

	@Override
	public void visit(ParameterList paramList)
	{
		returnCFG = CCFGFactory.newInstance(paramList);
	}

	@Override
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

	@Override
	public void visit(IfStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

	@Override
	public void visit(Label node)
	{
		returnCFG = CFGFactory.newInstance(node);
	}

	@Override
	public void visit(WhileStatement node)
	{
		returnCFG = CFGFactory.newInstance(node);
	}

	@Override
	public void visit(DoStatement node)
	{
		returnCFG = CFGFactory.newInstance(node);
	}

	@Override
	public void visit(ForStatement node)
	{
		returnCFG = CFGFactory.newInstance(node);
	}

	@Override
	public void visit(ForEachStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

	@Override
	public void visit(ReturnStatement expression)
	{
		returnCFG = CFGFactory.newInstance(expression);
	}

	@Override
	public void visit(GotoStatement expression)
	{
		returnCFG = CFGFactory.newInstance(expression);
	}

	@Override
	public void visit(SwitchStatement node)
	{
		returnCFG = CFGFactory.newInstance(node);
	}

	@Override
	public void visit(ContinueStatement expression)
	{
		returnCFG = CFGFactory.newInstance(expression);
	}

	@Override
	public void visit(BreakStatement expression)
	{
		returnCFG = CFGFactory.newInstance(expression);
	}

	@Override
	public void visit(TryStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

	@Override
	public void visit(ThrowStatement node)
	{
		returnCFG = CFGFactory.newInstance(node);
	}

}
