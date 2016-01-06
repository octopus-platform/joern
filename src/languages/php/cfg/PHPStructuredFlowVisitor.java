package languages.php.cfg;

import ast.statements.blockstarters.IfStatement;
import cfg.StructuredFlowVisitor;


public class PHPStructuredFlowVisitor extends StructuredFlowVisitor  {

	@Override
	public void visit(IfStatement node)
	{
		returnCFG = PHPCFGFactory.newInstance(node);
	}

}
