package astnodes.statements;

import parsing.ParseTreeUtils;
import astwalking.ASTNodeVisitor;

public class Condition extends ExpressionHolder
{	
	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }
}
