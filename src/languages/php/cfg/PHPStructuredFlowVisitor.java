package languages.php.cfg;

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
import cfg.StructuredFlowVisitor;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;

public class PHPStructuredFlowVisitor extends StructuredFlowVisitor
{

	@Override
	public void visit(ParameterList paramList)
	{
		returnCFG = PHPCFGFactory.newInstance(paramList);
	}

	@Override
	public void visit(Parameter param)
	{
		returnCFG = PHPCFGFactory.newInstance(param);

		for (CFGNode node : returnCFG.getVertices())
		{
			if (!(node instanceof ASTNodeContainer))
				continue;
			returnCFG.registerParameter(node);
		}

	}

	@Override
	public void visit(CompoundStatement content)
	{
		returnCFG = PHPCFGFactory.newInstance(content);
	}

	@Override
	public void visit(ASTNode expression)
	{
		returnCFG = PHPCFGFactory.newInstance(expression);
	}

	@Override
	public void visit(ReturnStatement expression)
	{
		returnCFG = PHPCFGFactory.newInstance(expression);
	}

	@Override
	public void visit(GotoStatement expression)
	{
		returnCFG = PHPCFGFactory.newInstance(expression);
	}

	@Override
	public void visit(IfStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

	@Override
	public void visit(ForStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

	@Override
	public void visit(WhileStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

	@Override
	public void visit(DoStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

	@Override
	public void visit(SwitchStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

	@Override
	public void visit(Label node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

	@Override
	public void visit(ContinueStatement expression)
	{
		returnCFG = PHPCFGFactory.newInstance(expression);
	}

	@Override
	public void visit(BreakStatement expression)
	{
		returnCFG = PHPCFGFactory.newInstance(expression);
	}

	@Override
	public void visit(TryStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

	@Override
	public void visit(ThrowStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

}
