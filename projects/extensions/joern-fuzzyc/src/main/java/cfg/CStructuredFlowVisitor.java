package cfg;


import ast.functionDef.ParameterBase;
import ast.functionDef.ParameterList;
import ast.logical.statements.Label;
import ast.statements.blockstarters.DoStatement;
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
import cfg.StructuredFlowVisitor;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;

public class CStructuredFlowVisitor extends StructuredFlowVisitor {

	public void visit(ParameterList paramList)
	{
		returnCFG = CCFGFactory.newInstance(paramList);
	}

	public void visit(ParameterBase param)
	{
		returnCFG = CCFGFactory.newInstance(param);

		for (CFGNode node : returnCFG.getVertices())
		{
			if (!(node instanceof ASTNodeContainer))
				continue;
			returnCFG.registerParameter(node);
		}

	}

	public void visit(ReturnStatement expression)
	{
		returnCFG = CCFGFactory.newInstance(expression);
	}

	public void visit(GotoStatement expression)
	{
		returnCFG = CCFGFactory.newInstance(expression);
	}

	public void visit(IfStatementBase node)
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
