package languages.php.cfg;

import ast.php.statements.blockstarters.ForEachStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.IfStatement;
import ast.statements.blockstarters.WhileStatement;
import cfg.CFGFactory;
import cfg.StructuredFlowVisitor;


public class PHPStructuredFlowVisitor extends StructuredFlowVisitor  {

	@Override
	public void visit(IfStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
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

}
