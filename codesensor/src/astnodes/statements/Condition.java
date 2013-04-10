package astnodes.statements;

import astnodes.ASTNodeVisitor;
import tools.index.ParseTreeUtils;

public class Condition extends ExpressionHolder
{	
	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }
}
